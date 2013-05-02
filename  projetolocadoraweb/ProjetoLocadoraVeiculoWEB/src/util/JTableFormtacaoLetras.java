//Classe JTableFormtacaoLetras
package util;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Classe respons�vel por formatar c�lulas de um JTable
*/

public class JTableFormtacaoLetras extends DefaultTableCellRenderer{
	
	public JTableFormtacaoLetras(){
		super();
	}
	
	//M�todo que ir� modificar as c�lulas de um JTable
	public void setValue(Object value) {
		setBackground(new Color(238, 238, 238));
	    setForeground(Color.BLACK);
	    setHorizontalAlignment(JLabel.CENTER);
	    setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
	    //outras altera��es entram aqui...
	    super.setValue(value);
	}
}
