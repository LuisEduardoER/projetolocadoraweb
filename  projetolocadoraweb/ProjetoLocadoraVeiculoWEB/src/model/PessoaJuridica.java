//Classe PessoaJuridica
package model;

import model.dao.ClienteDao;
import model.dao.DaoFactoryDinamico;

public class PessoaJuridica extends Cliente{
	
	private String razaoSocial;

	
	public PessoaJuridica(){
		super();
		setRazaoSocial("");

	}
	
	public PessoaJuridica( String nome , String registro , String fone, String email, String razaoSocial , String nomeFantasia , String cnpj){
		super(nome , registro , fone , email);
		setRazaoSocial(razaoSocial);

	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	//Metodo responsavel por incluir um novo cliente PF
	@Override
	public void incluir()throws Exception{
		ClienteDao dao = DaoFactoryDinamico.obterClienteDao();
		dao.cadastrar(this);
	}
		
	//Metodo responsavel por alterar um cliente existente no banco de dados
	@Override
	public void alterar() throws Exception{
		ClienteDao cDAO = DaoFactoryDinamico.obterClienteDao();
		cDAO.alterar(this);
	}
		
	//Metodo responsavel por exibir os dados de um cliente
	public PessoaFisica pesquisar(){
		ClienteDao cDAO = DaoFactoryDinamico.obterClienteDao();
		return cDAO.consultarPF(getRegistro());
	}
	
	//Metodo responsave por excluir um cliente da base de dados
	@Override
	public void excluir() throws Exception{
		ClienteDao dao = DaoFactoryDinamico.obterClienteDao();
		dao.excluir(this);
	}
	
	
}
