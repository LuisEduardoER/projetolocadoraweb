//Classe DevolverLocacaoCtrl
package Control.DevolverVeiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Model.Agencia;
import Model.Devolucao;
import Model.Locacao;
import Model.Dao.LocacaoDAO;

import Control.TarifaControladaCtrl;
import Util.Verificacao;
import View.DevolucaoConsultaView;
import View.Mensagens.Mensagem;

public class DevolverLocacaoCtrl {
	
	private DevolucaoConsultaView consultaView;
	private Locacao locacao;
	private Devolucao devolucao;
	private Agencia agenciaDevolucao;
	
	public DevolverLocacaoCtrl(Agencia agencia){
		agenciaDevolucao = agencia;
		consultaView = new DevolucaoConsultaView();
		adicionarListener();
	}
	
	public void adicionarListener(){
		consultaView.addBtAvancarListener(new AvancarListener());
		consultaView.addBtConsultarListener(new ConsultarListener());
		consultaView.addBtVoltarListener(new VoltarListener());
	}
	
	class AvancarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(locacao == null){
				Mensagem.entreCodigoLocacao();
			}
			else{
				devolucao = new Devolucao();
				devolucao.setAgenciaDevolucao(agenciaDevolucao);
				devolucao.setDtaDevolucao(new Date());
				devolucao.setLocacao(locacao);
				consultaView.dispose();
				if(locacao.getTipoTarifa().equals("livre")){
					CalcularDevolucaoCtrl calcularCtrl = new CalcularDevolucaoCtrl(devolucao);
				}
				else{
					TarifaControladaCtrl controladaCtrl = new TarifaControladaCtrl(devolucao);
				}
				
			}
		}
	}
	
	class ConsultarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			LocacaoDAO dao = new LocacaoDAO();
			try{
				if(consultaView.getTxtIdLocacaoConsulta() != 0){
					if(dao.isDevolvido(consultaView.getTxtIdLocacaoConsulta())){
						Mensagem.impossivelEncontrarLocacaoFinalizada();
					}else{
						locacao = dao.consultar(consultaView.getTxtIdLocacaoConsulta());
						if(locacao == null){
							Mensagem.impossivelEncontrarLocacao();
						}else{
							calculaQtdDias();
							carregarValoresCampos();
						}
					}
				}
			}catch(NumberFormatException e){
				if(consultaView.getTxtCnpjConsulta() != ""){
					ArrayList<Integer> nroLocacoes = dao.consultaLocacao(consultaView.getTxtCnpjConsulta());
					if(nroLocacoes.isEmpty()){ //caso não for possível encontrar locação 
						Mensagem.impossivelEncontrarLocacaoCPF();
					}else{
						int i = 0;
						String resultado = "";
						while(i < nroLocacoes.size()){
							resultado = resultado + "ID: " + nroLocacoes.get(i) + "\n";
							i++;
						}
						JOptionPane.showMessageDialog(null, resultado); //mostra todos os IDs das locações do cliente
					}
				}
			}
			consultaView.limparCamposSuperior();			
		}
	}
	
	class VoltarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			consultaView.dispose();
		}
	}
	
	
	private void carregarValoresCampos(){
		consultaView.setTxtIdLocacaoRes(locacao.getId());
		consultaView.setTxtNomeCliente(locacao.getClienteEscolhido().getNome());
		consultaView.setTxtCnpjRes(locacao.getClienteEscolhido().getRegistro());
		consultaView.setTxtDtaRetirada(locacao.getDtaRetirada());
		consultaView.setTxtDtaDevolucao(locacao.getDtaPrevDevolucao());
		consultaView.setTxtAgenciaRetirada(locacao.getAgenciaRetirada().getNome());
		consultaView.setTxtAgenciaDevolucao(locacao.getAgenciaDevolucao().getNome());
		consultaView.setTxtTipoTarifa(locacao.getTipoTarifa());
		consultaView.setTxtQtdDias(locacao.getQtdDias());
		consultaView.setTxtTotal(locacao.getTotal());
	}
	
	private void calculaQtdDias() {
		locacao.setQtdDias(Verificacao.getDiferencaDias(locacao.getDtaRetirada(), locacao.getDtaPrevDevolucao()));
	}
}
