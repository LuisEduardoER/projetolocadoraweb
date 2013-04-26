//Classe BotaoAvancar
package View.Botoes;

import Util.Idioma;

public class BotaoAvancar extends Botao{
	
	public BotaoAvancar(){
		super(Idioma.bn.getString("botaoAvancar.rotulo"),
				"images/png-16/next_16x16x32.png",
				false
			 );
	}
	
}
