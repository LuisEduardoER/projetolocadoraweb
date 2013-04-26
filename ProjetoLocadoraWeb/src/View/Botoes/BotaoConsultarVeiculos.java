//Classe BotaoConsultarVeiculos
package View.Botoes;

import Util.Idioma;

public class BotaoConsultarVeiculos extends Botao{
	
	public BotaoConsultarVeiculos() {
		super(Idioma.bn.getString("botaoConsultarVeiculos.rotulo"), 
				  Idioma.bn.getString("botaoConsultarVeiculos.rotulo"),
				  "images/png-48/Search.png",
				  true
				 );
	}
	
}
