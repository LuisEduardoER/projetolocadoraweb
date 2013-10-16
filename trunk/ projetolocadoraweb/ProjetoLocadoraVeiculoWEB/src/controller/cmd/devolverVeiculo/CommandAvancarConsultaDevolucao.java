package controller.cmd.devolverVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.cmd.Command;

public class CommandAvancarConsultaDevolucao extends Command {

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return null;
	}
	
	
//	if(locacao == null){
//		Mensagem.entreCodigoLocacao();
//	}
//	else{
//		devolucao = new Devolucao();
//		devolucao.setAgenciaDevolucao(agenciaDevolucao);
//		devolucao.setDtaDevolucao(new Date());
//		devolucao.setLocacao(locacao);
//		consultaView.dispose();
//		if(locacao.getTipoTarifa().equals("livre")){
//			CalcularDevolucaoCtrl calcularCtrl = new CalcularDevolucaoCtrl(devolucao);
//		}
//		else{
//			TarifaControladaCtrl controladaCtrl = new TarifaControladaCtrl(devolucao);
//		}
//		
//	}
	
	
			
	

}
