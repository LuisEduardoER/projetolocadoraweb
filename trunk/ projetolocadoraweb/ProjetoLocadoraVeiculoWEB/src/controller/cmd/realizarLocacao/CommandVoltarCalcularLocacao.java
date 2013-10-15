package controller.cmd.realizarLocacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.cmd.Command;

public class CommandVoltarCalcularLocacao extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return "LocacaoEscolheData.jsp";
	}
	
//	public void carregarCamposView(){
//		locacaoCalculaView.setTxtDtaRetirada(locacao.getDtaRetirada());
//		locacaoCalculaView.setTxtDtaDevolucao(locacao.getDtaPrevDevolucao());
//		locacaoCalculaView.setTxtAgenciaRetirada(locacao.getAgenciaRetirada().getNome());
//		locacaoCalculaView.setTxtAgenciaDevolucao(locacao.getAgenciaDevolucao().getNome());
//		locacaoCalculaView.setTxtTipoTarifa(locacao.getTipoTarifa());
//		locacaoCalculaView.setTxtQtdDias(locacao.getQtdDias());
//		locacaoCalculaView.setTxtTotal(locacao.getTotal());
//		
//		if(locacao.getClienteEscolhido().getTipo().equals("PF")){
//			locacaoCalculaView.setTxtGrupo(locacao.getVeiculoEscolhido().getGrupo().getNome());
//			locacaoCalculaView.setTxtAcessorio(locacao.getVeiculoEscolhido().getTotalAcessorios());
//			locacaoCalculaView.setTxtVeiculo(locacao.getVeiculoEscolhido().getModelo());
//		}else{
//			locacaoCalculaView.setTxtGrupo(locacao.getCondutor(0).getVeiculo().getGrupo().getNome());
//			locacaoCalculaView.setTxtAcessorio(locacao.getCondutor(0).getVeiculo().getTotalAcessorios());
//			locacaoCalculaView.setTxtVeiculo(locacao.getCondutor(0).getVeiculo().getModelo());
//		}
//	}
	
//	class VoltarListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			RealizarLocacaoCtrl locacaoCtrl = new RealizarLocacaoCtrl(locacao);
//			locacaoCalculaView.dispose();
//		}
//	}

}
