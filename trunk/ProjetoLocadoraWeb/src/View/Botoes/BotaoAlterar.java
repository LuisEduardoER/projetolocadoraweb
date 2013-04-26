//Classe BotaoAlterar
package View.Botoes;

import Util.Idioma;

public class BotaoAlterar extends Botao{
	
	public BotaoAlterar(){
		super(Idioma.bn.getString("botaoAlterar.rotulo"),
			  "images/png-16/edit_profile_16x16x32.png",
			  false
			 );
	}
	
}
