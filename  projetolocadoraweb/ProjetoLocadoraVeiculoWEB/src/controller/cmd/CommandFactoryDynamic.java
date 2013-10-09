package controller.cmd;

import java.util.Properties;

//import controller.cmd.homePage.CommandManterVeiculoHPCtrl;
//import controller.cmd.manterVeiculo.CommandAlterarVeiculo;
//import controller.cmd.manterVeiculo.CommandConsultarVeiculo;
//import controller.cmd.manterVeiculo.CommandDetalhesVeiculo;
//import controller.cmd.manterVeiculo.CommandExcluirVeiculo;
//import controller.cmd.manterVeiculo.CommandIncluirVeiculo;
//import controller.cmd.manterVeiculo.CommandSalvarAlteracaoVeiculo;
//import controller.cmd.manterVeiculo.CommandSalvarInclusao;
//import controller.cmd.manterVeiculo.CommandVoltarAlteracaoVeiculo;
//import controller.cmd.manterVeiculo.CommandVoltarEdicaoVeiculo;
//import controller.cmd.manterVeiculo.CommandVoltarIncluir;
//import controller.cmd.manterVeiculo.CommandVoltarVeiculo;


public class CommandFactoryDynamic {
	
	private static Properties p = null;

	
	public static Command obterCommand(String operacao) throws Exception {
		
		return (Command) obtemCommand(operacao);	
	}
	
	
	private static Object obtemCommand(String operacao) {
		try {
			// carrega arquivo de configuracao de DAOs caso ainda nao tenha sido
			// carregado
			//
			if (p == null) {
				p = new Properties();
				
				p.load(CommandFactoryDynamic.class.getResourceAsStream("command.properties"));
			}

			// obtem a configuracao
			//
			String commandImpl = p.getProperty(operacao);

			// carrega Command dinamicamente
			//
			Class c = CommandFactoryDynamic.class.getClassLoader().loadClass(commandImpl);
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
