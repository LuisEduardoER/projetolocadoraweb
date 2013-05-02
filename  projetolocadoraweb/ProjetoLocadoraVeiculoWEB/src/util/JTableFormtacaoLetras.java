//Classe JTableFormtacaoLetras
package util;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Classe responsável por formatar células de um JTable
*/

public class JTableFormtacaoLetras extends DefaultTableCellRenderer{
	
	public JTableFormtacaoLetras(){
		super();
	}
	
	//Método que irá modificar as células de um JTable
	public void setValue(Object value) {
		setBackground(new Color(238, 238, 238));
	    setForeground(Color.BLACK);
	    setHorizontalAlignment(JLabel.CENTER);
	    setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
	    //outras alterações entram aqui...
	    super.setValue(value);
	}
}
