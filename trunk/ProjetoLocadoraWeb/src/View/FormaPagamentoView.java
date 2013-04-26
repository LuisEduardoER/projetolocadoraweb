//Classe FormaPagamentoView
package View;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import Util.Conversao;
import Util.Idioma;
import View.Botoes.BotaoConfirmar;
import View.Botoes.BotaoVoltar;
import View.Datas.DataFormatada;
import View.Frames.JFrameDefault;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;
import View.TextFields.CampoTexto;
import View.TextFields.CampoTextoFormatado;
import View.TextFields.CampoTextoFormatadoCpf;
import View.TextFields.CampoTextoFormatadoData;
import View.TextFields.CampoTextoFormatadoTelefone;

public class FormaPagamentoView extends JFrameDefault{

//	JLABELS
	private Rotulo lbFormaPagamento;
	private Rotulo lbTipoCartao;
	private Rotulo lbNomeCartao;
	private Rotulo lbCpfCartao;
	private Rotulo lbNroCartao;
	private Rotulo lbDtaValidadeCartao;
	private Rotulo lbCodSegCartao;
	private Rotulo lbNroBanco;
	private Rotulo lbNroAgenciaBanco;
	private Rotulo lbCcoBanco;
	private Rotulo lbNomeBanco;
	private Rotulo lbCpfBanco;
	private Rotulo lbFoneBanco;
	private Rotulo lbTotal;
	
//	JTEXTFIELDS
	private CampoTexto txtTipoCartao;
	private CampoTexto txtNomeCliCartao;
	private CampoTextoFormatadoCpf txtCpfCartao;
	private CampoTextoFormatado txtNroCartao;
	private CampoTextoFormatadoData txtDtaValidadeCartao;
	private CampoTextoFormatado txtCodSegCartao;
	private CampoTexto txtNomeBanco;
	private CampoTextoFormatado txtNroAgencia;
	private CampoTextoFormatado txtCcoBanco;
	private CampoTexto txtNomeCliBanco;
	private CampoTextoFormatadoCpf txtCpfBanco;
	private CampoTextoFormatadoTelefone txtFoneBanco;
	private CampoTexto txtTotal;

	
//	JBUTTONS
	private BotaoVoltar btVoltar;
	private BotaoConfirmar btConfirmar;
		
	
//	JRADIOBUTTONS
	private JRadioButton rbCartao;
	private JRadioButton rbCheque;
	private JRadioButton rbDinheiro;
	private ButtonGroup radioGroup;
	
//	JPANELS
	private JPanel panelPrincipal;
	private JPanel panelCartao;
	private JPanel panelCheque;
	
	
	public FormaPagamentoView(){
		montaGUI();
		txtTotal.setEditable(false);
	}
	
	
	public void montaGUI() {
		initComponents();
		montaFramePrincipal();
		add(panelPrincipal);
		
		montaJFrame(Idioma.bn.getString("formaPagamentoView.title"));
	}


	private void montaFramePrincipal() {
		montaPanelCartao();
		montaPanelCheque();
		
		panelPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelPrincipal.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.insets = new Insets(4, 0, 20, 10);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy = 0; 
	    gbc.gridx = 0; 
	    gbc.gridwidth = 1; 
	    panelPrincipal.add(lbFormaPagamento , gbc);
	    
	    gbc.anchor = GridBagConstraints.NORTH;
	    gbc.gridy = 1; 
	    gbc.gridx = 0; 
	    panelPrincipal.add(panelCartao , gbc);
	    
	    gbc.gridy = 1; 
	    gbc.gridx = 1; 
	    panelPrincipal.add(panelCheque , gbc);
	    	    
	    gbc.insets = new Insets(7, 0, 0, 0);
	    gbc.gridy = 1; 
	    gbc.gridx = 2;
	    panelPrincipal.add(rbDinheiro , gbc);
	    
	    JPanel panelTotal = new JPanel(new FlowLayout(FlowLayout.CENTER , 10 , 0));
	    panelTotal.add(lbTotal);
	    panelTotal.add(txtTotal);
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.insets = new Insets(20, 0, 0, 0);
	    gbc.gridy = 2; 
	    gbc.gridx = 0;
	    panelPrincipal.add(panelTotal , gbc);
	    
	    	    
	    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER , 10 , 0));
		panel.setBorder(new EmptyBorder(30, 20, 20, 20));
		panel.add(btVoltar);
		panel.add(btConfirmar);
		
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.gridy = 3; 
	    gbc.gridx = 0;
	    gbc.gridwidth = 3;
	    gbc.anchor = GridBagConstraints.CENTER;
	    panelPrincipal.add(panel , gbc);
	    
	}


	private void montaPanelCartao() {
		panelCartao = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy = 0; 
	    gbc.gridx = 0; 
	    gbc.gridwidth = 1; 
	    panelCartao.add(rbCartao , gbc);
	    
	    
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelCartao.add(lbTipoCartao , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panelCartao.add(txtTipoCartao , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panelCartao.add(lbNomeCartao , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panelCartao.add(txtNomeCliCartao , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panelCartao.add(lbCpfCartao , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panelCartao.add(txtCpfCartao , gbc);
		
	    gbc.gridy = 4; // linha
	    gbc.gridx = 0; // coluna
	    panelCartao.add(lbNroCartao , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 1; // coluna
	    panelCartao.add(txtNroCartao , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 0; // coluna
	    panelCartao.add(lbDtaValidadeCartao , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 1; // coluna
	    panelCartao.add(txtDtaValidadeCartao , gbc);
	    
	    gbc.gridy = 6; // linha
	    gbc.gridx = 0; // coluna
	    panelCartao.add(lbCodSegCartao , gbc);
	    
	    gbc.gridy = 6; // linha
	    gbc.gridx = 1; // coluna
	    panelCartao.add(txtCodSegCartao , gbc);
	    
	}


	private void montaPanelCheque() {
		panelCheque = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy = 0; 
	    gbc.gridx = 0; 
	    gbc.gridwidth = 1; 
	    panelCheque.add(rbCheque , gbc);
	    
	    
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelCheque.add(lbNroBanco , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panelCheque.add(txtNomeBanco , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panelCheque.add(lbNroAgenciaBanco , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panelCheque.add(txtNroAgencia , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panelCheque.add(lbCcoBanco , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panelCheque.add(txtCcoBanco , gbc);
		
	    gbc.gridy = 4; // linha
	    gbc.gridx = 0; // coluna
	    panelCheque.add(lbNomeBanco , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 1; // coluna
	    panelCheque.add(txtNomeCliBanco , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 0; // coluna
	    panelCheque.add(lbCpfBanco , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 1; // coluna
	    panelCheque.add(txtCpfBanco , gbc);
	    
	    gbc.gridy = 6; // linha
	    gbc.gridx = 0; // coluna
	    panelCheque.add(lbFoneBanco , gbc);
	    
	    gbc.gridy = 6; // linha
	    gbc.gridx = 1; // coluna
	    panelCheque.add(txtFoneBanco , gbc);
	    		
	}


	public void initComponents() {
		lbCcoBanco = new Rotulo(RotuloNomes.getCCO());
		lbCodSegCartao = new Rotulo(RotuloNomes.getCOD_SEGURANCA());
		lbCpfBanco = new Rotulo(RotuloNomes.getCPF());
		lbCpfCartao = new Rotulo(RotuloNomes.getCPF());
		lbDtaValidadeCartao = new Rotulo(RotuloNomes.getDATA_VALIDADE());
		lbFoneBanco = new Rotulo(RotuloNomes.getTELEFONE());
		lbFormaPagamento = new Rotulo(RotuloNomes.getFORMA_PAGAMENTO());
		lbNomeBanco = new Rotulo(RotuloNomes.getNOME());
		lbNomeCartao = new Rotulo(RotuloNomes.getNOME());
		lbNroAgenciaBanco = new Rotulo(RotuloNomes.getAGENCIA());
		lbNroBanco = new Rotulo(RotuloNomes.getBANCO());
		lbNroCartao = new Rotulo(RotuloNomes.getNUM_CARTAO());
		lbTipoCartao = new Rotulo(RotuloNomes.getTIPO());
		lbTotal = new Rotulo(RotuloNomes.getTOTAL());
		
		txtCcoBanco = new CampoTextoFormatado("**********" ,"0123456789.- " , 8 , "Código da Conta Corrente. Ex: 0124-91");
		txtCodSegCartao = new CampoTextoFormatado("###*" , "0123456789 ",  3 , "Formato: 0124");
		txtCpfBanco = new CampoTextoFormatadoCpf();
		txtCpfCartao = new CampoTextoFormatadoCpf();
		txtDtaValidadeCartao = new CampoTextoFormatadoData();
		txtFoneBanco = new CampoTextoFormatadoTelefone();
		txtNomeCliBanco = new CampoTexto(50, 15);
		txtNomeCliCartao = new CampoTexto(50, 15);
		txtNroAgencia = new CampoTextoFormatado("####**" , "0123456789 ",  5 , "Código da Agência. Formato: 012456");
		txtNomeBanco = new CampoTexto(10 , 20 , "Nome do Banco. ex: Itaú, Bradesco, etc..");
		txtNroCartao = new CampoTextoFormatado("**** **** **** ****" , "0123456789",  10 , "Formato: XXXX XXXX XXXX XXXX");
		txtTipoCartao = new CampoTexto(10 , 20 , "Nome da Operadora do Cartão de Crédito. Ex: Visa, Mastecard, etc..");
		txtTotal = new CampoTexto(17, 7);
//		
		btConfirmar = new BotaoConfirmar();
		btVoltar = new BotaoVoltar();
		
		rbCartao = new JRadioButton(Idioma.bn.getString("formaPagamentoView.cartao") , true);
		rbCheque = new JRadioButton(Idioma.bn.getString("formaPagamentoView.cheque"), false);
		rbDinheiro = new JRadioButton(Idioma.bn.getString("formaPagamentoView.dinheiro"), false);
		
		radioGroup = new ButtonGroup();
		
		radioGroup.add(rbCartao);
		radioGroup.add(rbCheque);
		radioGroup.add(rbDinheiro);
		radioGroup.clearSelection();
		
	}
	
	public void addRadioButtonListener(ItemListener a){
		rbCartao.addItemListener(a);
		rbCheque.addItemListener(a);
		rbDinheiro.addItemListener(a);
	}
			
	public void addBtConfirmarListener(ActionListener a){
		btConfirmar.addActionListener(a);
	}
	
	public void addBtVoltarListener(ActionListener a){
		btVoltar.addActionListener(a);
	}
	
	public JRadioButton getRbCartao() {
		return rbCartao;
	}

	public JRadioButton getRbCheque() {
		return rbCheque;
	}

	public JRadioButton getRbDinheiro() {
		return rbDinheiro;
	}

	public String getTxtTipoCartao() {
		return txtTipoCartao.getText();
	}
	
	public void setTxtTipoCartao(String tipoCartao) {
		this.txtTipoCartao.setText(tipoCartao);
	}
	
	public String getTxtNomeCliCartao() {
		return txtNomeCliCartao.getText();
	}
	
	public void setTxtNomeCliCartao(String nomeCliente) {
		this.txtNomeCliCartao.setText(nomeCliente);
	}
		
	public String getTxtCpfCartao() {
		return txtCpfCartao.getText();
	}
	
	public void setTxtCpfCartao(String cpfCartao) {
		this.txtCpfCartao.setText(cpfCartao);
	}
	
	public String getTxtNroCartao() {
		return txtNroCartao.getText();
	}
	
	public void setTxtNroCartao(String nroCartao) {
		this.txtNroCartao.setText(nroCartao);
	}
	

	public Date getTxtDtaValidadeCartao() {
		return DataFormatada.parseDataSimples(txtDtaValidadeCartao.getText());
	}
	
	public void setTxtDtaValidadeCartao(Date data) {
		this.txtDtaValidadeCartao.setText(DataFormatada.parseStringDataSimples(data));
	}
		
	
	public String getTxtCodSegCartao() {
		return txtCodSegCartao.getText();
	}
	
	public void setTxtCodSegCartao(String codSegCartao) {
		this.txtCodSegCartao.setText(codSegCartao);
	}
	
	public String getTxtNroBanco() {
		return txtNomeBanco.getText();
	}
	
	public void setTxtNroBanco(String nroBanco) {
		this.txtNomeBanco.setText(nroBanco);
	}
	
	public String getTxtNroAgencia() {
		return txtNroAgencia.getText();
	}
	
	public void setTxtNroAgencia(String nroAgencia) {
		this.txtNroAgencia.setText(nroAgencia);
	}
	
	public String getTxtCcoBanco() {
		return txtCcoBanco.getText();
	}
	
	public void setTxtCcoBanco(String cco) {
		this.txtCcoBanco.setText(cco);
	}
	
	public String getTxtNomeCliBanco() {
		return txtNomeCliBanco.getText();
	}


	public void setTxtNomeCliBanco(String nomeCliBanco) {
		this.txtNomeCliBanco.setText(nomeCliBanco);
	}
	
	public String getTxtNomeBanco() {
		return txtNomeBanco.getText();
	}
	
	public void setTxtNomeBanco(String nomeBanco) {
		this.txtNomeBanco.setText(nomeBanco);
	}
	
	public String getTxtCpfBanco() {
		return txtCpfBanco.getText();
	}
	
	public void setTxtCpfBanco(String cpfBanco) {
		this.txtCpfBanco.setText(cpfBanco);
	}
	
	public String getTxtFoneBanco() {
		return txtFoneBanco.getText();
	}
	
	public void setTxtFoneBanco(String foneBanco) {
		this.txtFoneBanco.setValue(foneBanco);
	}
	
	public void desabilitarCamposCartao(){
		txtTipoCartao.setEditable(false);
		txtNomeCliCartao.setEditable(false);
		txtCpfCartao.setEditable(false);
		txtNroCartao.setEditable(false);
		txtDtaValidadeCartao.setEditable(false);
		txtCodSegCartao.setEditable(false);
	}
	
	public void habilitarCamposCartao(){
		txtTipoCartao.setEditable(true);
		txtNomeCliCartao.setEditable(true);
		txtCpfCartao.setEditable(true);
		txtNroCartao.setEditable(true);
		txtDtaValidadeCartao.setEditable(true);
		txtCodSegCartao.setEditable(true);
	}
		
	public void desabilitarCamposCheque(){
		txtNomeBanco.setEditable(false);
		txtNroAgencia.setEditable(false);
		txtCcoBanco.setEditable(false);
		txtNomeCliBanco.setEditable(false);
		txtCpfBanco.setEditable(false);
		txtFoneBanco.setEditable(false);
	}
	
	public void habilitarCamposCheque(){
		txtNomeBanco.setEditable(true);
		txtNroAgencia.setEditable(true);
		txtCcoBanco.setEditable(true);
		txtNomeCliBanco.setEditable(true);
		txtCpfBanco.setEditable(true);
		txtFoneBanco.setEditable(true);
	}
	
	
	public boolean verificaCamposBrancoCheque(){
		if(txtNomeBanco.getText().equals("") || txtNroAgencia.getValue() == null || txtCcoBanco.getValue() == null ||
				txtNomeCliBanco.getText().equals("") || txtCpfBanco.getValue() == null || txtFoneBanco.getValue() == null){
				
			return true;
		}
		return false;
	}
	
	public boolean verificaCamposBrancoCartao(){
		if(txtTipoCartao.getText().equals("") || txtNomeCliCartao.getText().equals("") || txtCpfCartao.getValue() == null ||
				txtNroCartao.getValue() == null || txtDtaValidadeCartao.getValue() == null || txtCodSegCartao.getValue() == null){
			return true;
		}
		return false; //não tem campos em brancos
	}


	public String getTxtTotal() {
		return txtTotal.getText();
	}


	public void setTxtTotal(double total) {
		this.txtTotal.setText("R$ " + Conversao.formatDouble(total));
	}
	
	
	
}
