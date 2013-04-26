//Classe BotaoImprimirComprovante
package View.Botoes;

import Util.Idioma;

public class BotaoImprimirComprovante extends Botao{
	
	public BotaoImprimirComprovante() {
		super(Idioma.bn.getString("botaoImprimirComprovante.rotulo"),
				"images/png-32/Print.png",
				false
				 );
	}
	
}
