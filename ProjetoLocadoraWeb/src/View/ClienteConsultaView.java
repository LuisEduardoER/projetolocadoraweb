//Classe ClienteConsultaView
package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Util.Idioma;
import View.Botoes.*;
import View.Frames.JFrameDefault;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;
import View.TextFields.CampoTexto;
import View.TextFields.CampoTextoFormatadoTelefone;

public class ClienteConsultaView extends JFrameDefault {
	
//	JLABELS
	private Rotulo lbCnpjPesq;
	private Rotulo lbNome;
	private Rotulo lbCnpjRes;
	private Rotulo lbTelefone;
	private Rotulo lbEmail;
	
//	JTEXTFIELDS
	private CampoTexto txtCnpjPesq;
	private CampoTexto txtNome;
	private CampoTexto txtCnpjRes;
	private CampoTextoFormatadoTelefone txtTelefone;
	private CampoTexto txtEmail;
	
//	BOTÕES
	private BotaoDetalhes btDetalhes;
	private BotaoCancelar btCancelar;
	private BotaoAlterar btAlterar;
	private BotaoLocar btLocar;
	private BotaoPesquisar btPesquisar;
		
//	JPANELS
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JPanel panelInferior;
	
	public ClienteConsultaView(){
		montaGUI();
	}

	public void montaGUI() {
		initComponents();
		montaPanelPrincipal();
		desabilitarCampos();
		add(panelPrincipal);
		montaJFrame(Idioma.bn.getString("clienteConsultaView.title"));
		
	}

	
	private void montaPanelPrincipal() {
		montaPanelSuperior();
		montaPanelCentral();
		montaPanelInferior();
		
		panelPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelPrincipal.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy = 0; 
	    gbc.gridx = 0; 
	    gbc.gridwidth = 1; 
	    panelPrincipal.add(panelSuperior , gbc);
	    
	    gbc.gridy = 1; 
	    gbc.gridx = 0; 
	    panelPrincipal.add(panelCentral , gbc);
	    
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.gridy = 2; 
	    gbc.gridx = 0;
	    gbc.gridwidth = 3; 
	    panelPrincipal.add(panelInferior , gbc);

	}

	
	private void montaPanelSuperior() {
		panelSuperior = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelSuperior.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy = 0; 
	    gbc.gridx = 0; 
	    gbc.gridwidth = 1; 
	    panelSuperior.add(lbCnpjPesq , gbc);
	    	    
	    gbc.gridy = 0; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtCnpjPesq , gbc);
	    
	    gbc.insets = new Insets(4, 50, 20, 0);
	    gbc.gridy = 0; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(btPesquisar , gbc);
	    	    
	}
	
	private void montaPanelCentral() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panel.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.insets = new Insets(4, 0, 4, 0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy = 0; 
	    gbc.gridx = 0; 
	    gbc.gridwidth = 1; 
	    panel.add(lbNome , gbc);
	    	    
	    gbc.gridy = 0; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtNome , gbc);
	    
	    gbc.insets = new Insets(4, 50, 20, 0);
	    gbc.gridy = 0; // linha
	    gbc.gridx = 2; // coluna
	    panel.add(btDetalhes , gbc);
	    
	    gbc.insets = new Insets(4, 0, 4, 0);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbCnpjRes , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtCnpjRes , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbTelefone , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtTelefone , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbEmail , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtEmail , gbc);
	    
	    panelCentral = new JPanel(new FlowLayout());
	    panelCentral.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.darkGray , 1 , true) ,
	    		Idioma.bn.getString("clienteConsultaView.dadosCliente")));
	    panelCentral.add(panel);
	    
	}

	private void montaPanelInferior() {
		panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER , 10 , 0));
		panelInferior.setBorder(new EmptyBorder(30, 20, 20, 20));
		panelInferior.add(btCancelar);
		panelInferior.add(btAlterar);
		panelInferior.add(btLocar);
	}

	public void initComponents() {
		lbCnpjPesq = new Rotulo(RotuloNomes.getCNPJ_CPF());
		lbCnpjRes = new Rotulo(RotuloNomes.getCNPJ_CPF());
		lbEmail = new Rotulo(RotuloNomes.getEMAIL());
		lbNome = new Rotulo(RotuloNomes.getNOME());
		lbTelefone = new Rotulo(RotuloNomes.getTELEFONE());
		
		txtCnpjPesq = new CampoTexto(18 , 10);
		txtCnpjRes = new CampoTexto(18 , 10);
		txtEmail = new CampoTexto(40 , 18);
		txtNome = new CampoTexto(70 , 25);
		txtTelefone = new CampoTextoFormatadoTelefone();
		
		btAlterar = new BotaoAlterar();
		btCancelar = new BotaoCancelar();
		btDetalhes = new BotaoDetalhes();
		btLocar = new BotaoLocar();
		btPesquisar = new BotaoPesquisar();
	}
	
	public void addBtDetalhes(ActionListener a){
		btDetalhes.addActionListener(a);
	}
	
	public void addBtCancelar(ActionListener a){
		btCancelar.addActionListener(a);
	}
	
	public void addBtAlterar(ActionListener a){
		btAlterar.addActionListener(a);
	}
	
	public void addBtLocar(ActionListener a){
		btLocar.addActionListener(a);
	}
	
	public void addBtPesquisar(ActionListener a){
		btPesquisar.addActionListener(a);
	}

	public String getTxtCnpjPesq() {
		return txtCnpjPesq.getText();
	}

	public void setTxtCnpjPesq(String cnpjPesq) {
		this.txtCnpjPesq.setText(cnpjPesq);
	}

	public String getTxtNome() {
		return txtNome.getText();
	}

	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}

	public String getTxtCnpjRes() {
		return txtCnpjRes.getText();
	}

	public void setTxtCnpjRes(String cnpjRes) {
		this.txtCnpjRes.setText(cnpjRes);
	}

	public String getTxtTelefone() {
		return txtTelefone.getText();
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
	
	public void desabilitarCampos() {
		txtCnpjRes.setEditable(false);
		txtEmail.setEditable(false);
		txtNome.setEditable(false);
		txtTelefone.setEditable(false);
	}
	
	public void habilitarCampos() {
		txtCnpjRes.setEditable(true);
		txtEmail.setEditable(true);
		txtNome.setEditable(true);
		txtTelefone.setEditable(true);
	}
	
}
