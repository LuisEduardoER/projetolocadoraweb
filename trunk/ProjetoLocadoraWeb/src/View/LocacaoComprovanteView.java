//Classe LocacaoComprovanteView
package View;

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

public class LocacaoComprovanteView extends JFrameDefault{
	
//	JLABELS E JTEXTFIELDS
	private Rotulo lbDadosLocacao;
	private Rotulo lbNumeroLocacao;
	private Rotulo lbNomeCliente;
	private Rotulo lbCnpjCpf;
	private Rotulo lbDataRetirada;
	private Rotulo lbDataDevolucao;
	private Rotulo lbTipoTarifa;
	private Rotulo lbQtdDias;
	private Rotulo lbTotal;
	private Rotulo lbDadosVeiculo;
	private Rotulo lbGrupo;
	private Rotulo lbAcessorio;
	private Rotulo lbVeiculo;
	private Rotulo lbAgenciaRetirada;
	private Rotulo lbAgenciaDevolucao;
	
	private CampoTexto txtNumero;
	private CampoTexto txtCliente;
	private CampoTexto txtCnpjCpf;
	private CampoTexto txtDataRetirada;
	private CampoTexto txtDataDevolucao;
	private CampoTexto txtTipoTarifa;
	private CampoTexto txtQtdDias;
	private CampoTexto txtTotal;
	private CampoTexto txtGrupo;
	private CampoTexto txtVeiculo;
	private CampoTexto txtAgenciaRetirada;
	private CampoTexto txtAgenciaDevolucao;
	private CampoTexto txtAcessorio;
	
//	JPANELS
	private JPanel jpLocacao;
	private JPanel jpVeiculo;
	
//	JBUTTONS
	private BotaoImprimirComprovante btImprimirComprovante;
	
		
	public LocacaoComprovanteView(){
		montaGUI();
		desabilitarCampos();
	}
	
	
	public void montaGUI() {
		initComponents();
		montaPanelDadosLocacao();
		montaPanelDadosVeiculo();
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.WEST;
		
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 3; // três célula na linha
	    add(jpLocacao , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 2; // três célula na linha
	    add(jpVeiculo , gbc);
	    
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.insets = new Insets(4, 0, 20, 0);
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 3; // três célula na linha
	    add(btImprimirComprovante , gbc);
	    
	    montaJFrame(Idioma.bn.getString("locacaoComprovanteView.title"));
	}


	private void montaPanelDadosLocacao() {
		jpLocacao = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		jpLocacao.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.anchor = GridBagConstraints.WEST;
		
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; // uma célula na linha
	    jpLocacao.add(lbDadosLocacao , gbc);
	    
	    gbc.insets = new Insets(4, 0, 4, 0);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    jpLocacao.add(lbNumeroLocacao , gbc);
		
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    jpLocacao.add(txtNumero , gbc);
		
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    jpLocacao.add(lbNomeCliente , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    jpLocacao.add(txtCliente , gbc);
	    
	    JPanel panelCpf = new JPanel();
	    panelCpf.add(lbCnpjCpf);
	    panelCpf.add(txtCnpjCpf);
	    
	    gbc.gridwidth = 2;
	    gbc.gridy = 2; // linha
	    gbc.gridx = 2; // coluna
	    jpLocacao.add(panelCpf , gbc);
	    
    
	    gbc.gridwidth = 1;
	    gbc.insets = new Insets(20, 0, 4, 0);
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    jpLocacao.add(lbDataRetirada , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    jpLocacao.add(txtDataRetirada , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 2; // coluna
	    jpLocacao.add(lbAgenciaRetirada , gbc);
	    
	    gbc.gridy = 3; // linha
	    gbc.gridx = 3; // coluna
	    jpLocacao.add(txtAgenciaRetirada , gbc);
	    
	    gbc.insets = new Insets(4, 0, 4, 0);
	    gbc.gridy = 4; // linha
	    gbc.gridx = 0; // coluna
	    jpLocacao.add(lbDataDevolucao , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 1; // coluna
	    jpLocacao.add(txtDataDevolucao , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 2; // coluna
	    jpLocacao.add(lbAgenciaDevolucao , gbc);
	    
	    gbc.gridy = 4; // linha
	    gbc.gridx = 3; // coluna
	    jpLocacao.add(txtAgenciaDevolucao , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 0; // coluna
	    jpLocacao.add(lbTipoTarifa , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 1; // coluna
	    jpLocacao.add(txtTipoTarifa , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 2; // coluna
	    jpLocacao.add(lbQtdDias , gbc);
	    
	    gbc.gridy = 5; // linha
	    gbc.gridx = 3; // coluna
	    jpLocacao.add(txtQtdDias , gbc);
	    
	    gbc.gridy = 6; // linha
	    gbc.gridx = 2; // coluna
	    jpLocacao.add(lbTotal , gbc);
	    
	    gbc.gridy = 6; // linha
	    gbc.gridx = 3; // coluna
	    jpLocacao.add(txtTotal , gbc);
	    
	    
	}


	private void montaPanelDadosVeiculo() {
		jpVeiculo = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		jpVeiculo.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.insets = new Insets(4, 0, 20, 0);
		gbc.anchor = GridBagConstraints.WEST;
		
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; // uma célula na linha
	    jpVeiculo.add(lbDadosVeiculo , gbc);
		
	    gbc.insets = new Insets(4, 0, 4, 0);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    jpVeiculo.add(lbGrupo , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    jpVeiculo.add(txtGrupo , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    jpVeiculo.add(lbAcessorio , gbc);
		
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    jpVeiculo.add(txtAcessorio , gbc);
		
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    jpVeiculo.add(lbVeiculo , gbc);
		
	    gbc.gridy = 3; // linha
	    gbc.gridx = 1; // coluna
	    jpVeiculo.add(txtVeiculo , gbc);
	    
	}


	public void initComponents() {
//		INICIALIZAÇÃO DOS JLABELS
		lbAcessorio = new Rotulo(RotuloNomes.getACESSORIO());
		lbCnpjCpf = new Rotulo(RotuloNomes.getCNPJ_CPF());
		lbDadosLocacao = new Rotulo(RotuloNomes.getDADOS_LOCACAO());
		lbDadosVeiculo = new Rotulo(RotuloNomes.getDADOS_VEICULO());
		lbDataDevolucao = new Rotulo(RotuloNomes.getDATA_DEVOLUCAO());
		lbDataRetirada = new Rotulo(RotuloNomes.getDATA_RETIRADA());
		lbGrupo = new Rotulo(RotuloNomes.getGRUPO());
		lbNomeCliente = new Rotulo(RotuloNomes.getNOME_CLIENTE());
		lbNumeroLocacao = new Rotulo(RotuloNomes.getNUMERO());
		lbQtdDias = new Rotulo(RotuloNomes.getQTD_DIAS());
		lbTipoTarifa = new Rotulo(RotuloNomes.getTIPO_TARIFA());
		lbTotal = new Rotulo(RotuloNomes.getTOTAL());
		lbVeiculo = new Rotulo(RotuloNomes.getVEICULO());
		lbAgenciaRetirada = new Rotulo(RotuloNomes.getAGENCIA_RETIRADA());
		lbAgenciaDevolucao = new Rotulo(RotuloNomes.getAGENCIA_DEVOLUCAO());
		
//		INICIALIZAÇÃO DOS TEXT FIELDS
		txtAcessorio = new CampoTexto(15, 7);
		
		
		txtCliente = new CampoTexto(50, 20);
		txtCnpjCpf = new CampoTexto(19 , 10);
		txtDataDevolucao = new CampoTexto(20 , 10);
		txtDataRetirada = new CampoTexto(20 , 10);
		txtGrupo =  new CampoTexto(30 , 15);
		txtNumero = new CampoTexto(10 , 4);
		txtQtdDias = new CampoTexto(5, 5);
		txtTipoTarifa = new CampoTexto(15, 7);
		txtTotal = new CampoTexto(15, 7);
		txtVeiculo = new CampoTexto(20 , 15);
		txtAgenciaDevolucao = new CampoTexto(40, 15);
		txtAgenciaRetirada = new CampoTexto(40, 15);
		
//		INICIALIZAÇÃO DOS JBUTTONS
		btImprimirComprovante = new BotaoImprimirComprovante();
		
	}
	
	public void desabilitarCampos(){
		txtCliente.setEditable(false);
		txtCnpjCpf.setEditable(false);
		txtDataDevolucao.setEditable(false);
		txtDataRetirada.setEditable(false);
		txtGrupo.setEditable(false);
		txtNumero.setEditable(false);
		txtQtdDias.setEditable(false);
		txtTipoTarifa.setEditable(false);
		txtTotal.setEditable(false);
		txtVeiculo.setEditable(false);
		txtAcessorio.setEditable(false);
		txtAgenciaDevolucao.setEditable(false);
		txtAgenciaRetirada.setEditable(false);
	}
	
	public void habilitarCampos(){
		txtCliente.setEditable(true);
		txtCnpjCpf.setEditable(true);
		txtDataDevolucao.setEditable(true);
		txtDataRetirada.setEditable(true);
		txtGrupo.setEditable(true);
		txtNumero.setEditable(true);
		txtQtdDias.setEditable(true);
		txtTipoTarifa.setEditable(true);
		txtTotal.setEditable(true);
		txtVeiculo.setEditable(true);
		txtAcessorio.setEditable(true);
		txtAgenciaDevolucao.setEditable(true);
		txtAgenciaRetirada.setEditable(true);
	}


	public void addBtImprimirComprovanteListener(ActionListener a){
		btImprimirComprovante.addActionListener(a);
	}
	

	public int getTxtNumero() {
		return Integer.valueOf(txtNumero.getText()).intValue();
	}
	
	public void setTxtNumero(int numero) {
		this.txtNumero.setText(String.valueOf(numero));
	}
	
	public String getTxtCliente() {
		return txtCliente.getText();
	}
	
	public void setTxtCliente(String nomeCliente) {
		this.txtCliente.setText(nomeCliente);
	}
	
	public String getTxtCnpjCpf() {
		return txtCnpjCpf.getText();
	}
	
	public void setTxtCnpjCpf(String cnpj) {
		this.txtCnpjCpf.setText(cnpj);
	}
	
	public Date getTxtDataRetirada() {
		return DataFormatada.parseDataCompleta(txtDataRetirada.getText());
	}
	
	public void setTxtDataRetirada(Date date) {
		this.txtDataRetirada.setText(DataFormatada.parseStringDataCompleta((date)));
	}
	
	public Date getTxtDataDevolucao() {
		return DataFormatada.parseDataCompleta(txtDataDevolucao.getText());
	}
	
	public void setTxtDataDevolucao(Date date) {
		this.txtDataDevolucao.setText(DataFormatada.parseStringDataCompleta((date)));
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
	
	public int getTxtQtdDias() {
		return Integer.valueOf(txtQtdDias.getText()).intValue();
	}
	
	public void setTxtQtdDias(int qtdDias) {
		this.txtQtdDias.setText(String.valueOf(qtdDias));
	}
	
	public double getTxtTotal() {
		return Double.valueOf(txtTotal.getText()).doubleValue();
	}
	
	public void setTxtTotal(double total) {
		this.txtTotal.setText("R$ " + Conversao.formatDouble(total));
	}
	
	public String getTxtGrupo() {
		return txtGrupo.getText();
	}
	
	public void setTxtGrupo(String grupo) {
		this.txtGrupo.setText(grupo);
	}
	
	public String getTxtAcessorio() {
		return txtAcessorio.getText();
	}
	
	public void setTxtAcessorio(double acessorios) {
		this.txtAcessorio.setText("R$ " + Conversao.formatDouble(acessorios));
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
		
}
