//Classe ClienteConsultaDetPFView
package View;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.Idioma;
import View.Botoes.*;

public class ClienteConsultaDetPFView extends ClienteDadosPFView{

//	BOTÕES
	private BotaoVoltar btVoltar;
	private BotaoAlterar btAlterar;
	private BotaoExcluir btExcluir;
	private BotaoLocar btLocar;
	
		
	public ClienteConsultaDetPFView(){
		super();
		desabilitarCampos();
		addBotoes();
		montaJFrame(Idioma.bn.getString("clienteConsultaDetPFView.title"));
	}

	@Override
	public void addBotoes() {
		initBotoes();
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER , 10 , 0));
		panel.setBorder(new EmptyBorder(30, 20, 20, 20));
		panel.add(btVoltar);
		panel.add(btAlterar);
		panel.add(btExcluir);
		panel.add(btLocar);
				
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
		
		add(panel , gbc);
		
	}

	private void initBotoes() {
		btVoltar = new BotaoVoltar();
		btAlterar = new BotaoAlterar();
		btExcluir = new BotaoExcluir();
		btLocar = new BotaoLocar();
	}
	
	public void addBtVoltar(ActionListener a){
		btVoltar.addActionListener(a);
	}
	
	public void addBtAlterar(ActionListener a){
		btAlterar.addActionListener(a);
	}
	
	public void addBtExcluir(ActionListener a){
		btExcluir.addActionListener(a);
	}
	
	public void addBtLocar(ActionListener a){
		btLocar.addActionListener(a);
	}
	
}
