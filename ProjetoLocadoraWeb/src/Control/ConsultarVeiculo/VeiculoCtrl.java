//Classe VeiculoCtrl
package Control.ConsultarVeiculo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import model.Grupo;
import model.Veiculo;
import model.Dao.VeiculoDAO;
import Util.Conversao;
import View.VeiculoDadosView;

public class VeiculoCtrl {
	protected Veiculo veiculo;
	protected Grupo grupo;
	protected ArrayList<Grupo> grupos;
	protected int idAgencia;
	

	
	public void preencheTable(VeiculoDadosView veiculoDadosView){
		// Obtem o modelo da JTable  
		DefaultTableModel modelo = (DefaultTableModel) veiculoDadosView.getTabela().getModel();
		
		VeiculoDAO dao = new VeiculoDAO();
		
		grupos = dao.getListGrupo(idAgencia);
		
		for(int i = 0; i < grupos.size() ; i++){
			grupo = grupos.get(i);
			for (int j = 0; j < grupo.getListaDeVeiculos().size() ; j++) {
				adicionarRow(modelo , j , grupo);
			}
		}
		
	}
	
	protected void adicionarRow(DefaultTableModel modelo, int j, Grupo grupo) {
		modelo.addRow(new Object [] { grupo.getNome().substring(0 , 1) , 
				  grupo.getVeiculo(j).getModelo() , 
				  preencheCelulaKmControlado(grupo)  , 
				  "R$ " + Conversao.formatDouble(grupo.getTarifaLivre()) , 
				  preencheCelulaKmLivre(grupo)});
	}

	
	public boolean selecionaVeiculoNoJTable(VeiculoDadosView veiculoDadosView) {
		int[] l = veiculoDadosView.getTabela().getSelectedRows();
		veiculo = new Veiculo();
		
		if (l.length > 0) {
			DefaultTableModel dtm = (DefaultTableModel) veiculoDadosView.getTabela().getModel();

			// obtem o valor de cada célula da linha selecionada
			//
			
			for (int i = 0; i < grupos.size(); i++) {
				Grupo grupo = grupos.get(i);
				String letra = grupo.getNome().substring(0 , 1);
				String strGrupo = (String) dtm.getValueAt(l[0], 0);
				
				if(letra.equals(strGrupo)){
					
					for (int j = 0; j < grupo.getListaDeVeiculos().size(); j++) {
						letra = grupo.getVeiculo(j).getModelo();
						strGrupo = (String) dtm.getValueAt(l[0], 1);
						if(letra.equals(strGrupo)){
							this.veiculo = grupo.getVeiculo(j);
							this.veiculo.setGrupo(grupo);
							return true;
						}
					}	
				}	
			}
		}
		return false;
	}
	
	public void limparJTable(VeiculoDadosView veiculoDadosView) {
		DefaultTableModel modelo = (DefaultTableModel) veiculoDadosView.getTabela().getModel();
		while(modelo.getRowCount() > 0){
			modelo.removeRow(0);
		}
	}
	
	protected String preencheCelulaKmControlado(Grupo gp){
		
		return "R$ " + Conversao.formatDouble(gp.getTarifaControloda()) + " + R$ " + Conversao.formatDouble(gp.getKmExtra());
	}
	
	protected String preencheCelulaKmLivre(Grupo gp){
		
		return "R$ " + Conversao.formatDouble(gp.getSemanaLivre()) + " + R$ " + Conversao.formatDouble(gp.getDiaExtra());
	}
	
}
