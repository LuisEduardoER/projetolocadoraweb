//Classe CampoTexto
package View.TextFields;

import javax.swing.JTextField;

import Util.FixedLengthDocument;

public class CampoTexto extends JTextField{
	
	//Construtor sem par�metros
	public CampoTexto(){
		
	}
	
	//Construtor com o par�metro maxCaracter
	//@maxCaracter - Modifica o total de caracteres permitido no JTextField
	public CampoTexto(int maxCaracter){
		setMaxCaracter(maxCaracter);
	}
	
	//Construtor com os par�metros maxCaracter e tamanho
	//@maxCaracter - Modifica o total de caracteres permitido no JTextField
	//@tamanho - Modifica o tamanho do JTexField
	public CampoTexto(int maxCaracter , int tamanho ){
		setColumns(tamanho);
		setMaxCaracter(maxCaracter);		
	}
	
	
	//Construtor com os par�metros tamanho , maxCaracter e toolTip
	//@texto - Modifica o texto dentro do JTextField
	//@tamanho - Modifica o tamanho do JTexField
	//@maxCaracter - Modifica o total de caracteres permitido no JTextField
	public CampoTexto(int tamanho , int maxCaracter , String toolTip){
		setColumns(tamanho);
		setToolTipText(toolTip);
		setMaxCaracter(maxCaracter);
	}
	
	//Construtor com os par�metros texto , tamanho , maxCaracter e toolTip
	//@texto - Modifica o texto dentro do JTextField
	//@tamanho - Modifica o tamanho do JTexField
	//@maxCaracter - Modifica o total de caracteres permitido no JTextField
	//@toolTip - Acrescenta um "TollTip" no JTextField
	public CampoTexto(String texto , int tamanho , int maxCaracter , String toolTip ){
		setColumns(tamanho);
		setToolTipText(toolTip);
		setMaxCaracter(maxCaracter);
		setText(texto);
	}
	
	//M�todo respons�vel por modificar o total de caracteres permitido do JTextField
	public void setMaxCaracter(int maxCaracter){
		setDocument(new FixedLengthDocument(maxCaracter));
	}
	
}
