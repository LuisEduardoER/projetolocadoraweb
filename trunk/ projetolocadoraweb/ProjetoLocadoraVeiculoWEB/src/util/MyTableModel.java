//Classe MyTableModel
package util;

import javax.swing.table.DefaultTableModel;

/*
 * Classe responsável por não deixar as Células editáveis
 */

public class MyTableModel extends DefaultTableModel {
		
	public MyTableModel(Object []data , int rowCount)
	{
		super(data , rowCount);
	}
	
	//Método sobreposto da Classe DefaultTableModel
	public boolean isCellEditable(int row, int col) {  
		if (col == 0 || col ==1 || col == 2 || col == 3 || col == 4) { // Quais colunas eu não quero deixar editar  
			return false;  
	    } else {  
	    	return true;  
	    }
	}
}

