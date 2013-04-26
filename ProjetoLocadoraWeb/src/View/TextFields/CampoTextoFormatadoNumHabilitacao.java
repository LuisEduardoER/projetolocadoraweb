//Classe CampoTextoFormatadoNumHabilitacao
package View.TextFields;

import Util.Idioma;

public class CampoTextoFormatadoNumHabilitacao extends CampoTextoFormatado{
	
	public CampoTextoFormatadoNumHabilitacao(){
		super(FORMATO_NUM_HABILITACAO , 7 , Idioma.bn.getString("campo.numHabilitacaoToolTip"));
	}
	
}
