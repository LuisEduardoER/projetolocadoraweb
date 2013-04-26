//Classe BotaoRealizarLocacao
package View.Botoes;

import Util.Idioma;

public class BotaoRealizarLocacao extends Botao{
	
	public BotaoRealizarLocacao() {
		super(Idioma.bn.getString("botaoRealizarLocacao.rotulo"), 
				  Idioma.bn.getString("botaoRealizarLocacao.rotulo"),
				  "images/png-48/insert_to_shopping_cart_48x48x32.png",
				  true
				 );
	}
	
}
