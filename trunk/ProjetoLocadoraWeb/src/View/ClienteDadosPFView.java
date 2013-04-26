//Classe ClienteDadosPFView
package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.Idioma;
import View.Datas.DataFormatada;
import View.Frames.JFrameDefault;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;
import View.TextFields.CampoTexto;
import View.TextFields.CampoTextoFormatadoCpf;
import View.TextFields.CampoTextoFormatadoData;
import View.TextFields.CampoTextoFormatadoEstadoEmissor;
import View.TextFields.CampoTextoFormatadoNumHabilitacao;
import View.TextFields.CampoTextoFormatadoTelefone;

public abstract class ClienteDadosPFView extends JFrameDefault{
//	JLABELS
	private Rotulo lbDadosPessoais;
	private Rotulo lbNome;
	private Rotulo lbSexo;
	private Rotulo lbDtaNascimento;
	private Rotulo lbCpf;
	private Rotulo lbRg;
	private Rotulo lbFone;
	private Rotulo lbEmail;
	private Rotulo lbDadosMotorista;
	private Rotulo lbNumHabilitacao;
	private Rotulo lbEstadoEmissor;
	private Rotulo lbPrimeiraHabilitacao;
	private Rotulo lbValidadeCarteira;
	
	private CampoTexto txtNome;
	private CampoTextoFormatadoData txtDtaNascimento;
	private CampoTextoFormatadoCpf txtCpf;
	private CampoTexto txtRg;
	private CampoTextoFormatadoTelefone txtFone;
	private CampoTexto txtEmail;
	private CampoTextoFormatadoNumHabilitacao txtNumHabilitacao;
	private CampoTextoFormatadoEstadoEmissor txtEstadoEmissor;
	private CampoTextoFormatadoData txtPrimeiraHabilitacao;
	private CampoTextoFormatadoData txtValidadeCarteira;
	
	private JComboBox cbSexo;
	
	
	
//	JPANELS
	protected JPanel panelSuperior;
	private JPanel panelInferior;
	private JPanel panelPrincipal;
	
	public ClienteDadosPFView(){
		montaGUI();
	}
	
	
	public void montaGUI() {
		setLayout(new GridBagLayout());
		initComponents();
		montaPanelSuperior();
		montaPanelInferior();
		montaPanelPrincipal();
		
	}


	public void initComponents() {
//		INICIALIZA JLABELS
		lbCpf = new Rotulo(RotuloNomes.getCPF());
		lbDadosMotorista = new Rotulo(Idioma.bn.getString("clienteDadosPFView.dadosMotorista"));
		lbDadosPessoais = new Rotulo(RotuloNomes.getDADOS_PESSOAIS());
		lbDtaNascimento = new Rotulo(RotuloNomes.getDATA_NASCIMENTO());
		lbEmail = new Rotulo(RotuloNomes.getEMAIL());
		lbEstadoEmissor = new Rotulo(RotuloNomes.getESTADO_EMISSOR());
		lbFone = new Rotulo(RotuloNomes.getTELEFONE());
		lbRg = new Rotulo(RotuloNomes.getDOCUMENTO_IDENTIFICACAO());
		lbNome = new Rotulo(RotuloNomes.getNOME());
		lbNumHabilitacao = new Rotulo(RotuloNomes.getNUM_HABILITACAO());
		lbSexo = new Rotulo(RotuloNomes.getSexo());
		lbPrimeiraHabilitacao = new Rotulo(RotuloNomes.getPRIMEIRA_HABILITACAO());
		lbValidadeCarteira = new Rotulo(RotuloNomes.getVALIDADE_CARTEIRA());
		
//		INICIALIZA JTEXTFIELDS
		txtCpf = new CampoTextoFormatadoCpf();
		txtDtaNascimento = new CampoTextoFormatadoData();
		txtEmail = new CampoTexto(40 , 18);
		txtEstadoEmissor = new CampoTextoFormatadoEstadoEmissor();
		txtFone = new CampoTextoFormatadoTelefone();
		txtRg = new CampoTexto(15 , 10);
		txtNome = new CampoTexto(50 , 25);
		txtNumHabilitacao = new CampoTextoFormatadoNumHabilitacao();
		txtPrimeiraHabilitacao = new CampoTextoFormatadoData();
		txtValidadeCarteira = new CampoTextoFormatadoData();
		
		
		
//		INICIALIZA COMBO BOXES
		String[] sexo = {Idioma.bn.getString("clienteDadosPFView.feminino") , 
						 Idioma.bn.getString("clienteDadosPFView.masculino")};
		cbSexo = new JComboBox( sexo );
		
		
		
	}


	private void montaPanelPrincipal() {
		panelPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelPrincipal.setBorder(new EmptyBorder(30, 20, 20, 20));
		
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(panelSuperior , gbc);
		
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(panelInferior , gbc);
	    
	    gbc = new GridBagConstraints();
	    gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    
		add(panelPrincipal , gbc);
		
	}


	private void montaPanelInferior() {
		panelInferior = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelInferior.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.gridy = 0; 
	    gbc.gridx = 0; 
	    gbc.gridwidth = 2; 
	    panelInferior.add(lbDadosMotorista , gbc);
		
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1;
	    panelInferior.add(lbNumHabilitacao , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panelInferior.add(txtNumHabilitacao , gbc);

	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panelInferior.add(lbEstadoEmissor , gbc);

	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panelInferior.add(txtEstadoEmissor , gbc);
	    
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panelInferior.add(lbPrimeiraHabilitacao , gbc);
	    

	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panelInferior.add(txtPrimeiraHabilitacao , gbc); 

	    gbc.gridy = 4; // linha
	    gbc.gridx = 0; // coluna
	    panelInferior.add(lbValidadeCarteira , gbc);
	    

	    gbc.gridy = 4; // linha
	    gbc.gridx = 1; // coluna
	    panelInferior.add(txtValidadeCarteira , gbc); 
	    
	    
	}


	private void montaPanelSuperior() {
		panelSuperior = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelSuperior.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.gridy = 0; 
	    gbc.gridx = 0; 
	    gbc.gridwidth = 4; 
	    panelSuperior.add(lbDadosPessoais , gbc);
		
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1;
	    panelSuperior.add(lbNome , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtNome , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbSexo , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(cbSexo , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(lbDtaNascimento , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(txtDtaNascimento , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbCpf , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtCpf , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(lbRg , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(txtRg , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbFone , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtFone , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbEmail , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtEmail , gbc);
	    
	}
	
	public abstract void addBotoes();
	
	
	public String getComboSexo(){
		//se o "Index" for igual a 0
		//significa que é Feminino, senão masculino
		if(cbSexo.getSelectedIndex() == 0){
			return "F";
		}
		else{
			return "M";
		}
		
	}
	
	public void setComboSexo(String sexo){
		if(sexo.equals("F")){
			cbSexo.setSelectedIndex(0);
		}
		else{
			cbSexo.setSelectedIndex(1);
		}
	}
	
	public String getTxtNome() {
		return txtNome.getText();
	}
	
	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}
		
	public Date getTxtDtaNascimento() {
		return DataFormatada.parseDataSimples(txtDtaNascimento.getText());
	}
	
	public void setTxtDtaNascimento(Date data) {
		this.txtDtaNascimento.setText(DataFormatada.parseStringDataSimples(data));
	}
	
	public String getTxtCpf() {
		return txtCpf.getText();
	}
	
	public void setTxtCpf(String cpf) {
		this.txtCpf.setText(cpf);
	}
	
	public String getTxtRg() {
		return txtRg.getText(); 
	}
	
	public void setTxtRg(String rg) {
		this.txtRg.setText(rg);
	}
	
	public String getTxtFone() {
		return txtFone.getText();
	}
	
	public void setTxtFone(String fone) {
		this.txtFone.setValue(fone);
	}
	
	public String getTxtEmail() {
		return txtEmail.getText();
	}
	
	public void setTxtEmail(String email) {
		this.txtEmail.setText(email);
	}
	
	public String getTxtNumHabilitacao() {
		return txtNumHabilitacao.getText();
	}
	
	public void setTxtNumHabilitacao(String numHabilitacao) {
		this.txtNumHabilitacao.setText(numHabilitacao);
	}
	
	public String getTxtEstadoEmissor() {
		return txtEstadoEmissor.getText();
	}
	
	public void setTxtEstadoEmissor(String estadoEmissor) {
		this.txtEstadoEmissor.setText(estadoEmissor);
	}
	
	public Date getTxtPrimeiraHabilitacao() {
		return DataFormatada.parseDataSimples(txtPrimeiraHabilitacao.getText());
	}

	public void setTxtPrimeiraHabilitacao(Date data) {
		this.txtPrimeiraHabilitacao.setText(DataFormatada.parseStringDataSimples(data));
	}
	
	public Date getTxtValidadeCarteira() {
		return DataFormatada.parseDataSimples(txtValidadeCarteira.getText());
	}
	
	public void setTxtValidadeCarteira(Date data) {
		this.txtValidadeCarteira.setText(DataFormatada.parseStringDataSimples(data));
	}
	
	public boolean verificaCamposBranco() {
//		return false; //exemplo false = não tem campos em branco
		
		if(txtCpf.getValue() == null || txtDtaNascimento.getValue() == null ||  txtEmail.getText().equals("") ||
			txtEstadoEmissor.getValue() == null || txtFone.getValue() == null || txtNome.getText().equals("") ||
			txtNumHabilitacao.getValue() == null || txtPrimeiraHabilitacao.getValue() == null ||
			txtRg.getText().equals("") || txtValidadeCarteira.getValue() == null){
			
			return true;
		}
		return false;
	}
	
	public void desabilitarCampos(){
		txtCpf.setEditable(false);
		txtDtaNascimento.setEditable(false);
		txtEmail.setEditable(false);
		txtEstadoEmissor.setEditable(false);
		txtFone.setEditable(false);
		txtNome.setEditable(false);
		txtNumHabilitacao.setEditable(false);
		txtPrimeiraHabilitacao.setEditable(false);
		txtRg.setEditable(false);
		txtValidadeCarteira.setEditable(false);
	}
	
	public void habilitarCampos(){
		txtCpf.setEditable(true);
		txtDtaNascimento.setEditable(true);
		txtEmail.setEditable(true);
		txtEstadoEmissor.setEditable(true);
		txtFone.setEditable(true);
		txtNome.setEditable(true);
		txtNumHabilitacao.setEditable(true);
		txtPrimeiraHabilitacao.setEditable(true);
		txtRg.setEditable(true);
		txtValidadeCarteira.setEditable(true);
	}


	
	
}
