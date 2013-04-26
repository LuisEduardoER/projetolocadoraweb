//Classe BotaoConfirmar
package View.Botoes;

import Util.Idioma;

public class BotaoConfirmar extends Botao{

	public BotaoConfirmar(){
		super(Idioma.bn.getString("botaoConfirmar.rotulo"),
				"images/png-16/accept_16x16x32.png",
				false
				 );
	}
}
