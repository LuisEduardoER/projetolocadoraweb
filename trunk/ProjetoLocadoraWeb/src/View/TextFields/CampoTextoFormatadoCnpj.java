//Classe CampoTextoFormatadoCnpj
package View.TextFields;

import Util.Idioma;

public class CampoTextoFormatadoCnpj extends CampoTextoFormatado{
	
	public CampoTextoFormatadoCnpj(){
//		super("__.___.___/____-__" , 10 , 18 , "Formato: xx.xxx.xxx/xxxx-xx"  );
		super(FORMATO_CNPJ , 10 , Idioma.bn.getString("campo.cnpjToolTip"));
	}
	
}
