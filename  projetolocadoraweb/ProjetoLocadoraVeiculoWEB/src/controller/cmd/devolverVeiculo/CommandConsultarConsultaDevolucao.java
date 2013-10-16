package controller.cmd.devolverVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.cmd.Command;

public class CommandConsultarConsultaDevolucao extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return null;
	}
	
	
	
	
//	LocacaoDAO dao = new LocacaoDAO();
//	try{
//		if(consultaView.getTxtIdLocacaoConsulta() != 0){
//			if(dao.isDevolvido(consultaView.getTxtIdLocacaoConsulta())){
//				Mensagem.impossivelEncontrarLocacaoFinalizada();
//			}else{
//				locacao = dao.consultar(consultaView.getTxtIdLocacaoConsulta());
//				if(locacao == null){
//					Mensagem.impossivelEncontrarLocacao();
//				}else{
//					calculaQtdDias();
//					carregarValoresCampos();
//				}
//			}
//		}
//	}catch(NumberFormatException e){
//		if(consultaView.getTxtCnpjConsulta() != ""){
//			ArrayList<Integer> nroLocacoes = dao.consultaLocacao(consultaView.getTxtCnpjConsulta());
//			if(nroLocacoes.isEmpty()){ //caso não for possível encontrar locação 
//				Mensagem.impossivelEncontrarLocacaoCPF();
//			}else{
//				int i = 0;
//				String resultado = "";
//				while(i < nroLocacoes.size()){
//					resultado = resultado + "ID: " + nroLocacoes.get(i) + "\n";
//					i++;
//				}
//				JOptionPane.showMessageDialog(null, resultado); //mostra todos os IDs das locações do cliente
//			}
//		}
//	}
//	consultaView.limparCamposSuperior();
	

}
