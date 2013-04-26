//Classe BotaoDetalhes
package View.Botoes;

import javax.swing.ImageIcon;

import Util.Idioma;

public class BotaoDetalhes extends Botao{
	
	public BotaoDetalhes() {
		super(	Idioma.bn.getString("botaoDetalhes.toolTip"),
				Idioma.bn.getString("botaoDetalhes.rotulo")				  
				 );
		ImageIcon icon = new ImageIcon("images/png-16/add_page_16x16x32.png");
		setIcon(icon);
	}
	
}
