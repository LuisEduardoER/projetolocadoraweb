//Classe VeiculoConsultaView
package View;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Util.Idioma;
import View.Botoes.BotaoDetalhes;
import View.Botoes.BotaoEscolherVeiculo;
import View.Botoes.BotaoVoltar;
import View.Panels.PainelAcessorio;


public class VeiculoConsultaView extends VeiculoDadosView{
	
	private BotaoEscolherVeiculo btEscolher;
	
	
	public VeiculoConsultaView(){
		montaGUI();
	}
	
	@Override
	public void montaGUI() {
		initComponents();
		montaPanelPrincipal();
		add(panelPrincipal);
		montaJFrame(Idioma.bn.getString("veiculoConsultaView.title"));
	}

	private void montaPanelPrincipal() {
		panelPrincipal = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		//RODAR MAQ. NORMAL
// 		panelPrincipal.setBorder(new EmptyBorder(30, 150, 30, 150));
		//RODAR NA MAQ. SÃO JUDAS
		panelPrincipal.setBorder(new EmptyBorder(0 , 30 , 0 , 30));
		
		gbc.insets = new Insets(0, 0, 20, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridy = 0; // linha
	    gbc.gridx = 1; // coluna
	    gbc.gridwidth = 2; 
	    panelPrincipal.add(panelAcessorio , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 3;
	    panelPrincipal.add(jscResultado , gbc);
	    
	    JPanel panelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
	    panelBotao.add(btVoltar);
	    panelBotao.add(btEscolher);
	    panelBotao.add(btDetalhes);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    gbc.gridwidth = 2; 
	    panelPrincipal.add(panelBotao , gbc);
	    
	}

	@Override
	public void initComponents() {
		panelAcessorio = new PainelAcessorio();
		btEscolher = new BotaoEscolherVeiculo();
		btVoltar = new BotaoVoltar();
		btDetalhes = new BotaoDetalhes();
		montaJTable();
		
	}
	
	
	public void addBtEscolherListener(ActionListener a){
		btEscolher.addActionListener(a);
	}
		
}
