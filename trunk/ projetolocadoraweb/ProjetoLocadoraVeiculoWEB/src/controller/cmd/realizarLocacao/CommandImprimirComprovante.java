package controller.cmd.realizarLocacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.cmd.Command;

public class CommandImprimirComprovante extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return "HomePageView.jsp";
	}
	
	
	/*if(locacao.getClienteEscolhido().getTipo().equals("PF")){
		boolean isOk = ComprovanteLocacaoPF.imprimiComprovante(locacao);
		if(isOk == true){
			Mensagem.impressaoEfetuadaSucesso();
			comprovanteView.dispose();
		}else{
			Mensagem.impressaoNaoEfetuada();
		}
	}else{
		boolean isOk = ComprovanteLocacaoPJ.imprimiComprovante(locacao);
		if(isOk == true){
			Mensagem.impressaoEfetuadaSucesso();
			comprovanteView.dispose();
		}else{
			Mensagem.impressaoNaoEfetuada();
		}
	}*/
	

}
