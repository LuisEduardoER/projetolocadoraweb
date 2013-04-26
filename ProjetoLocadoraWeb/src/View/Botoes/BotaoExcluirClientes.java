//Classe BotaoExcluirClientes
package View.Botoes;

import Util.Idioma;

public class BotaoExcluirClientes extends Botao{
	
	public BotaoExcluirClientes() {
		super(Idioma.bn.getString("botaoExcluirClientes.rotulo"), 
				  Idioma.bn.getString("botaoExcluirClientes.rotulo"),
				  "images/png-48/delete_user_48x48x32.png",
				  true
				 );
	}
	
}
