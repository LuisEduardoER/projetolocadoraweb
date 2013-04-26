//Classe ClienteDadosPJView
package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import View.Frames.JFrameDefault;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;
import View.TextFields.CampoTexto;
import View.TextFields.CampoTextoFormatadoCnpj;
import View.TextFields.CampoTextoFormatadoTelefone;

public abstract class ClienteDadosPJView extends JFrameDefault{
//	JLABELS
	private Rotulo lbDadosPessoais;
	private Rotulo lbRazaoSocial;
	private Rotulo lbNomeFantasia;
	private Rotulo lbCnpj;
	private Rotulo lbTelefone;
	private Rotulo lbEmail;
		
//	JTEXTFIELDS
	private CampoTexto txtRazaoSocial;
	private CampoTexto txtNomeFantasia;
	private CampoTextoFormatadoCnpj txtCnpj;
	private CampoTextoFormatadoTelefone txtTelefone;
	private CampoTexto txtEmail;
	
	
//	JPANEL
	private JPanel panelPrincipal;
	
	public ClienteDadosPJView(){
		montaGUI();
	}
	
	public void montaGUI() {
		setLayout(new GridBagLayout());
		initComponents();
		montaPanelPrincipal();		
	}


	public void initComponents() {
		lbCnpj = new Rotulo(RotuloNomes.getCNPJ());
		lbDadosPessoais = new Rotulo(RotuloNomes.getDADOS_PESSOAIS());
		lbEmail = new Rotulo(RotuloNomes.getEMAIL());
		lbNomeFantasia = new Rotulo(RotuloNomes.getNOME_FANTASIA());
		lbRazaoSocial = new Rotulo(RotuloNomes.getRAZAO_SOCIAL());
		lbTelefone = new Rotulo(RotuloNomes.getTELEFONE());
		
		txtCnpj = new CampoTextoFormatadoCnpj();
		txtEmail = new CampoTexto(40 , 18);
		txtNomeFantasia = new CampoTexto(50 , 20);
		txtRazaoSocial = new CampoTexto(70 , 30);
		txtTelefone = new CampoTextoFormatadoTelefone();
		
	}

	private void montaPanelPrincipal() {
		panelPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelPrincipal.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.gridy = 0; 
	    gbc.gridx = 0; 
	    gbc.gridwidth = 2; 
	    panelPrincipal.add(lbDadosPessoais , gbc);
		
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1;
	    panelPrincipal.add(lbRazaoSocial , gbc);
		
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panelPrincipal.add(txtRazaoSocial , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(lbNomeFantasia , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panelPrincipal.add(txtNomeFantasia , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(lbCnpj , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panelPrincipal.add(txtCnpj , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(lbTelefone , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 1; // coluna
	    panelPrincipal.add(txtTelefone , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(lbEmail , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 1; // coluna
	    panelPrincipal.add(txtEmail , gbc);
	    
	    gbc = new GridBagConstraints();
	    gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    
	    add(panelPrincipal , gbc);
	    	    
	}
	
	public abstract void addBotoes();

	public String getTxtRazaoSocial() {
		return txtRazaoSocial.getText();
	}
	
	public void setTxtRazaoSocial(String razaoSocial) {
		this.txtRazaoSocial.setText(razaoSocial);
	}
	
	public String getTxtNomeFantasia() {
		return txtNomeFantasia.getText();
	}
	
	public void setTxtNomeFantasia(String nomeFantasia) {
		this.txtNomeFantasia.setText(nomeFantasia);
	}
	
	public String getTxtCnpj() {
		return (String) txtCnpj.getValue();
	}
	
	public void setTxtCnpj(String cnpj) {
		this.txtCnpj.setText(cnpj);
	}
	
	public String getTxtTelefone() {
		return (String) txtTelefone.getValue();
	}
	
	public void setTxtTelefone(String telefone) {
		this.txtTelefone.setText(telefone);
	}
	
	public String getTxtEmail() {
		return txtEmail.getText();
	}
	
	public void setTxtEmail(String email) {
		this.txtEmail.setText(email);
	}
	
	public boolean verificaCamposBranco() {
		

		if(txtCnpj.getValue() == null || txtEmail.getText().equals("") || txtNomeFantasia.getText().equals("") ||
				txtRazaoSocial.getText().equals("") || txtTelefone.getValue() == null){
			return true;
		}
		
		return false; //não tem campos em branco
	}
	
	public void desabilitarCampos(){
		txtCnpj.setEditable(false);
		txtEmail.setEditable(false);
		txtNomeFantasia.setEditable(false);
		txtRazaoSocial.setEditable(false);
		txtTelefone.setEditable(false);
	}
	
	public void habilitarCampos(){
		txtCnpj.setEditable(true);
		txtEmail.setEditable(true);
		txtNomeFantasia.setEditable(true);
		txtRazaoSocial.setEditable(true);
		txtTelefone.setEditable(true);
	}
	
	
	
}
