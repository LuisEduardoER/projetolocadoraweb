//Classe VeiculoEscolhaView
package View;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Util.Idioma;
import View.Botoes.BotaoDetalhes;
import View.Botoes.BotaoLocar;
import View.Botoes.BotaoVoltar;
import View.Panels.PainelAcessorio;
import View.Rotulos.Rotulo;


public class VeiculoEscolhaView extends VeiculoDadosView{
	
	private Rotulo lbGrupo;
	private JComboBox comboGrupo;
	
	private BotaoLocar btLocar;
	
		
	public VeiculoEscolhaView(){
		montaGUI();
	}
	
	@Override
	public void montaGUI() {
		initComponents();
		montaPanelPrincipal();
		add(panelPrincipal);
		montaJFrame(Idioma.bn.getString("veiculoEscolhaView.title"));
	}

	private void montaPanelPrincipal() {
		panelPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		//RODAR MAQ. NORMAL
// 		panelPrincipal.setBorder(new EmptyBorder(30, 150, 30, 150));
		//RODAR NA MAQ. SÃO JUDAS
		panelPrincipal.setBorder(new EmptyBorder(0 , 30 , 0 , 30));
		
		gbc.insets = new Insets(6, 0, 0, 0);
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; 
	    panelPrincipal.add(lbGrupo , gbc);
	    
//	    gbc.anchor = GridBagConstraints.NORTH;
	    gbc.insets = new Insets(0, 0, 0, 0);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(comboGrupo , gbc);
	    
	    gbc.insets = new Insets(0, 0, 20, 0);
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.gridy = 0; // linha
	    gbc.gridx = 2; // coluna
	    gbc.gridheight = 3;
	    panelPrincipal.add(panelAcessorio , gbc);
	    
	    gbc.gridheight = 1;
	    gbc.gridy = 3; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 3; 
	    panelPrincipal.add(jscResultado , gbc);
	    
	    JPanel panelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
	    panelBotao.add(btVoltar);
	    panelBotao.add(btLocar);
	    panelBotao.add(btDetalhes);
	    
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.gridy = 4; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 4; 
	    panelPrincipal.add(panelBotao , gbc);
		
		
	}

	@Override
	public void initComponents() {
		lbGrupo = new Rotulo(Idioma.bn.getString("veiculoEscolhaView.selecione"));
		comboGrupo = new JComboBox();
		btLocar = new BotaoLocar();
		btVoltar = new BotaoVoltar();
		btDetalhes = new BotaoDetalhes();
		panelAcessorio = new PainelAcessorio();
		
		montaJTable();
	}

	
	
	public void addBtLocarListener(ActionListener a){
		btLocar.addActionListener(a);
	}
	
	public void preencheComboGrupo(ArrayList objects){
		for(int i = 0; i < objects.size() ; i++){
			comboGrupo.addItem(objects.get(i));
		}
	}
	
	public Object getComboBoxGrupo(){
		
		return comboGrupo.getSelectedItem();
	}
	
	public void addComboListener(ItemListener a){
		comboGrupo.addItemListener(a);
	}
	
}
