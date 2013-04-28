//Classe SerasaImpl
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SerasaImpl implements Serasa{
	
	private Scanner input;
	private Cliente cliente;
	private String cpf;
	 	
	 
	public SerasaImpl(){
		openFile();
	}
	 
	// enable user to open file 
	private void openFile() 
	{
		try
		{
			input = new Scanner( new File( "serasa.txt" ) ); 
	    } // end try 
	    catch ( FileNotFoundException fileNotFoundException ) 
	    {
	    	System.err.println( "Error opening file." ); 
	        System.exit( 1 ); 
	    } // end catch
	} // end method openFile
	
	private boolean readRecords()
	{
		try // read records from file using Scanner object 
	    {
			while ( input.hasNext() )
	        {
				cpf = input.next();
	        	if(cliente.getRegistro().equals(cpf)){
	        		closeFile();
	        		return true;
	        	}
	         } // end while 
	     } // end try 
	     catch ( NoSuchElementException elementException ) 
	     {
	    	 System.err.println( "File improperly formed." ); 
	         input.close(); 
	         System.exit( 1 );
	         return false;
	     } // end catch 
	     catch ( IllegalStateException stateException ) 
	     {
	         System.err.println( "Error reading from file." ); 
	         System.exit( 1 ); 
	     } // end catch
	     closeFile();
	     return false;
	} // end method readRecords
	   
	// close file and terminate application 
	private void closeFile() 
	{
		if ( input != null )
			input.close(); // close file 
	} // end method closeFile
	   
	   
//	Método para validar o Cliente no Serasa
	public boolean validar(Cliente cliente){
		boolean isSerasa = false; //false - Cliente não consta o CPF ou CNPJ no Serasa
		this.cliente = cliente;
		if(readRecords() == true){
			isSerasa = true; //true - Cliente consta o CPF ou CNPJ no Serasa
		}		
		return isSerasa;
	}
	
}
