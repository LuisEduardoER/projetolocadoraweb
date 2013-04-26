//Classe VeiculoConsultaDetView
package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.Idioma;
import View.Botoes.BotaoFechar;
import View.Frames.JFrameDefault;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;
import View.TextFields.CampoTexto;

public class VeiculoConsultaDetView extends JFrameDefault{
	
//	LABELS
	private Rotulo lbDadosVeiculo;
	private Rotulo lbModelo;
	private Rotulo lbFabricante;
	private Rotulo lbChassi;
	private Rotulo lbPlaca;
	private Rotulo lbKm;
	private Rotulo lbCidade;
	private Rotulo lbEstado;
	
//	JTEXTFIELDS
	private CampoTexto txtModelo;
	private CampoTexto txtFabricante;
	private CampoTexto txtChassi;
	private CampoTexto txtPlaca;
	private CampoTexto txtKm;
	private CampoTexto txtCidade;
	private CampoTexto txtEstado;
	
//	JBUTTONS
	private BotaoFechar btFechar;
	
//	JPANELS
	private JPanel panelPrincipal;
	private JPanel panelSecundario;
	
	public VeiculoConsultaDetView(){
		montaGUI();
	}
	
	
	
	public void montaGUI() {
		initComponents();
		montaPanelSecundario();
		panelPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelPrincipal.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 3; // três célula na linha
	    panelPrincipal.add(lbDadosVeiculo , gbc);
		
	    gbc.insets = new Insets(10, 0, 10, 0);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(panelSecundario , gbc);
		
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(btFechar , gbc);
		
	    
	    add(panelPrincipal);
		montaJFrame(Idioma.bn.getString("veiculoConsultaDetView.title"));
		
	}


	private void montaPanelSecundario() {
		panelSecundario = new JPanel(new GridBagLayout());
		JPanel panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelSecundario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		panel.setBorder(new EmptyBorder(20, 30, 20, 30));
				
		gbc.insets = new Insets(4, 0, 4, 4);
		gbc.anchor = GridBagConstraints.WEST;
		
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; // uma célula na linha
	    panel.add(lbModelo , gbc);
	    
	    gbc.gridy = 0; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtModelo , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbFabricante , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtFabricante , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbChassi , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtChassi , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbPlaca , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtPlaca , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 2; // coluna
	    panel.add(lbKm , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 3; // coluna
	    panel.add(txtKm , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbCidade , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtCidade , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 2; // coluna
	    panel.add(lbEstado , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 3; // coluna
	    panel.add(txtEstado , gbc);
	    
	    panelSecundario.add(panel);
		
	}



	public void initComponents() {
//		INICIALIZA JLABELS
		lbChassi = new Rotulo(RotuloNomes.getCHASSI());
		lbCidade = new Rotulo(RotuloNomes.getCIDADE());
		lbDadosVeiculo = new Rotulo(RotuloNomes.getDADOS_VEICULO());
		lbEstado = new Rotulo(RotuloNomes.getESTADO());
		lbFabricante = new Rotulo(RotuloNomes.getFABRICANTE());
		lbKm = new Rotulo(RotuloNomes.getKM());
		lbModelo = new Rotulo(RotuloNomes.getMODELO());
		lbPlaca = new Rotulo(RotuloNomes.getPLACA());
		
//		INICIALIZA JTEXTFIELDS
		txtChassi = new CampoTexto(30 , 15);
		txtCidade = new CampoTexto(30 , 15);
		txtEstado = new CampoTexto(30 , 15);
		txtFabricante = new CampoTexto(50 , 20);
		txtKm = new CampoTexto(5 , 3);
		txtModelo = new CampoTexto(20 , 8);
		txtPlaca = new CampoTexto(10 , 5);
		
//		INICIALIZA BOTÕES
		btFechar = new BotaoFechar();
		
	}



	public void addBtFecharListener(ActionListener a){
		btFechar.addActionListener(a);
	}
	
	public String getTxtModelo() {
		return txtModelo.getText();
	}
	
	public void setTxtModelo(String modelo) {
		this.txtModelo.setText(modelo);
	}
	
	public String getTxtFabricante() {
		return txtFabricante.getText();
	}
	
	public void setTxtFabricante(String fabricante) {
		this.txtFabricante.setText(fabricante);
	}
	
	public String getTxtChassi() {
		return txtChassi.getText();
	}
	
	public void setTxtChassi(String chassi) {
		this.txtChassi.setText(chassi);
	}
	
	public String getTxtPlaca() {
		return txtPlaca.getText();
	}
	
	public void setTxtPlaca(String placa) {
		this.txtPlaca.setText(placa);
	}
	
	public String getTxtKm() {
		return txtKm.getText();
	}
	
	public void setTxtKm(String km) {
		this.txtKm.setText(km);
	}
	
	public String getTxtCidade() {
		return txtCidade.getText();
	}
	
	public void setTxtCidade(String cidade) {
		this.txtCidade.setText(cidade);
	}
	
	public String getTxtEstado() {
		return txtEstado.getText();
	}
	
	public void setTxtEstado(String estado) {
		this.txtEstado.setText(estado);
	}
		
}
