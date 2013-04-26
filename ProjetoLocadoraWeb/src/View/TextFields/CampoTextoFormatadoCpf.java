//Classe CampoTextoFormatadoCpf
package View.TextFields;

import Util.Idioma;

public class CampoTextoFormatadoCpf extends CampoTextoFormatado{
	
	public CampoTextoFormatadoCpf(){
//		super("___.___.___-__" , 8 , 14 , "Formato: xxx.xxx.xxx-xx");
		super(FORMATO_CPF , 8 , Idioma.bn.getString("campo.cnpjToolTip"));
	}
	
}
