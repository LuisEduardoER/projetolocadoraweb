//Classe BotaoAlterarClientes
package View.Botoes;

import Util.Idioma;

public class BotaoAlterarClientes extends Botao{
	
	public BotaoAlterarClientes() {
		super(Idioma.bn.getString("botaoAlterarClientes.rotulo"), 
			  Idioma.bn.getString("botaoAlterarClientes.rotulo"),
			  "images/png-48/edit_profile_48x48x32.png" , 
			  true
			 );	
	}
	
}
