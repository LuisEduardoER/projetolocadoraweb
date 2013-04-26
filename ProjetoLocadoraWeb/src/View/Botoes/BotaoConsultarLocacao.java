//Classe BotaoConsultarLocacao
package View.Botoes;

import Util.Idioma;

public class BotaoConsultarLocacao extends Botao{
	
	public BotaoConsultarLocacao() {
		super(Idioma.bn.getString("botaoConsultarLocacao.rotulo"), 
				  Idioma.bn.getString("botaoConsultarLocacao.rotulo"),
				  "images/png-48/search_page_48x48x32.png",
				  true
				 );
	}
	
}
