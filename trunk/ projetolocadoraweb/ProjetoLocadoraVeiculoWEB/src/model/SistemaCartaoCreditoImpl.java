//Classe SistemaCartaoCreditoImpl
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class SistemaCartaoCreditoImpl implements SistemaCartaoCredito{
	
	private Cartao cartao;
	private Scanner input;
	
	public SistemaCartaoCreditoImpl(){
		openFile();
	}
	
		 
	// enable user to open file 
	private void openFile() 
	{
		try
		{
			input = new Scanner( new File( "cartaoCredito.txt" ) ); 
	    } // end try 
	    catch ( FileNotFoundException fileNotFoundException ) 
	    {
	    	System.err.println( "Error opening file." ); 
	        System.exit( 1 ); 
	    } // end catch
	} // end method openFile
	
	
	public boolean validar()
	{
		try // read records from file using Scanner object 
	    {
			while ( input.hasNext() )
	        {
				String valor = input.nextLine();
				if(cartao.getCartaoStr().equals(valor)){
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
		
	
	
	@Override
	public boolean debitar(Cartao cartao) {
		this.cartao = cartao;
		if(validar() == true){ //não foi possível efetuar o pagamento
			return true;
		}
		else{
			return false;
		}		
	}
}
