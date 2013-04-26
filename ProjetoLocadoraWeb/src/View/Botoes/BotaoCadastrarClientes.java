//Classe BotaoCadastrarClientes
package View.Botoes;

import Util.Idioma;

public class BotaoCadastrarClientes extends Botao{
	
	public BotaoCadastrarClientes() {
		super(Idioma.bn.getString("botaoCadastrarClientes.rotulo"), 
				  Idioma.bn.getString("botaoCadastrarClientes.rotulo"),
				  "images/png-48/add_user_48x48x32.png",
				  true
				 );
	}
	
}
