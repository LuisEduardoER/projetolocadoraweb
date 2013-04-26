//Classe ClienteEscolhaView
package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import Util.Idioma;
import View.Botoes.BotaoConfirmar;
import View.Botoes.BotaoVoltar;

public class ClienteEscolhaView extends JDialog{
	
//	JRADIOBUTTONS
	private JRadioButton rbPF;
	private JRadioButton rbPJ;
	
//	BUTTON GROUP
	private ButtonGroup radioGroup;
	
	
//	BOTÕES
	private BotaoVoltar btVoltar;
	private BotaoConfirmar btConfirmar;
	
		
	private JPanel panelPrincipal;
	
	public ClienteEscolhaView(){
		montaGUI();
	}
	
	private void montaGUI() {
		initComponents();
		montaPanelPrincipal();
		setLayout(new GridBagLayout());
		
		add(panelPrincipal);
		setTitle(Idioma.bn.getString("clienteEscolhaView.title"));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}



	private void montaPanelPrincipal() {
		panelPrincipal = new JPanel(new GridBagLayout());
		panelPrincipal.setBorder(new EmptyBorder(40, 50, 40, 50));
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(2 , 0, 0, 0);
		
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 2; // duas célula na linha
	    panelPrincipal.add(rbPF , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 2; // duas célula na linha
	    panelPrincipal.add(rbPJ , gbc);
	    
	    gbc.insets = new Insets(15 , 0 , 0, 5);
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; // duas célula na linha
	    panelPrincipal.add(btVoltar , gbc);
		
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panelPrincipal.add(btConfirmar , gbc);
	    
	}



	private void initComponents() {
//		INICIALIZA BOTÕES
		btConfirmar = new BotaoConfirmar();
		btVoltar = new BotaoVoltar();
		rbPF = new JRadioButton(Idioma.bn.getString("clienteEscolhaView.pf"), true);
		rbPJ = new JRadioButton(Idioma.bn.getString("clienteEscolhaView.pj"), true);
		radioGroup = new ButtonGroup();
		
		radioGroup.add(rbPF);
		radioGroup.add(rbPJ);
	}
	
	public void addBtConfirmarListener(ActionListener a){
		btConfirmar.addActionListener(a);
	}
	
	public void addBtVoltarListener(ActionListener a){
		btVoltar.addActionListener(a);
	}
	
	public String getSelectedItem(){
		if(rbPF.isSelected()){
			return "PF";
		}
		else{
			return "PJ";
		}
	}
	
	
}
