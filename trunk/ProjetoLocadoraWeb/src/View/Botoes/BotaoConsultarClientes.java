//Classe BotaoConsultarClientes
package View.Botoes;

import Util.Idioma;

public class BotaoConsultarClientes extends Botao{
	
	public BotaoConsultarClientes() {
		super(Idioma.bn.getString("botaoConsultarClientes.rotulo"), 
				  Idioma.bn.getString("botaoConsultarClientes.rotulo"),
				  "images/png-48/search_user_48x48x32.png",
				  true
				 );
	}
	
}
