//Classe BotaoExcluir
package View.Botoes;

import Util.Idioma;

public class BotaoExcluir extends Botao{
	
	public BotaoExcluir() {
		super(Idioma.bn.getString("botaoExcluir.rotulo"), 
				  "images/png-16/delete_user_16x16x32.png",
				  false
				 );
	}
	
}
