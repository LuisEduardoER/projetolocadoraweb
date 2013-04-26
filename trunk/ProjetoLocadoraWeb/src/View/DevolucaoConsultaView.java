//Classe DevolucaoConsultaView
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Util.Conversao;
import Util.Idioma;
import View.Botoes.*;
import View.Datas.DataFormatada;
import View.Frames.JFrameDefault;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;
import View.TextFields.CampoTexto;

public class DevolucaoConsultaView extends JFrameDefault{

	private Rotulo lbIdLocacaoConsulta;
	private Rotulo lbCnpjConsulta;
	private Rotulo lbIdLocacaoRes;
	private Rotulo lbNomeCliente;
	private Rotulo lbCnpjRes;
	private Rotulo lbDtaRetirada;
	private Rotulo lbDtaDevolucao;
	private Rotulo lbQtdDias;
	private Rotulo lbTotal;
	private Rotulo lbTipoTarifa;
	private Rotulo lbAgenciaRetirada;
	private Rotulo lbAgenciaDevolucao;
	
	private CampoTexto txtIdLocacaoConsulta;
	private CampoTexto txtCnpjConsulta;
	private CampoTexto txtIdLocacaoRes;
	private CampoTexto txtNomeCliente;
	private CampoTexto txtCnpjRes;
	private CampoTexto txtDtaRetirada;
	private CampoTexto txtDtaDevolucao;
	private CampoTexto txtQtdDias;
	private CampoTexto txtTotal;
	private CampoTexto txtTipoTarifa;
	private CampoTexto txtAgenciaRetirada;
	private CampoTexto txtAgenciaDevolucao;
	
	private BotaoVoltar btVoltar;
	private BotaoConsultar btConsultar;
	private BotaoAvancar btAvançar;
		
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JPanel panelInferior;
	
	public DevolucaoConsultaView(){
		montaGUI();
		desabilitarCamposInferior();
	}
	
	
	public void montaGUI() {
		initComponents();
		montaPanelPrincipal();
		
		add(panelPrincipal);
		montaJFrame(Idioma.bn.getString("devolucaoConsultaView.title"));
	}
	
	private void montaPanelPrincipal() {
		montaPanelSuperior();
		montaPanelCentral();
		montaPanelInferior();
		
		panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.setBorder(new EmptyBorder(50, 80, 50, 80));
		panelPrincipal.add(panelSuperior , BorderLayout.NORTH);
		panelPrincipal.add(panelCentral , BorderLayout.CENTER);
		panelPrincipal.add(panelInferior , BorderLayout.SOUTH);
		
		
		
	}

	private void montaPanelSuperior() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(4, 0, 4, 4);
		gbc.anchor = GridBagConstraints.WEST;
		
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; // uma célula na linha
	    panel.add(lbIdLocacaoConsulta , gbc);
	    
	    gbc.gridy = 0; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtIdLocacaoConsulta , gbc);
	    	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbCnpjConsulta , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtCnpjConsulta , gbc);
	    
	    gbc.insets = new Insets(4, 40, 4, 4);
		gbc.anchor = GridBagConstraints.CENTER;
	    gbc.gridy = 0; // linha
	    gbc.gridx = 2; // coluna
	    gbc.gridheight = 2;
	    panel.add(btConsultar , gbc);
	      
		
		panelSuperior = new JPanel();
		panelSuperior.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
		panelSuperior.add(panel);
		
	}
	
	private void montaPanelCentral() {
		panelCentral = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelCentral.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.insets = new Insets(4, 0, 4, 4);
		gbc.anchor = GridBagConstraints.WEST;
		
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; // uma célula na linha
	    panelCentral.add(lbIdLocacaoRes , gbc);
	    
	    gbc.gridy = 0; // linha
	    gbc.gridx = 1; // coluna
	    panelCentral.add(txtIdLocacaoRes , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelCentral.add(lbNomeCliente , gbc);

	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panelCentral.add(txtNomeCliente , gbc);

	    gbc.gridy = 1; // linha
	    gbc.gridx = 2; // coluna
	    panelCentral.add(lbCnpjRes , gbc);

	    gbc.gridy = 1; // linha
	    gbc.gridx = 3; // coluna
	    panelCentral.add(txtCnpjRes , gbc);

	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panelCentral.add(lbDtaRetirada , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panelCentral.add(txtDtaRetirada , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 2; // coluna
	    panelCentral.add(lbAgenciaRetirada , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 3; // coluna
	    panelCentral.add(txtAgenciaRetirada , gbc);
	    
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panelCentral.add(lbDtaDevolucao , gbc);

	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panelCentral.add(txtDtaDevolucao , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 2; // coluna
	    panelCentral.add(lbAgenciaDevolucao , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 3; // coluna
	    panelCentral.add(txtAgenciaDevolucao , gbc);
	    	    

	    gbc.gridy = 4; // linha
	    gbc.gridx = 0; // coluna
	    panelCentral.add(lbTipoTarifa , gbc);

	    gbc.gridy = 4; // linha
	    gbc.gridx = 1; // coluna
	    panelCentral.add(txtTipoTarifa , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 2; // coluna
	    panelCentral.add(lbQtdDias , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 3; // coluna
	    panelCentral.add(txtQtdDias , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 2; // coluna
	    panelCentral.add(lbTotal , gbc);

	    gbc.gridy = 5; // linha
	    gbc.gridx = 3; // coluna
	    panelCentral.add(txtTotal , gbc);
	    
	}

	private void montaPanelInferior() {
		panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER , 10 , 0));
		panelInferior.setBorder(new EmptyBorder(30, 20, 20, 20));
		panelInferior.add(btVoltar);
		panelInferior.add(btAvançar);
	}



	public void initComponents(){
		lbCnpjConsulta = new Rotulo(RotuloNomes.getCNPJ_CPF());
		lbCnpjRes = new Rotulo(RotuloNomes.getCNPJ_CPF());
		lbDtaDevolucao = new Rotulo(RotuloNomes.getDATA_HORA_DEVOLUCAO());
		lbDtaRetirada = new Rotulo(RotuloNomes.getDATA_HORA_RETIRADA());
		lbIdLocacaoConsulta = new Rotulo(RotuloNomes.getID_LOCACAO());
		lbIdLocacaoRes = new Rotulo(RotuloNomes.getID_LOCACAO());
		lbNomeCliente = new Rotulo(RotuloNomes.getNOME_CLIENTE());
		lbQtdDias = new Rotulo(RotuloNomes.getQTD_DIAS());
		lbTipoTarifa = new Rotulo(RotuloNomes.getTIPO_TARIFA());
		lbTotal = new Rotulo(RotuloNomes.getTOTAL());
		lbAgenciaRetirada = new Rotulo(RotuloNomes.getAGENCIA_RETIRADA());
		lbAgenciaDevolucao = new Rotulo(RotuloNomes.getAGENCIA_DEVOLUCAO());
		
		txtCnpjConsulta = new CampoTexto(19 , 10);
		txtCnpjRes = new CampoTexto(19 , 10);
		txtDtaDevolucao = new CampoTexto(20 , 10);
		txtDtaRetirada = new CampoTexto(20 , 10);
		txtIdLocacaoConsulta = new CampoTexto(10 , 4);
		txtIdLocacaoRes = new CampoTexto(10 , 4);
		txtNomeCliente = new CampoTexto(50, 20);
		txtQtdDias = new CampoTexto(5, 5);
		txtTipoTarifa = new CampoTexto(15, 7);
		txtTotal = new CampoTexto(15, 7);
		txtAgenciaDevolucao = new CampoTexto(40, 15);
		txtAgenciaRetirada = new CampoTexto(40, 15);
		
		btAvançar = new BotaoAvancar();
		btConsultar = new BotaoConsultar();
		btVoltar = new BotaoVoltar();
			
	}
	
	public void addBtConsultarListener(ActionListener a){
		btConsultar.addActionListener(a);
	}
	
	public void addBtVoltarListener(ActionListener a){
		btVoltar.addActionListener(a);
	}
	
	public void addBtAvancarListener(ActionListener a){
		btAvançar.addActionListener(a);
	}


	public int getTxtIdLocacaoConsulta() {
		return Integer.valueOf(txtIdLocacaoConsulta.getText());
	}
	
	public void setTxtIdLocacaoConsulta(int idLocacaoConsulta) {
		this.txtIdLocacaoConsulta.setText(String.valueOf(idLocacaoConsulta));
	}
	
	public String getTxtCnpjConsulta() {
		return txtCnpjConsulta.getText();
	}
	
	public void setTxtCnpjConsulta(String cnpjConsulta) {
		this.txtCnpjConsulta.setText(cnpjConsulta);
	}
	
	public int getTxtIdLocacaoRes() {
		return Integer.valueOf(txtIdLocacaoRes.getText());
	}
	
	public void setTxtIdLocacaoRes(int idLocacaoRes) {
		this.txtIdLocacaoRes.setText(String.valueOf(idLocacaoRes));
	}
	
	public String getTxtNomeCliente() {
		return txtNomeCliente.getText();
	}
	
	public void setTxtNomeCliente(String nomeCliente) {
		this.txtNomeCliente.setText(nomeCliente);
	}
	
	public String getTxtCnpjRes() {
		return txtCnpjRes.getText();
	}
	
	public void setTxtCnpjRes(String cnpjRes) {
		this.txtCnpjRes.setText(cnpjRes);
	}
	
	public Date getTxtDtaRetirada() {
		return DataFormatada.parseDataCompleta(txtDtaRetirada.getText());
	}
	
	public void setTxtDtaRetirada(Date dtaRetirada) {
		this.txtDtaRetirada.setText(DataFormatada.parseStringDataCompleta(dtaRetirada));
	}
	
	public Date getTxtDtaDevolucao() {
		return DataFormatada.parseDataCompleta(txtDtaDevolucao.getText());
	}
	
	public void setTxtDtaDevolucao(Date dtaDevolucao) {
		this.txtDtaDevolucao.setText(DataFormatada.parseStringDataCompleta(dtaDevolucao));
	}
	
	public int getTxtQtdDias() {
		return Integer.valueOf(txtQtdDias.getText());
	}
	
	public void setTxtQtdDias(int qtdDias) {
		this.txtQtdDias.setText(String.valueOf(qtdDias));
	}
	
	public double getTxtTotal() {
		return Double.valueOf(txtTotal.getText());
	}
	
	public void setTxtTotal(double total) {
		this.txtTotal.setText(Conversao.formatDouble(total));
	}
	
	public String getTxtTipoTarifa() {
		return txtTipoTarifa.getText();
	}
	
	public void setTxtTipoTarifa(String tipoTarifa) {
		this.txtTipoTarifa.setText(tipoTarifa);
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
	
	public void desabilitarCamposInferior(){
		txtIdLocacaoRes.setEditable(false);
		txtNomeCliente.setEditable(false);
		txtDtaRetirada.setEditable(false);
		txtDtaDevolucao.setEditable(false);
		txtTipoTarifa.setEditable(false);
		txtCnpjRes.setEditable(false);
		txtAgenciaRetirada.setEditable(false);
		txtAgenciaDevolucao.setEditable(false);
		txtQtdDias.setEditable(false);
		txtTotal.setEditable(false);
	}
	
	public void habilitarCamposInferior(){
		txtIdLocacaoRes.setEditable(true);
		txtNomeCliente.setEditable(true);
		txtDtaRetirada.setEditable(true);
		txtDtaDevolucao.setEditable(true);
		txtTipoTarifa.setEditable(true);
		txtCnpjRes.setEditable(true);
		txtAgenciaRetirada.setEditable(true);
		txtAgenciaDevolucao.setEditable(true);
		txtQtdDias.setEditable(true);
		txtTotal.setEditable(true);
	}


	public void limparCamposSuperior() {
		txtIdLocacaoConsulta.setText("");
		txtCnpjConsulta.setText("");
	}
	
}
