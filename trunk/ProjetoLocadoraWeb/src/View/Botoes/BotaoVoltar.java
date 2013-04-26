//Classe BotaoVoltar
package View.Botoes;

import Util.Idioma;

public class BotaoVoltar extends Botao{
	
	public BotaoVoltar(){
		super(Idioma.bn.getString("botaoVoltar.rotulo"), 
				"images/png-16/back_16x16x32.png",
				false
				 );
	}
	
}
