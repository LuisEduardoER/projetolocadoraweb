//Classe LocacaoAddMotoristaView
package View;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.Conversao;
import Util.Idioma;
import View.Botoes.BotaoAvancar;
import View.Botoes.BotaoVoltar;
import View.Datas.DataFormatada;

import View.Frames.JFrameDefault;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloDataDevolucao;
import View.Rotulos.RotuloDataRetirada;
import View.Rotulos.RotuloNomes;
import View.TextFields.CampoTexto;

public class LocacaoAddMotoristaView extends JFrameDefault{
	
	private Rotulo lbDadosLocacao;
	private RotuloDataRetirada lbDtaRetirada;
	private RotuloDataDevolucao lbDtaDevolucao;
	private Rotulo lbQtdDias;
	private Rotulo lbTotal;
	private Rotulo lbTipoTarifa;
	private Rotulo lbDadosVeiculo;
	private Rotulo lbGrupo;
	private Rotulo lbAcessorio;
	private Rotulo lbVeiculo;
	private Rotulo lbAgenciaRetirada;
	private Rotulo lbAgenciaDevolucao;
	
	private CampoTexto txtDtaRetirada;
	private CampoTexto txtDtaDevolucao;
	private CampoTexto txtQtdDias;
	private CampoTexto txtTotal;
	private CampoTexto txtTipoTarifa;
	private CampoTexto txtGrupo;
	private CampoTexto txtAcessorio;
	private CampoTexto txtVeiculo;
	private CampoTexto txtAgenciaRetirada;
	private CampoTexto txtAgenciaDevolucao;
	
	private BotaoVoltar btVoltar;
	private BotaoAvancar btAvancar;
		
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JPanel panelInferior;
	
	public LocacaoAddMotoristaView(){
		montaGUI();
		desabilitarCampos();
	}
	
	@Override
	public void montaGUI() {
		initComponents();
		montaPanelPrincipal();
		
		add(panelPrincipal);
		montaJFrame(Idioma.bn.getString("locacaoAddMotoristaView.title"));
	}

	private void montaPanelPrincipal() {
		montaPanelSuperior();
		montaPanelInferior();
		
		panelPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelPrincipal.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(panelSuperior , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(panelInferior , gbc);
		
		
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
	    panelSuperior.add(lbDadosLocacao , gbc);
	    
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbDtaRetirada , gbc);
		
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtDtaRetirada , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(lbAgenciaRetirada , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(txtAgenciaRetirada , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbDtaDevolucao , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtDtaDevolucao , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(lbAgenciaDevolucao , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(txtAgenciaDevolucao , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panelSuperior.add(lbTipoTarifa , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panelSuperior.add(txtTipoTarifa , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(lbQtdDias , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(txtQtdDias , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(lbTotal , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(txtTotal , gbc);
	    
	    
	}

	private void montaPanelInferior() {
		JPanel panelBotoes = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelBotoes.setBorder(new EmptyBorder(20, 30, 20, 30));
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(4, 0, 10, 25);
	    gbc.gridwidth = 1; 
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelBotoes.add(btVoltar , gbc);
	    
		gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panelBotoes.add(btAvancar , gbc);
	    
	    JPanel panelDados = new JPanel(new GridBagLayout());
	    gbc = new GridBagConstraints();
	    
	    panelDados.setBorder(new EmptyBorder(20, 30, 20, 70));
	    
	    gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; 
	    panelDados.add(lbDadosVeiculo , gbc);
	    
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelDados.add(lbGrupo , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panelDados.add(txtGrupo , gbc);
		
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panelDados.add(lbAcessorio , gbc);
		
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panelDados.add(txtAcessorio , gbc);
		
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    panelDados.add(lbVeiculo , gbc);
		
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    panelDados.add(txtVeiculo , gbc);
			    
	    panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    panelInferior.add(panelDados);
	    panelInferior.add(panelBotoes);
	    
	    
	}

	

	@Override
	public void initComponents() {
		lbAcessorio = new Rotulo(RotuloNomes.getACESSORIO());
		lbDadosLocacao = new Rotulo(RotuloNomes.getDADOS_LOCACAO());
		lbDadosVeiculo = new Rotulo(RotuloNomes.getDADOS_VEICULO());
		lbDtaDevolucao = new RotuloDataDevolucao();
		lbDtaRetirada = new RotuloDataRetirada();
		lbGrupo = new Rotulo(RotuloNomes.getGRUPO());
		lbQtdDias = new Rotulo(RotuloNomes.getQTD_DIAS());
		lbTipoTarifa = new Rotulo(RotuloNomes.getTIPO_TARIFA());
		lbTotal = new Rotulo(RotuloNomes.getTOTAL());
		lbVeiculo = new Rotulo(RotuloNomes.getVEICULO());
		lbAgenciaRetirada = new Rotulo(RotuloNomes.getAGENCIA_RETIRADA());
		lbAgenciaDevolucao = new Rotulo(RotuloNomes.getAGENCIA_DEVOLUCAO());
		
		txtAcessorio = new CampoTexto(15, 7);
		txtDtaDevolucao = new CampoTexto(20 , 10);
		txtDtaRetirada = new CampoTexto(20 , 10);
		txtGrupo = new CampoTexto(30 , 15);
		txtQtdDias = new CampoTexto(5, 5);
		txtTipoTarifa = new CampoTexto(15, 7);
		txtTotal = new CampoTexto(15, 7);
		txtVeiculo = new CampoTexto(20 , 15);
		txtAgenciaDevolucao = new CampoTexto(40, 15);
		txtAgenciaRetirada = new CampoTexto(40, 15);
		
		btAvancar = new BotaoAvancar();
		btVoltar = new BotaoVoltar();
				
	}
	
	public void addBtAvancarListener(ActionListener a){
		btAvancar.addActionListener(a);
	}
	
	public void addBtVoltarListener(ActionListener a){
		btVoltar.addActionListener(a);
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
		this.txtTotal.setText("R$ " + Conversao.formatDouble(total));
	}

	public String getTxtTipoTarifa() {
		return txtTipoTarifa.getText();
	}

	public void setTxtTipoTarifa(String tipoTarifa) {
		if(tipoTarifa.equals("livre")){
			this.txtTipoTarifa.setText(Idioma.bn.getString("locacaoAddMotoristaView.livre"));
		}
		else{
			this.txtTipoTarifa.setText(Idioma.bn.getString("locacaoAddMotoristaView.controlada"));
		}	
	}

	public String getTxtGrupo() {
		return txtGrupo.getText();
	}

	public void setTxtGrupo(String grupo) {
		this.txtGrupo.setText(grupo);
	}

	public double getTxtAcessorio() {
		return Double.valueOf(txtAcessorio.getText());
	}

	public void setTxtAcessorio(double acessorio) {
		this.txtAcessorio.setText("R$ " + Conversao.formatDouble(acessorio));
	}

	public String getTxtVeiculo() {
		return txtVeiculo.getText();
	}

	public void setTxtVeiculo(String veiculo) {
		this.txtVeiculo.setText(veiculo);
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
		txtAcessorio.setEditable(false);
		txtAgenciaDevolucao.setEditable(false);
		txtAgenciaRetirada.setEditable(false);
		txtDtaDevolucao.setEditable(false);
		txtDtaRetirada.setEditable(false);
		txtGrupo.setEditable(false);
		txtQtdDias.setEditable(false);
		txtTipoTarifa.setEditable(false);
		txtTotal.setEditable(false);
		txtVeiculo.setEditable(false);
	}
	
}
