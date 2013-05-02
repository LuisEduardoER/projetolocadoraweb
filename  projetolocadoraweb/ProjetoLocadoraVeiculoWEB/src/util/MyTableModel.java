//Classe MyTableModel
package util;

import javax.swing.table.DefaultTableModel;

/*
 * Classe respons�vel por n�o deixar as C�lulas edit�veis
 */

public class MyTableModel extends DefaultTableModel {
		
	public MyTableModel(Object []data , int rowCount)
	{
		super(data , rowCount);
	}
	
	//M�todo sobreposto da Classe DefaultTableModel
	public boolean isCellEditable(int row, int col) {  
		if (col == 0 || col ==1 || col == 2 || col == 3 || col == 4) { // Quais colunas eu n�o quero deixar editar  
			return false;  
	    } else {  
	    	return true;  
	    }
	}
}

