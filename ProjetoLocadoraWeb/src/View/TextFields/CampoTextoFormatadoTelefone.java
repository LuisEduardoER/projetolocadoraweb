//Classe CampoTextoFormatadoTelefone
package View.TextFields;

import Util.Idioma;

public class CampoTextoFormatadoTelefone extends CampoTextoFormatado{
	
	public CampoTextoFormatadoTelefone(){
		super( FORMATO_TELEFONE , 7, Idioma.bn.getString("campo.foneToolTip"));
	}
	
}
