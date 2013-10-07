package controller.cmd;

import java.util.ArrayList;

import controller.cmd.homePage.CommandManterVeiculoHPCtrl;
import controller.cmd.manterVeiculo.CommandConsultarVeiculo;
import controller.cmd.manterVeiculo.CommandIncluirVeiculo;
import controller.cmd.manterVeiculo.CommandSalvarInclusao;
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
			
		}
		else if("detalhesVeiculo".equals(operacao))
		{
			
		}
		else if("voltarEdicaoVeiculo".equals(operacao))
		{
			
		}	
		else if("alterarVeiculo".equals(operacao)){
			
		}
		else if("excluirVeiculo".equals(operacao))
		{				
							
		}
		else if("salvarAlteracaoVeiculo".equals(operacao))
		{
									
		}
		else if("voltarAlteracaoVeiculo".equals(operacao))
		{
			
		}else {
			throw new Exception("NÃ£o existe command implementado para a operaÃ§Ã£o informada");
		}
		return null;
			
				
//		return null;
	}
	
}
