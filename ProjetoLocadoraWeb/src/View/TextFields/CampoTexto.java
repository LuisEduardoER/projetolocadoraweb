//Classe CampoTexto
package View.TextFields;

import javax.swing.JTextField;

import Util.FixedLengthDocument;

public class CampoTexto extends JTextField{
	
	//Construtor sem parâmetros
	public CampoTexto(){
		
	}
	
	//Construtor com o parâmetro maxCaracter
	//@maxCaracter - Modifica o total de caracteres permitido no JTextField
	public CampoTexto(int maxCaracter){
		setMaxCaracter(maxCaracter);
	}
	
	//Construtor com os parâmetros maxCaracter e tamanho
	//@maxCaracter - Modifica o total de caracteres permitido no JTextField
	//@tamanho - Modifica o tamanho do JTexField
	public CampoTexto(int maxCaracter , int tamanho ){
		setColumns(tamanho);
		setMaxCaracter(maxCaracter);		
	}
	
	
	//Construtor com os parâmetros tamanho , maxCaracter e toolTip
	//@texto - Modifica o texto dentro do JTextField
	//@tamanho - Modifica o tamanho do JTexField
	//@maxCaracter - Modifica o total de caracteres permitido no JTextField
	public CampoTexto(int tamanho , int maxCaracter , String toolTip){
		setColumns(tamanho);
		setToolTipText(toolTip);
		setMaxCaracter(maxCaracter);
	}
	
	//Construtor com os parâmetros texto , tamanho , maxCaracter e toolTip
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
	
	//Método responsável por modificar o total de caracteres permitido do JTextField
	public void setMaxCaracter(int maxCaracter){
		setDocument(new FixedLengthDocument(maxCaracter));
	}
	
}
