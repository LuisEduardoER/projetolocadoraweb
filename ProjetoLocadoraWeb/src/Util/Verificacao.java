//Classe Verificacao
package Util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Verificacao {
	
		
	//M�todo ir� retornar uma quantidade de anos a partir da data que for passado via par�metro e a data atual
	public static int getTotalAnos(Date data) {  
	
	      Calendar dtaCalendar = new GregorianCalendar();  
	      dtaCalendar.setTime(data);  
	      Calendar dtHoje = Calendar.getInstance();  
	      int total = dtHoje.get(Calendar.YEAR) - dtaCalendar.get(Calendar.YEAR);  
	      dtaCalendar.add(Calendar.YEAR, total);  
	      if (dtHoje.before(dtaCalendar)) {  
	         total--;  
	      }  
	      return total;  
	}
	
//	M�todo ir� retornar um boolean dizendo que a "data" informada esta � frente da data atual 
	public static boolean isCorrectDate(Date data){
		
		Date dataAtual = new Date();
		
		if(data.before(dataAtual)){
			return false; //data incorreta
		}else{
			return true; //data correta
		}
	}
		
	
	public static int getDiferencaDias(Date data1, Date data2){  
        GregorianCalendar ini = new GregorianCalendar();  
        GregorianCalendar fim = new GregorianCalendar();
        ini.setTime(data1);  
        fim.setTime(data2);  
        long dt1 = ini.getTimeInMillis();
        long dt2 = fim.getTimeInMillis();  
        return (int) (((dt2 - dt1) / 86400000));
    }
	
}
