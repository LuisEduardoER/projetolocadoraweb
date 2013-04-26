//Classe ConsultarVeiculoCtrl
package Control.ConsultarVeiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Grupo;

import Control.RealizarLocacao.LocacaoPJCtrl;
import Control.RealizarLocacao.RealizarLocacaoCtrl;
import View.VeiculoConsultaView;

public class ConsultarVeiculoCtrl extends VeiculoCtrl{
	
	private VeiculoConsultaView consultaGeralView;
	private RealizarLocacaoCtrl realizarLocacaoCtrl;
	private LocacaoPJCtrl locacaoPJCtrl;
	
	
	public ConsultarVeiculoCtrl(int idAgencia, RealizarLocacaoCtrl realizarLocacaoCtrl){
		this.realizarLocacaoCtrl = realizarLocacaoCtrl;
		consultaGeralView = new VeiculoConsultaView();
		consultaGeralView.getPanelAcessorio().addCheckListener(new CheckBoxesListener(
				consultaGeralView.getPanelAcessorio()));
		adicionandoListener();
		this.idAgencia = idAgencia; 
		preencheTable(consultaGeralView);
	}
	
	public ConsultarVeiculoCtrl(int idAgencia){
		consultaGeralView = new VeiculoConsultaView();
		consultaGeralView.getPanelAcessorio().addCheckListener(new CheckBoxesListener(
				consultaGeralView.getPanelAcessorio()));
		adicionandoListener();
		this.idAgencia = idAgencia; 
		preencheTable(consultaGeralView);
	}
	
	public ConsultarVeiculoCtrl(ArrayList<Grupo> grupos){
		consultaGeralView = new VeiculoConsultaView();
		consultaGeralView.getPanelAcessorio().addCheckListener(new CheckBoxesListener(
				consultaGeralView.getPanelAcessorio()));
		adicionandoListener();
		this.grupos = grupos;
		preencheTable();
	}

	public ConsultarVeiculoCtrl(int idAgencia, LocacaoPJCtrl locacaoPJCtrl) {
		this.locacaoPJCtrl = locacaoPJCtrl;
		consultaGeralView = new VeiculoConsultaView();
		consultaGeralView.getPanelAcessorio().addCheckListener(new CheckBoxesListener(
				consultaGeralView.getPanelAcessorio()));
		adicionandoListener();
		this.idAgencia = idAgencia; 
		preencheTable(consultaGeralView);
	}

	private void adicionandoListener() {
		consultaGeralView.addBtDetalhes(new DetalhesListener());
		consultaGeralView.addBtEscolherListener(new EscolherListener());
		consultaGeralView.addBtVoltarListener(new VoltarListener());
	}
	
	
	class DetalhesListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			if(selecionaVeiculoNoJTable(consultaGeralView) == true){
				VeiculoDetCtrl consultaDet = new VeiculoDetCtrl(veiculo);
			}
			
		}
	}
	
	class EscolherListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			consultaGeralView.dispose();
			if(realizarLocacaoCtrl != null){
				EscolherVeiculoCtrl app = new EscolherVeiculoCtrl(grupos , realizarLocacaoCtrl);
			}
			else{
				if(locacaoPJCtrl != null){
					EscolherVeiculoCtrl app = new EscolherVeiculoCtrl(grupos , locacaoPJCtrl);
				}
			}
			
		}
	}
	
	class VoltarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			consultaGeralView.dispose();
		}
	}
	
	public void preencheTable()
	{
		// Obtem o modelo da JTable  
		DefaultTableModel modelo = (DefaultTableModel) consultaGeralView.getTabela().getModel();
		Grupo grupo;	
		for(int i = 0; i < grupos.size() ; i++){
			grupo = grupos.get(i);
			for (int j = 0; j < grupo.getListaDeVeiculos().size() ; j++) {
				adicionarRow(modelo , j , grupo);
			}
		}
	}
		
}
