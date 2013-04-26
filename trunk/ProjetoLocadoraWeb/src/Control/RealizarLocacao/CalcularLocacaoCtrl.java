//Classe CalcularLocacaoCtrl
package Control.RealizarLocacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Locacao;
import model.SerasaImpl;
import Control.FormaPagamentoCtrl;
import View.LocacaoAddMotoristaView;
import View.Mensagens.Mensagem;

public class CalcularLocacaoCtrl {
	
	private Locacao locacao;
	private LocacaoAddMotoristaView locacaoCalculaView;
	
	public CalcularLocacaoCtrl(Locacao locacao) {
		this.locacao = locacao;
		locacaoCalculaView = new LocacaoAddMotoristaView();
		adicionarListener();
		if(locacao.getClienteEscolhido().getTipo().equals("PF")){ //Caso a locação for efetuada por Pessoa Fisica
			calcularTotal();
		}
		carregarCamposView();
	}

	
	private void adicionarListener() {
		locacaoCalculaView.addBtAvancarListener(new AvancarListener());
		locacaoCalculaView.addBtVoltarListener(new VoltarListener());
	}
	
		
	class AvancarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			SerasaImpl serasa = new SerasaImpl();
			if(serasa.validar(locacao.getClienteEscolhido()) == true){
				Mensagem.clientePossuiPendenciasSerasa();
			}else{
				FormaPagamentoCtrl pagamentoCtrl = new FormaPagamentoCtrl(locacao);
				locacaoCalculaView.dispose();
			}
		}
	}
	
	class VoltarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			RealizarLocacaoCtrl locacaoCtrl = new RealizarLocacaoCtrl(locacao);
			locacaoCalculaView.dispose();
		}
	}
	
	
	public void carregarCamposView(){
		locacaoCalculaView.setTxtDtaRetirada(locacao.getDtaRetirada());
		locacaoCalculaView.setTxtDtaDevolucao(locacao.getDtaPrevDevolucao());
		locacaoCalculaView.setTxtAgenciaRetirada(locacao.getAgenciaRetirada().getNome());
		locacaoCalculaView.setTxtAgenciaDevolucao(locacao.getAgenciaDevolucao().getNome());
		locacaoCalculaView.setTxtTipoTarifa(locacao.getTipoTarifa());
		locacaoCalculaView.setTxtQtdDias(locacao.getQtdDias());
		locacaoCalculaView.setTxtTotal(locacao.getTotal());
		
		if(locacao.getClienteEscolhido().getTipo().equals("PF")){
			locacaoCalculaView.setTxtGrupo(locacao.getVeiculoEscolhido().getGrupo().getNome());
			locacaoCalculaView.setTxtAcessorio(locacao.getVeiculoEscolhido().getTotalAcessorios());
			locacaoCalculaView.setTxtVeiculo(locacao.getVeiculoEscolhido().getModelo());
		}else{
			locacaoCalculaView.setTxtGrupo(locacao.getCondutor(0).getVeiculo().getGrupo().getNome());
			locacaoCalculaView.setTxtAcessorio(locacao.getCondutor(0).getVeiculo().getTotalAcessorios());
			locacaoCalculaView.setTxtVeiculo(locacao.getCondutor(0).getVeiculo().getModelo());
		}
	}
	
	
	
	private double calcularTotal(){
		if(locacao.getTipoTarifa().equals("livre")){
			locacao.setTotal(calcularTotalTarifaLivre());
		}
		else{
			locacao.setTotal(calcularTotalTarifaControlada());
		}
		return locacao.getTotal();
	}
	

	private double calcularTotalTarifaLivre() {
//		valor veiculo(s) escolhido(s)
//		qtd de dias
//		tipo de tarifa - ok
		
		double valorVeiculo = locacao.getVeiculoEscolhido().getGrupo().getTarifaLivre();
//		int qtdDias = calculaQtdDias();
		if(locacao.getQtdDias() < 7){
			valorVeiculo = valorVeiculo * (double) locacao.getQtdDias();
		}else{
			valorVeiculo = locacao.getVeiculoEscolhido().getGrupo().getDiaExtra() * locacao.getQtdDias();
		}
		valorVeiculo = valorVeiculo + locacao.getVeiculoEscolhido().getTotalAcessorios();
		return valorVeiculo;
	}

	private double calcularTotalTarifaControlada() {
		
		double valorVeiculo = locacao.getVeiculoEscolhido().getGrupo().getTarifaControloda();
		valorVeiculo = valorVeiculo * (double) locacao.getQtdDias();
		valorVeiculo = valorVeiculo + locacao.getVeiculoEscolhido().getTotalAcessorios();
		
		return valorVeiculo;
		
	}
}
