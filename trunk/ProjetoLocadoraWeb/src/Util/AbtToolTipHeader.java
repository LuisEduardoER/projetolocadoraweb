//Classe AbtToolTipHeader
package Util;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/** 
* Adapta a tableHeader de uma Jtable para controlar varios tooltips. 
* http://www.guj.com.br/java/12753-tooltiptext-na-titulo-da-coluna-de-um-jtable
* @author  Bruno 
*/  
public class AbtToolTipHeader extends JTableHeader {  
      
    private HashMap tooltips = new HashMap();
      
    public AbtToolTipHeader(TableColumnModel model) {  
        super(model);  
    } 
    
    public String getToolTipText(MouseEvent evt) {  
        int column = columnAtPoint(evt.getPoint());  
        String tooltip = (String)tooltips.get(new Integer(column));  
        return tooltip;  
    }
    
    public void addToolTipToColumn(int column, String tooltip){  
        tooltips.put(new Integer(column), tooltip);  
    }  
} 