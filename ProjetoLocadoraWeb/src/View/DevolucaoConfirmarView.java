//Classe DevolucaoConfirmarView
package View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.Conversao;
import Util.Idioma;
import View.Botoes.BotaoImprimirComprovante;
import View.Datas.DataFormatada;
import View.Frames.JFrameDefault;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;
import View.TextFields.CampoTexto;

public class DevolucaoConfirmarView extends JFrameDefault{
	
	private Rotulo lbDadosDevolucao;
	private Rotulo lbIdLocacao;
	private Rotulo lbCliente;
	private Rotulo lbCnpj;
	private Rotulo lbDtaRetirada;
	private Rotulo lbQtdDias;
	private Rotulo lbDtaDevolucao;
	private Rotulo lbTipoTarifa;
	private Rotulo lbTotal;
	private Rotulo lbAgenciaRetirada;
	private Rotulo lbAgenciaDevolucao;
	
	private CampoTexto txtIdLocacao;
	private CampoTexto txtCliente;
	private CampoTexto txtCnpj;
	private CampoTexto txtDtaRetirada;
	private CampoTexto txtQtdDias;
	private CampoTexto txtDtaDevolucao;
	private CampoTexto txtTipoTarifa;
	private CampoTexto txtTotal;
	private CampoTexto txtAgenciaRetirada;
	private CampoTexto txtAgenciaDevolucao;
	
	private BotaoImprimirComprovante btImprimirComprovante;
		
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JPanel panelInferior;
	
	public DevolucaoConfirmarView(){
		montaGUI();
		desabilitarCampos();
	}
	
	
	@Override
	public void montaGUI() {
		initComponents();
		montaPanelPrincipal();
		
		add(panelPrincipal);
		montaJFrame(Idioma.bn.getString("devolucaoConfirmarView.title"));
		
	}

	private void montaPanelPrincipal() {
		montaPanelSuperior();
		montaPanelInferior();
		
		panelPrincipal = new JPanel(new BorderLayout(20, 0));
		panelPrincipal.setBorder(new EmptyBorder(20, 30, 20, 30));
		panelPrincipal.add(panelSuperior , BorderLayout.NORTH);
		panelPrincipal.add(panelInferior , BorderLayout.SOUTH);
		
		
	}
	
	private void montaPanelSuperior() {
		panelSuperior = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelSuperior.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; 
	    panelSuperior.add(lbDadosDevolucao , gbc);
	    
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbIdLocacao , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtIdLocacao , gbc);
	    
	    gbc.insets = new Insets(4, 0, 15, 0);
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbCliente , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtCliente , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(lbCnpj , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(txtCnpj , gbc);
	    
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbDtaRetirada , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtDtaRetirada , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(lbTipoTarifa , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(txtTipoTarifa , gbc);
		
	    gbc.gridy = 4; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbDtaDevolucao , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtDtaDevolucao , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(lbQtdDias , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(txtQtdDias , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbAgenciaRetirada , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtAgenciaRetirada , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(lbTotal , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(txtTotal , gbc);
	    
	    
	    gbc.gridy = 6; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbAgenciaDevolucao , gbc);
	    
	    gbc.gridy = 6; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtAgenciaDevolucao , gbc);
	    
    
	}


	private void montaPanelInferior() {
		panelInferior = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelInferior.setBorder(new EmptyBorder(20, 30, 20, 30));
	    gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 2; 
	    panelInferior.add(btImprimirComprovante , gbc);
	    
	    
	}


	@Override
	public void initComponents() {
		lbCliente = new Rotulo(RotuloNomes.getNOME_CLIENTE());
		lbCnpj = new Rotulo(RotuloNomes.getCNPJ_CPF());
		lbDadosDevolucao = new Rotulo(Idioma.bn.getString("devolucaoConfirmarView.dadosDevolucao"));
		lbDtaDevolucao = new Rotulo(RotuloNomes.getDATA_HORA_DEVOLUCAO());
		lbDtaRetirada = new Rotulo(RotuloNomes.getDATA_HORA_RETIRADA());
		lbIdLocacao = new Rotulo(RotuloNomes.getID_LOCACAO());
		lbQtdDias = new Rotulo(RotuloNomes.getQTD_DIAS());
		lbTipoTarifa = new Rotulo(RotuloNomes.getTIPO_TARIFA());
		lbTotal = new Rotulo(RotuloNomes.getTOTAL());
		lbAgenciaRetirada = new Rotulo(RotuloNomes.getAGENCIA_RETIRADA());
		lbAgenciaDevolucao = new Rotulo(RotuloNomes.getAGENCIA_DEVOLUCAO());
		
		txtCliente = new CampoTexto(50, 20);
		txtCnpj = new CampoTexto(19 , 10);
		txtDtaDevolucao = new CampoTexto(20 , 10);
		txtDtaRetirada = new CampoTexto(20 , 10);
		txtIdLocacao = new CampoTexto(10 , 4);
		txtQtdDias =new CampoTexto(5, 5);
		txtTipoTarifa = new CampoTexto(15, 7);
		txtTotal = new CampoTexto(15, 7);
		txtAgenciaDevolucao = new CampoTexto(40, 15);
		txtAgenciaRetirada = new CampoTexto(40, 15);
		
		btImprimirComprovante = new BotaoImprimirComprovante();
	
	}
	
	
	public void addBtImprimirListener(ActionListener a){
		btImprimirComprovante.addActionListener(a);
	}


	public int getTxtIdLocacao() {
		return Integer.valueOf(txtIdLocacao.getText()); 
	}
	
	public void setTxtIdLocacao(int id) {
		this.txtIdLocacao.setText(String.valueOf(id)); 
	}

	public String getTxtCliente() {
		return txtCliente.getText();
	}


	public void setTxtCliente(String cliente) {
		this.txtCliente.setText(cliente);
	}


	public String getTxtCnpj() {
		return txtCnpj.getText();
	}


	public void setTxtCnpj(String cnpj) {
		this.txtCnpj.setText(cnpj);
	}


	public Date getTxtDtaRetirada() {
		return DataFormatada.parseDataCompleta(txtDtaRetirada.getText());
	}


	public void setTxtDtaRetirada(Date dtaRetirada) {
		this.txtDtaRetirada.setText(DataFormatada.parseStringDataCompleta(dtaRetirada));
	}


	public int getTxtQtdDias() {
		return Integer.valueOf(txtQtdDias.getText()); 
	}


	public void setTxtQtdDias(int qtdDias) {
		this.txtQtdDias.setText(String.valueOf(qtdDias));
	}


	public Date getTxtDtaDevolucao() {
		return DataFormatada.parseDataCompleta(txtDtaDevolucao.getText());
	}


	public void setTxtDtaDevolucao(Date date) {
		this.txtDtaDevolucao.setText(DataFormatada.parseStringDataCompleta(date));
	}


	public String getTxtTipoTarifa() {
		return txtTipoTarifa.getText();
	}


	public void setTxtTipoTarifa(String tipoTarifa) {
		this.txtTipoTarifa.setText(tipoTarifa);
	}


	public double getTxtTotal() {
		return Double.valueOf(txtTotal.getText()); 
	}


	public void setTxtTotal(double total) {
		this.txtTotal.setText("R$ " + Conversao.formatDouble(total));
	}


	public String getTxtAgenciaRetirada() {
		return txtAgenciaRetirada.getText();
	}


	public void setTxtAgenciaRetirada(String agenciaRetirada) {
		this.txtAgenciaRetirada.setText(agenciaRetirada);
	}


	public String getTxtAgenciaDevolucao() {
		return txtAgenciaDevolucao.getText();
	}


	public void setTxtAgenciaDevolucao(String agenciaDevolucao) {
		this.txtAgenciaDevolucao.setText(agenciaDevolucao);
	}
	
	public void desabilitarCampos(){
		txtAgenciaDevolucao.setEditable(false);
		txtAgenciaRetirada.setEditable(false);
		txtCliente.setEditable(false);
		txtCnpj.setEditable(false);
		txtDtaDevolucao.setEditable(false);
		txtDtaRetirada.setEditable(false);
		txtIdLocacao.setEditable(false);
		txtQtdDias.setEditable(false);
		txtTipoTarifa.setEditable(false);
		txtTotal.setEditable(false);
	}
	
	public void habilitarCampos(){
		txtAgenciaDevolucao.setEditable(true);
		txtAgenciaRetirada.setEditable(true);
		txtCliente.setEditable(true);
		txtCnpj.setEditable(true);
		txtDtaDevolucao.setEditable(true);
		txtDtaRetirada.setEditable(true);
		txtIdLocacao.setEditable(true);
		txtQtdDias.setEditable(true);
		txtTipoTarifa.setEditable(true);
		txtTotal.setEditable(true);
	}
	

}
