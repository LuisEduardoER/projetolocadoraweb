//Classe DevolucaoValAdicionaisView
package View;

import java.awt.BorderLayout;
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

import Util.Conversao;
import Util.Idioma;
import View.Botoes.BotaoAvancar;
import View.Botoes.BotaoVoltar;
import View.Frames.JFrameDefault;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;
import View.TextFields.CampoTexto;

public class DevolucaoValAdicionaisView extends JFrameDefault{
	
	private Rotulo lbIdLocacao;
	private Rotulo lbNomeCliente;
	private Rotulo lbCnpj;
	private Rotulo lbAcrescimo;
	private Rotulo lbDecrescimo;
	private Rotulo lbDtaDevolucaoAcrescimo;
	private Rotulo lbCidadeDevolucao;
	private Rotulo lbAgenciaDevolucao;
	private Rotulo lbSubTotalDevolucao;
	private Rotulo lbDtaDevolucaoDecrescimo;
	private Rotulo lbSubTotalAcrescimo;
	private Rotulo lbTotal;
	
	private CampoTexto txtIdLocacao;
	private CampoTexto txtNomeCliente;
	private CampoTexto txtCnpj;
	private CampoTexto txtDtaDevolucaoAcrescimo;
	private CampoTexto txtDtaDevolucaoDecrescimo;
	private CampoTexto txtCidadeDevolucao;
	private CampoTexto txtAgenciaDevolucao;
	private CampoTexto txtSubTotalAcrescimo;
	private CampoTexto txtSubTotalDecrescimo;
	private CampoTexto txtTotal;
	
	private BotaoVoltar btVoltar;
	private BotaoAvancar btAvancar;
	
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JPanel panelInferior;
	
	
	
	public DevolucaoValAdicionaisView(){
		montaGUI();
		desabilitarCampos();
	}
	
	
	@Override
	public void montaGUI() {
		initComponents();
		montaPanelPrincipal();
		
		add(panelPrincipal);
		montaJFrame(Idioma.bn.getString("devolucaoValAdicionaisView.title"));
		
	}

	private void montaPanelPrincipal() {
		montaPanelSuperior();
		montaPanelCentral();
		montaPanelInferior();
		
		panelPrincipal = new JPanel(new BorderLayout(10 , 0));
		panelPrincipal.setBorder(new EmptyBorder(20, 30, 20, 30));
		panelPrincipal.add(panelSuperior , BorderLayout.NORTH);
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		panelPrincipal.add(panelInferior , BorderLayout.SOUTH);
		
	}
	
	private void montaPanelSuperior() {
		panelSuperior = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelSuperior.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(4, 0, 4, 4);
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; // três célula na linha
	    panelSuperior.add(lbIdLocacao , gbc);
	    
	    gbc.gridy = 0; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtIdLocacao , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbNomeCliente , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtNomeCliente , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(lbCnpj , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(txtCnpj , gbc);
		
	}


	private void montaPanelCentral() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(new EmptyBorder(20, 30, 20, 30));
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 2; 
	    panel.add(lbAcrescimo , gbc);
	    
	    gbc.insets = new Insets(4, 20, 20, 0);
	    gbc.gridy = 0; // linha
	    gbc.gridx = 2; // coluna
	    panel.add(lbDecrescimo , gbc);
	    
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; 
	    panel.add(lbDtaDevolucaoAcrescimo , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtDtaDevolucaoAcrescimo , gbc);
	    
	    gbc.insets = new Insets(4, 20, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 2; // coluna
	    panel.add(lbDtaDevolucaoDecrescimo , gbc);
	    
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 3; // coluna
	    panel.add(txtDtaDevolucaoDecrescimo , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbCidadeDevolucao , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtCidadeDevolucao , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbAgenciaDevolucao , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtAgenciaDevolucao , gbc);
	    
	    gbc.insets = new Insets(20, 0, 4, 4);
	    gbc.gridy = 4; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbSubTotalAcrescimo , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtSubTotalAcrescimo , gbc);
	    
	    gbc.insets = new Insets(20, 20, 4, 4);
	    gbc.gridy = 4; // linha
	    gbc.gridx = 2; // coluna
	    panel.add(lbSubTotalDevolucao , gbc);
	    
	    gbc.insets = new Insets(20, 0, 4, 4);
	    gbc.gridy = 4; // linha
	    gbc.gridx = 3; // coluna
	    panel.add(txtSubTotalDecrescimo , gbc);
	    
	    gbc.insets = new Insets(20, 20, 4, 4);
	    gbc.gridy = 5; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbTotal , gbc);
	    
	    gbc.insets = new Insets(20, 0, 4, 4);
	    gbc.gridy = 5; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtTotal , gbc);	    
	    
	    
	    
	    panelCentral = new JPanel();
	    panelCentral.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.darkGray , 1 , true) ,
	    		Idioma.bn.getString("devolucaoValAdicionaisView.valAdicionais")));
	    panelCentral.add(panel);
	    
	}
	
	


	private void montaPanelInferior() {
		panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER , 10 , 0));
		panelInferior.setBorder(new EmptyBorder(30, 20, 20, 20));
		panelInferior.add(btVoltar);
		panelInferior.add(btAvancar);
	}


	


	@Override
	public void initComponents() {
		lbAcrescimo = new Rotulo(Idioma.bn.getString("devolucaoValAdicionaisView.acrescimo"));
		lbAgenciaDevolucao = new Rotulo(RotuloNomes.getAGENCIA_DEVOLUCAO());
		lbCidadeDevolucao = new Rotulo(RotuloNomes.getCIDADE_DEVOLUCAO());
		lbCnpj = new Rotulo(RotuloNomes.getCNPJ_CPF());
		lbDecrescimo = new Rotulo(Idioma.bn.getString("devolucaoValAdicionaisView.decrescimo"));
		lbDtaDevolucaoAcrescimo = new Rotulo(RotuloNomes.getDATA_DEVOLUCAO());
		lbDtaDevolucaoDecrescimo = new Rotulo(RotuloNomes.getDATA_DEVOLUCAO());
		lbIdLocacao = new Rotulo(RotuloNomes.getNUMERO());
		lbNomeCliente = new Rotulo(RotuloNomes.getNOME_CLIENTE());
		lbSubTotalAcrescimo = new Rotulo(RotuloNomes.getSUBTOTAL());
		lbSubTotalDevolucao = new Rotulo(RotuloNomes.getSUBTOTAL());
		lbTotal = new Rotulo(RotuloNomes.getTOTAL());
		
		txtAgenciaDevolucao = new CampoTexto(15, 7);
		txtCidadeDevolucao = new CampoTexto(15, 7);
		txtCnpj = new CampoTexto(19 , 10);
		txtDtaDevolucaoAcrescimo = new CampoTexto(15, 7);
		txtDtaDevolucaoDecrescimo = new CampoTexto(15, 7);
		txtIdLocacao = new CampoTexto(10 , 4);
		txtNomeCliente = new CampoTexto(50, 20);
		txtSubTotalAcrescimo = new CampoTexto(15, 7);
		txtSubTotalDecrescimo = new CampoTexto(15, 7);
		txtTotal = new CampoTexto(15, 7);
		
		btAvancar = new BotaoAvancar();
		btVoltar = new BotaoVoltar();
	}
	
	public void addBtAvancarListener(ActionListener a){
		btAvancar.addActionListener(a);
	}
	
	public void addBtVoltarListener(ActionListener a){
		btVoltar.addActionListener(a);
	}


	public int getTxtIdLocacao() {
		return Integer.parseInt(txtIdLocacao.getText());
	}


	public void setTxtIdLocacao(int idLocacao) {
		this.txtIdLocacao.setText(String.valueOf(idLocacao));
	}


	public String getTxtNomeCliente() {
		return txtNomeCliente.getText();
	}


	public void setTxtNomeCliente(String nomeCliente) {
		this.txtNomeCliente.setText(nomeCliente);
	}


	public String getTxtCnpj() {
		return txtCnpj.getText();
	}


	public void setTxtCnpj(String cnpj) {
		this.txtCnpj.setText(cnpj);
	}


	public String getTxtDtaDevolucaoAcrescimo() {
		return txtDtaDevolucaoAcrescimo.getText();
	}


	public void setTxtDtaDevolucaoAcrescimo(double dtaDevolucaoAcrescimo) {
		txtDtaDevolucaoAcrescimo.setText("R$ " + Conversao.formatDouble(dtaDevolucaoAcrescimo));
	}


	public String getTxtDtaDevolucaoDecrescimo() {
		return txtDtaDevolucaoDecrescimo.getText();
	}


	public void setTxtDtaDevolucaoDecrescimo(double dtaDevolucaoDecrescimo) {
		this.txtDtaDevolucaoDecrescimo.setText("R$ " + Conversao.formatDouble(dtaDevolucaoDecrescimo));
	}


	public String getTxtCidadeDevolucao() {
		return txtCidadeDevolucao.getText();
	}


	public void setTxtCidadeDevolucao(double cidadeDevolucao) {
		this.txtCidadeDevolucao.setText("R$ " + Conversao.formatDouble(cidadeDevolucao));
	}


	public String getTxtAgenciaDevolucao() {
		return txtAgenciaDevolucao.getText();
	}


	public void setTxtAgenciaDevolucao(double agenciaDevolucao) {
		this.txtAgenciaDevolucao.setText("R$ " + Conversao.formatDouble(agenciaDevolucao) );
	}


	public String getTxtSubTotalAcrescimo() {
		return txtSubTotalAcrescimo.getText();
	}


	public void setTxtSubTotalAcrescimo(double subTotalAcrescimo) {
		this.txtSubTotalAcrescimo.setText("R$ " + Conversao.formatDouble(subTotalAcrescimo));
	}


	public String getTxtSubTotalDecrescimo() {
		return txtSubTotalDecrescimo.getText();
	}


	public void setTxtSubTotalDecrescimo(double subTotalDecrescimo) {
		this.txtSubTotalDecrescimo.setText("R$ " + Conversao.formatDouble(subTotalDecrescimo));
	}
	
	
	public String getTxtTotal() {
		return txtTotal.getText();
	}


	public void setTxtTotal(double total) {
		this.txtTotal.setText("R$ " + Conversao.formatDouble(total));
	}
	
	
	public void desabilitarCampos(){
		txtAgenciaDevolucao.setEditable(false);
		txtCidadeDevolucao.setEditable(false);
		txtCnpj.setEditable(false);
		txtDtaDevolucaoAcrescimo.setEditable(false);
		txtDtaDevolucaoDecrescimo.setEditable(false);
		txtIdLocacao.setEditable(false);
		txtNomeCliente.setEditable(false);
		txtSubTotalAcrescimo.setEditable(false);
		txtSubTotalDecrescimo.setEditable(false);
		txtTotal.setEditable(false);
	}
	
	public void habilitarCampos(){
		txtAgenciaDevolucao.setEditable(true);
		txtCidadeDevolucao.setEditable(true);
		txtCnpj.setEditable(true);
		txtDtaDevolucaoAcrescimo.setEditable(true);
		txtDtaDevolucaoDecrescimo.setEditable(true);
		txtIdLocacao.setEditable(true);
		txtNomeCliente.setEditable(true);
		txtSubTotalAcrescimo.setEditable(true);
		txtSubTotalDecrescimo.setEditable(true);
		txtTotal.setEditable(false);
	}

}
