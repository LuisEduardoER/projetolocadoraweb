package controller.cmd;

import java.util.ArrayList;


import controller.cmd.homePage.CommandManterVeiculoHPCtrl;
import controller.cmd.manterVeiculo.CommandAlterarVeiculo;
import controller.cmd.manterVeiculo.CommandConsultarVeiculo;
import controller.cmd.manterVeiculo.CommandDetalhesVeiculo;
import controller.cmd.manterVeiculo.CommandExcluirVeiculo;
import controller.cmd.manterVeiculo.CommandIncluirVeiculo;
import controller.cmd.manterVeiculo.CommandSalvarAlteracaoVeiculo;
import controller.cmd.manterVeiculo.CommandSalvarInclusao;
import controller.cmd.manterVeiculo.CommandVoltarAlteracaoVeiculo;
import controller.cmd.manterVeiculo.CommandVoltarEdicaoVeiculo;
import controller.cmd.manterVeiculo.CommandVoltarIncluir;
import controller.cmd.manterVeiculo.CommandVoltarVeiculo;


import model.Agencia;
import model.Grupo;
import model.Veiculo;


public class CommandFactory {
	
	public static Command obterCommand(String operacao) throws Exception {
			
		if ("ManterVeiculoHomePage".equals(operacao)) {
			return new CommandManterVeiculoHPCtrl();
		}
		else if("RealizarLocacaoHomePage".equals(operacao)){
			return new CommandManterVeiculoHPCtrl();
		}
		else if("consultarVeiculo".equals(operacao)){
			return new CommandConsultarVeiculo();
		}
		else if("voltarVeiculo".equals(operacao)){
			return new CommandVoltarVeiculo();
		}
		else if("incluirVeiculo".equals(operacao))
		{
			return new CommandIncluirVeiculo();
		}
		else if ("salvarInclusao".equals(operacao)) 
		{
			return new CommandSalvarInclusao();
		}
		else if("voltarIncluir".equals(operacao))
		{
			return new CommandVoltarIncluir();
		}
		else if("detalhesVeiculo".equals(operacao))
		{
			return new CommandDetalhesVeiculo();
		}
		else if("voltarEdicaoVeiculo".equals(operacao))
		{
			return new CommandVoltarEdicaoVeiculo();
		}	
		else if("alterarVeiculo".equals(operacao)){
			return new CommandAlterarVeiculo();
		}
		else if("excluirVeiculo".equals(operacao))
		{				
			return new CommandExcluirVeiculo();
		}
		else if("salvarAlteracaoVeiculo".equals(operacao))
		{
			return new CommandSalvarAlteracaoVeiculo();
		}
		else if("voltarAlteracaoVeiculo".equals(operacao))
		{
			return new CommandVoltarAlteracaoVeiculo();
		}else {
			throw new Exception("NÃ£o existe command implementado para a operaÃ§Ã£o informada");
		}
//		return null;
			
				
//		return null;
	}
	
}
