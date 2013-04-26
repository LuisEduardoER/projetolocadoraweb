//Classe BotaoConsultar
package View.Botoes;

import Util.Idioma;

public class BotaoConsultar extends Botao{
	
	public BotaoConsultar() {
		super(Idioma.bn.getString("botaoConsultar.rotulo"),
				"images/png-16/search_page_16x16x32.png",
				false
				 );
	}
	
}
