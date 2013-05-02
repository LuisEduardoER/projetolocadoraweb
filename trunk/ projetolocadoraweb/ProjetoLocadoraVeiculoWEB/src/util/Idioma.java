//Classe Idioma
package util;

import java.util.Locale;
import java.util.ResourceBundle;


public class Idioma {
	public static ResourceBundle bn = ResourceBundle.getBundle("locadora");
//	public static ResourceBundle bn = ResourceBundle.getBundle("locadora", Locale.US);
//	public static ResourceBundle bn = ResourceBundle.getBundle("locadora", new Locale("pt", "BR"));
//	public static ResourceBundle bn = ResourceBundle.getBundle("locadora", new Locale("es","ES"));
	
	//M�todo ir� selecionar o Idioma escolhido pelo cliente.
	/*
	 * 1 - Portugu�s
	 * 2 - Ingl�s
	 * 3 - Espanhol
	 * 0 ou qualquer outro n�mero - de acordo com o SI
	*/
	public static void selecionaIdioma(int op){
		
		switch(op)
 		{
 			case 1: bn = ResourceBundle.getBundle("locadora", new Locale("pt", "BR"));
 				break;
 			case 2: bn = ResourceBundle.getBundle("locadora", Locale.US);
     	  		break;
 			case 3: bn = ResourceBundle.getBundle("locadora", new Locale("es","ES"));
 				break;
 			default: bn = ResourceBundle.getBundle("locadora");
 			break;
 		}
	}
	
}
