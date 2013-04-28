//Classe VeiculoDetCtrl
package Control.ConsultarVeiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Veiculo;

import View.VeiculoConsultaDetView;

public class VeiculoDetCtrl {
	
	private VeiculoConsultaDetView consultaDetView;
	
	public VeiculoDetCtrl(){
		consultaDetView = new VeiculoConsultaDetView();
		adicionandoListener();
	}
	
	public VeiculoDetCtrl(Veiculo veiculo){
		consultaDetView = new VeiculoConsultaDetView();
		adicionandoListener();
		carregarCamposConsultaDet(veiculo);
	}

	private void adicionandoListener() {
		consultaDetView.addBtFecharListener(new FecharListener());
	}
	
	class FecharListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ev) {
			consultaDetView.dispose();			
		}
	}
	
//	Método para carregar valores na view "VeiculoConsultaDetView"
	public void carregarCamposConsultaDet(Veiculo veiculo){
		consultaDetView.setTxtChassi(veiculo.getChassi());
		consultaDetView.setTxtCidade(veiculo.getCidade());
		consultaDetView.setTxtEstado(veiculo.getEstado());
		consultaDetView.setTxtFabricante(veiculo.getFabricante());
		consultaDetView.setTxtKm(veiculo.getKm());
		consultaDetView.setTxtModelo(veiculo.getModelo());
		consultaDetView.setTxtPlaca(veiculo.getPlaca());
	}
	
}
