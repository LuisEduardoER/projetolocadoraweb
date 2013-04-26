//Classe BotaoLogin
package View.Botoes;

import Util.Idioma;

public class BotaoLogin extends Botao{
	
	public BotaoLogin() {
		super(Idioma.bn.getString("botaoLogin.rotulo"), 
				  Idioma.bn.getString("botaoLogin.toolTip")
				 );
	}
	
}
