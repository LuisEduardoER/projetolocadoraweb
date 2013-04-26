//Classe BotaoFechar
package View.Botoes;

import Util.Idioma;

public class BotaoFechar extends Botao{
	
	public BotaoFechar() {
		super(Idioma.bn.getString("botaoFechar.rotulo"),
				"images/png-24/Delete.png",
				false
				 );
	}
	
}
