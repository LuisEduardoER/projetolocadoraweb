//Classe DataFormatada
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import Util.Idioma;

public class DataFormatada extends Date{
	
	
	public static Date parseDataSimples(String textoData){
		Date dt = null;
//		DateFormat formatter = new SimpleDateFormat(Idioma.bn.getString("data.simples"));
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
//		dd/MM/yyyy  data simples
//		dd/MM/yyyy HH:mm:ss   data completa
		
		try {
			dt = formatter.parse(textoData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dt;
	}
	
	public static String parseStringDataSimples(Date data){
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(data);
	}
	
	public static String parseStringDataCompleta(Date data){
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatter.format(data);
	}
	
	public static Date parseDataCompleta(String textoData){
		Date dt = null;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			dt = formatter.parse(textoData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dt;
	}
	
	
}
