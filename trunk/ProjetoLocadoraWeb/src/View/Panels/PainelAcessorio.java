//Classe PainelAcessorio
package View.Panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Util.Conversao;
import Util.Idioma;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;

public class PainelAcessorio extends JPanel{
	
	private Rotulo lbTotal;
	
	private JTextField txtTotal;
	
	private JCheckBox checkNavegador;
	private JCheckBox checkCadeira;
	private JCheckBox checkMotorista;
	
	private JPanel panelPrincipal;
	private double total;
	
	public PainelAcessorio(){
		montaGUI();
	}

	private void montaGUI() {
		initComponents();
		montaPanelPrincipal();
		add(panelPrincipal);
	}

	private void montaPanelPrincipal() {
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panel.setBorder(new EmptyBorder(0, 30, 0, 30));
		
//		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.anchor = GridBagConstraints.WEST;
		
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 3; 
	    panel.add(checkNavegador , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(checkCadeira , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(checkMotorista , gbc);
	    
	    gbc.insets = new Insets(10, 0, 0, 0);
	    gbc.anchor = GridBagConstraints.EAST;
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    gbc.gridwidth = 1; 
	    panel.add(lbTotal , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 2; // coluna
	    panel.add(txtTotal , gbc);
	    
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.darkGray , 1 , true) ,
				Idioma.bn.getString("painelAcessorio.title")));
		panelPrincipal.add(panel);
		
	}

	private void initComponents() {
		lbTotal = new Rotulo(RotuloNomes.getTOTAL());
		txtTotal = new JTextField(10);
		
		checkNavegador = new JCheckBox(Idioma.bn.getString("painelAcessorio.navegador"));
		checkCadeira = new JCheckBox(Idioma.bn.getString("painelAcessorio.cadeira"));
		checkMotorista = new JCheckBox(Idioma.bn.getString("painelAcessorio.motorista"));
		
	}
	
	public void addCheckListener(ItemListener a){
		checkCadeira.addItemListener(a);
		checkMotorista.addItemListener(a);
		checkNavegador.addItemListener(a);
	}
	
	public JCheckBox getCheckNavegador() {
		return checkNavegador;
	}

	
	public JCheckBox getCheckCadeira() {
		return checkCadeira;
	}

	
	public JCheckBox getCheckMotorista() {
		return checkMotorista;
	}

	public double getTxtTotal() {
		return getTotal();
	}

	public void setTxtTotal(double total) {
		this.txtTotal.setText("R$ " +  Conversao.formatDouble(total));
		setTotal(total);
	}

	private double getTotal() {
		return total;
	}

	private void setTotal(double total) {
		this.total = total;
	}
		
}
