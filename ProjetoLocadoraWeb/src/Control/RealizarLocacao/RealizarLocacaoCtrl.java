//Classe RealizarLocacaoCtrl
package Control.RealizarLocacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Agencia;
import model.Cliente;
import model.Locacao;
import model.PessoaJuridica;
import model.Veiculo;
import model.Dao.AgenciaDAO;
import Control.TarifaControladaCtrl;
import Control.ConsultarVeiculo.ConsultarVeiculoCtrl;
import Control.ManterCliente.ConsultarClienteCtrl;
import Control.ManterCliente.ManterClienteCtrl;
import Util.Verificacao;
import View.LocacaoEscolheDataView;
import View.Mensagens.Mensagem;

public class RealizarLocacaoCtrl {
//	Classe Model
	private Locacao locacao;
	
//	Views
	private LocacaoEscolheDataView escolheDataView;
	
//	Controllers
	private ManterClienteCtrl manterClienteCtrl;
	private ConsultarVeiculoCtrl consultarVeiculoCtrl;
	
	public RealizarLocacaoCtrl(){
		locacao = new Locacao();
		escolheDataView = new LocacaoEscolheDataView();
		adicionaListenerEscolheDataView();
	}
	
	public RealizarLocacaoCtrl(Agencia agencia){
		locacao = new Locacao();
		locacao.setAgenciaRetirada(agencia);
		manterClienteCtrl = new ConsultarClienteCtrl(this);
	}
	
	public RealizarLocacaoCtrl(Locacao locacao) {
		this.locacao = locacao;
		escolheDataView = new LocacaoEscolheDataView();
		adicionaListenerEscolheDataView();
		preencherComboBoxes();
	}

	public void adicionarCliente(Cliente cliente){
		locacao.setClienteEscolhido(cliente);
		consultarVeiculoCtrl = new ConsultarVeiculoCtrl(locacao.getAgenciaRetirada().getCodigo() , this);
	}
	
	public void adicionarCliente(PessoaJuridica pj){
		locacao.setClienteEscolhido(pj);
		escolheDataView = new LocacaoEscolheDataView();
		adicionaListenerEscolheDataView();
		preencherComboBoxes();
	}
	
	public void adicionarVeiculo(Veiculo veiculo){
		locacao.setVeiculoEscolhido(veiculo);
		escolheDataView = new LocacaoEscolheDataView();
		adicionaListenerEscolheDataView();
		preencherComboBoxes();
	}

	private void preencherComboBoxes() {
		escolheDataView.getPanelRetirada().preencheComboAgencia(locacao.getAgenciaRetirada());
		
		AgenciaDAO dao = new AgenciaDAO();
		ArrayList<Agencia> agencias = dao.getList();
		escolheDataView.getPanelDevolucao().preencheComboAgencia(agencias);
		escolheDataView.pack();
	}

	private void adicionaListenerEscolheDataView() {
		escolheDataView.addBtCancelarListener(new CancelarListener());
		escolheDataView.addBtAvancarListener(new AvancarListener());
	}
	
	class CancelarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int op = Mensagem.desejaCancelar();
			if(op == 0){
				escolheDataView.dispose();
			}
		}
	}
	
	class AvancarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(carregaValores()){
				if(verificaDataHora()){
					if(locacao.getClienteEscolhido().getTipo().equals("PJ")){
						LocacaoPJCtrl locacaoPjCtrl = new LocacaoPJCtrl(locacao);
					}
					else{
						if(locacao.getTipoTarifa().equals("livre")){
							CalcularLocacaoCtrl calcularLocacao = new CalcularLocacaoCtrl(locacao);
						}else{
							TarifaControladaCtrl tarifaControladaCtrl = new TarifaControladaCtrl(locacao);
						}
//						System.out.println(Verificacao.getDiferencaDias(locacao.getDtaRetirada(), locacao.getDtaPrevDevolucao()));
					}
					escolheDataView.dispose();
				}
			}
		}
	}
	
	private boolean verificaDataHora() {
						
		if(Verificacao.isCorrectDate(locacao.getDtaRetirada())){
			calculaQtdDias();
			if(locacao.getQtdDias() > 0){
				return true;
			}
			Mensagem.datahoraDevolucaoIncorreta();
			return false;
		}
		Mensagem.datahoraRetiradaIncorreta();
		return false;
	}
	
	private boolean carregaValores() {
		if(!escolheDataView.camposBranco()){
			locacao.setDtaRetirada(escolheDataView.getPanelRetirada().getData());
			locacao.setDtaPrevDevolucao(escolheDataView.getPanelDevolucao().getData());
			locacao.setAgenciaDevolucao((Agencia) escolheDataView.getPanelDevolucao().getComboBoxAgencia());
			locacao.setTipoTarifa(escolheDataView.getTipoTarifa());
			return true;
		}
		else{
			Mensagem.temCampoBranco();
			return false;
		}
	}
		
	private void calculaQtdDias() {
		locacao.setQtdDias(Verificacao.getDiferencaDias(locacao.getDtaRetirada(), locacao.getDtaPrevDevolucao()));
	}	
}
