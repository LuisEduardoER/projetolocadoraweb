package model.dao;

import java.util.Properties;


/**
 * Exemplo de implementacao de Factory com carga dinamica de classes.
 * 
 * BENEFICIO: Remove totalmente a dependencia entre Factory e Implementacoes de
 * DAO. Observem que nao existe import de classes
 * 
 * @author Rogerio A. Rondini
 * 
 */
public class DaoFactoryDinamico {

	private static Properties p = null;

	private static String C_CHAVE_VEICULO = "dao.veiculo.impl";
	private static String C_CHAVE_FORMA_PAGAMENTO = "dao.formaPagamento.impl";
	private static String C_CHAVE_LOCACAO = "dao.locacao.impl";
	private static String C_CHAVE_CLIENTE = "dao.cliente.impl";
	
	public static VeiculoDao obterVeiculoDao(){

		return (VeiculoDao) obtemDao(C_CHAVE_VEICULO);
	}
	
	public static FormaPgtoDao obterFormaPagamentoDao(){
		return (FormaPgtoDao) obtemDao(C_CHAVE_FORMA_PAGAMENTO);
	}
	
	public static RealizarLocacaoDao obterLocacaoDao(){
		return (RealizarLocacaoDao) obtemDao(C_CHAVE_LOCACAO);
	}

	public static ClienteDaoInterface obterClienteDao() {				
		return (ClienteDaoInterface) obtemDao(C_CHAVE_CLIENTE);				
	}
		
	private static Object obtemDao(String chave) {
		try {
			// carrega arquivo de configuracao de DAOs caso ainda nao tenha sido
			// carregado
			//
			if (p == null) {
				p = new Properties();
				
				p.load(DaoFactoryDinamico.class.getResourceAsStream("dao.properties"));
			}

			// obtem a configuracao
			//
			String daoImpl = p.getProperty(chave);

			// carrega DAO dinamicamente
			//
			Class c = DaoFactoryDinamico.class.getClassLoader().loadClass(daoImpl);
			System.out.println("passou no dao class");
			return c.newInstance();

		} catch (Exception e) {
			// lancando RuntimeException para nao precisar de tratamento
			// Nesse momento, ainda nao foi apresentado em sala de aula o modelo
			// de tratamento de erros do java.

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
