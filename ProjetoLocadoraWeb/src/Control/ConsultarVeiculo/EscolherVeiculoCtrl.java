//Classe EscolherVeiculoCtrl
package Control.ConsultarVeiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Grupo;

import Control.RealizarLocacao.LocacaoPJCtrl;
import Control.RealizarLocacao.RealizarLocacaoCtrl;
import View.VeiculoDadosView;
import View.VeiculoEscolhaView;
import View.Mensagens.Mensagem;

public class EscolherVeiculoCtrl extends VeiculoCtrl{
	
	private VeiculoEscolhaView escolherVeiculoView;
	private RealizarLocacaoCtrl realizarLocacaoCtrl;
	private LocacaoPJCtrl locacaoPJCtrl;
	
	public EscolherVeiculoCtrl(){
		escolherVeiculoView = new VeiculoEscolhaView();
		escolherVeiculoView.getPanelAcessorio().addCheckListener(new CheckBoxesListener(
				escolherVeiculoView.getPanelAcessorio()));
		adicionandoListener();
	}
	
	public EscolherVeiculoCtrl(ArrayList<Grupo> grupos){
		escolherVeiculoView = new VeiculoEscolhaView();
		escolherVeiculoView.getPanelAcessorio().addCheckListener(new CheckBoxesListener(
				escolherVeiculoView.getPanelAcessorio()));
		adicionandoListener();
		this.grupos = grupos;
		escolherVeiculoView.preencheComboGrupo(grupos);
	}
	
	public EscolherVeiculoCtrl(ArrayList<Grupo> grupos, RealizarLocacaoCtrl realizarLocacaoCtrl) {
		this.realizarLocacaoCtrl = realizarLocacaoCtrl;
		escolherVeiculoView = new VeiculoEscolhaView();
		escolherVeiculoView.getPanelAcessorio().addCheckListener(new CheckBoxesListener(
				escolherVeiculoView.getPanelAcessorio()));
		adicionandoListener();
		this.grupos = grupos;
		escolherVeiculoView.preencheComboGrupo(grupos);
	}

	public EscolherVeiculoCtrl(ArrayList<Grupo> grupos, LocacaoPJCtrl locacaoPJCtrl) {
		this.locacaoPJCtrl = locacaoPJCtrl;
		escolherVeiculoView = new VeiculoEscolhaView();
		escolherVeiculoView.getPanelAcessorio().addCheckListener(new CheckBoxesListener(
				escolherVeiculoView.getPanelAcessorio()));
		adicionandoListener();
		this.grupos = grupos;
		escolherVeiculoView.preencheComboGrupo(grupos);
	}

	private void adicionandoListener() {
		escolherVeiculoView.addBtDetalhes(new DetalhesListener());
		escolherVeiculoView.addBtLocarListener(new LocarListener());
		escolherVeiculoView.addBtVoltarListener(new VoltarListener());
		escolherVeiculoView.addComboListener(new ComboBoxListener());
	}
	
	
	class DetalhesListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			if(selecionaVeiculoNoJTable(escolherVeiculoView) == true){
				VeiculoDetCtrl consultaDet = new VeiculoDetCtrl(veiculo);
			}
		}
	}
	
	class LocarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			if(realizarLocacaoCtrl == null && locacaoPJCtrl == null){
				Mensagem.impossivelEfetuarLocacaoTelaErrada();
			}
			else {
				if(selecionaVeiculoNoJTable(escolherVeiculoView)){
					veiculo.setTotalAcessorios(escolherVeiculoView.getPanelAcessorio().getTxtTotal());
					escolherVeiculoView.dispose();
					if(realizarLocacaoCtrl != null){
						realizarLocacaoCtrl.adicionarVeiculo(veiculo);
					}
					else{
						locacaoPJCtrl.adicionarVeiculo(veiculo);
					}
				}
				else{
					Mensagem.selecioneVeiculo();
				}
			}
		}
	}
	
	class VoltarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			escolherVeiculoView.dispose();
			ConsultarVeiculoCtrl consultaVeiculo = new ConsultarVeiculoCtrl(grupos);
			
		}
	}
	
	
	class ComboBoxListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			limparJTable(escolherVeiculoView);
			grupo = (Grupo) escolherVeiculoView.getComboBoxGrupo();
			preencheTable(escolherVeiculoView);
		}
	}
	
	
	public void preencheTable(VeiculoDadosView veiculoDadosView)
	{
		// Obtem o modelo da JTable  
		DefaultTableModel modelo = (DefaultTableModel) veiculoDadosView.getTabela().getModel();

			for (int j = 0; j < grupo.getListaDeVeiculos().size() ; j++) {
				adicionarRow(modelo , j , grupo);
			}
	}	
}
