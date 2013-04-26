//Classe BotaoSalvar
package View.Botoes;

import Util.Idioma;

public class BotaoSalvar extends Botao{

	public BotaoSalvar(){
		super(Idioma.bn.getString("botaoSalvar.rotulo"),
				"images/png-16/save_16x16x32.png",
				false
				 );
	}
}
