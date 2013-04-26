//Classe ClienteCadastroPJView
package View;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.Idioma;
import View.Botoes.BotaoCancelar;
import View.Botoes.BotaoSalvar;

public class ClienteCadastroPJView extends ClienteDadosPJView{
	
//	BOTÕES
	private BotaoCancelar btCancelar;
	private BotaoSalvar btSalvar;
	
	public ClienteCadastroPJView(){
		super();
		addBotoes();
		montaJFrame(Idioma.bn.getString("clienteCadastroPJView.title"));
	}
	

	@Override
	public void addBotoes() {
		btCancelar = new BotaoCancelar();
		btSalvar = new BotaoSalvar();
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER , 10 , 0));
		panel.setBorder(new EmptyBorder(30, 20, 20, 20));
		panel.add(btCancelar);
		panel.add(btSalvar);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
		
		add(panel , gbc);
	}
	
	public void addBtCancelar(ActionListener a){
		btCancelar.addActionListener(a);
	}
	
	public void addBtSalvar(ActionListener a){
		btSalvar.addActionListener(a);
	}


	
	
}
