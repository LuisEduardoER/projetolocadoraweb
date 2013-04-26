//Classe BotaoDevolverVeiculos
package View.Botoes;

import Util.Idioma;

public class BotaoDevolverVeiculos extends Botao{
	
	public BotaoDevolverVeiculos() {
		super(Idioma.bn.getString("botaoDevolverVeiculos.rotulo"), 
				  Idioma.bn.getString("botaoDevolverVeiculos.rotulo"),
				  "images/png-48/shopping_cart_accept_48x48x32.png",
				  true
				 );
	}
	
}
