//Classe CampoTextoFormatadoEstadoEmissor
package View.TextFields;

import Util.Idioma;

public class CampoTextoFormatadoEstadoEmissor extends CampoTextoFormatado{
	
	public CampoTextoFormatadoEstadoEmissor(){
		super(FORMATO_ESTADO_EMISSOR , 2 , Idioma.bn.getString("campo.estadoEmissorToolTip"));
	}
	
}
