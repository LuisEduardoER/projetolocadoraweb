//Classe LocacaoEscolheDataView
package View;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.Idioma;
import View.Botoes.BotaoAvancar;
import View.Botoes.BotaoCancelar;
import View.Frames.JFrameDefault;
import View.Panels.PainelDataHora;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;

public class LocacaoEscolheDataView extends JFrameDefault{

	private Rotulo lbTipoTarifa;
	
	private PainelDataHora panelRetirada;
	private PainelDataHora panelDevolucao;
	private JComboBox comboTarifa;
	
	private final String[] tarifa = { Idioma.bn.getString("locacaoEscolheDataView.kmLivre") ,
									  Idioma.bn.getString("locacaoEscolheDataView.kmControlado")};
	
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JPanel panelInferior;
	
	private BotaoCancelar btCancelar;
	private BotaoAvancar btAvancar;
	
		
	public LocacaoEscolheDataView(){
		montaGUI();
	}
	
	
	@Override
	public void montaGUI() {
		initComponents();
		montaPanelPrincipal();
		
		add(panelPrincipal);
		
		montaJFrame(Idioma.bn.getString("locacaoEscolheDataView.title"));
		
	}

	private void montaPanelPrincipal() {
		montaPanelSuperior();
		montaPanelInferior();
		
		panelPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelPrincipal.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.anchor = GridBagConstraints.CENTER;
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
		
		panelSuperior.setBorder(new EmptyBorder(20 , 30 , 20 , 30));
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 10, 30);
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 2; // duas célula na linha
	    panelSuperior.add(panelRetirada , gbc);
	    
	    gbc.gridy = 0; // linha
	    gbc.gridx = 2; // coluna
	    panelSuperior.add(panelDevolucao , gbc);
	    
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.insets = new Insets(0, 0, 0, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 2; // coluna
	    gbc.gridwidth = 1; // uma célula na linha
	    panelSuperior.add(lbTipoTarifa , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 3; // coluna
	    panelSuperior.add(comboTarifa , gbc);
		
	}


	private void montaPanelInferior() {
		panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		panelInferior.setBorder(new EmptyBorder(20, 30, 20, 30));
		panelInferior.add(btCancelar);
		panelInferior.add(btAvancar);
	}

	@Override
	public void initComponents() {
		lbTipoTarifa = new Rotulo(RotuloNomes.getTIPO_TARIFA());
		panelRetirada = new PainelDataHora(Idioma.bn.getString("locacaoEscolheDataView.retirada"));
		panelDevolucao = new PainelDataHora(Idioma.bn.getString("locacaoEscolheDataView.devolucao"));
		btAvancar = new BotaoAvancar();
		btCancelar = new BotaoCancelar();
		
		initComboBoxes();
	}


	private void initComboBoxes() {
		comboTarifa = new JComboBox(tarifa);
		comboTarifa.setSelectedIndex(0);
	}
	
	public String getTipoTarifa(){
		if(comboTarifa.getSelectedIndex() == 0){
			return "livre";
		}
		else{
			return "controlado";
		}
	}
	
	public void addBtCancelarListener(ActionListener a){
		btCancelar.addActionListener(a);
	}
	
	public void addBtAvancarListener(ActionListener a){
		btAvancar.addActionListener(a);
	}


	public PainelDataHora getPanelRetirada() {
		return panelRetirada;
	}


	public PainelDataHora getPanelDevolucao() {
		return panelDevolucao;
	}


	public boolean camposBranco() {
		if(panelDevolucao.getData() == null || panelRetirada.getData() == null){
			return true; //tem campos em branco
		}
		return false;
	}
}
