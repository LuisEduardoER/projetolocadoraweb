//Classe CampoTextoFormatadoData
package View.TextFields;

import Util.Idioma;

public class CampoTextoFormatadoData extends CampoTextoFormatado{
	
	public CampoTextoFormatadoData(){
//		super("__/__/____" , 7 , 10 , "Formato: dd/mm/aaaa");
		super(FORMATO_DATA , 7 , Idioma.bn.getString("data.simples.toolTip"));
	}
	
}
