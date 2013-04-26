//Classe CampoTextoFormatado
package View.TextFields;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;


public class CampoTextoFormatado extends JFormattedTextField{
	
	//TIPOS DE FORMATOS//
	protected final static String FORMATO_TELEFONE = "##########*";
	protected final static String FORMATO_DATA = "##/##/####";
	protected final static String FORMATO_CPF = "###.###.###-##";
	protected final static String FORMATO_CNPJ = "##.###.###/####-##";
	protected final static String FORMATO_ESTADO_EMISSOR = "UU";
	protected final static String FORMATO_NUM_HABILITACAO = "###########";
	
	
	//Construtor com os parâmetros formatter , tamanho e toolTip
	//@formatter - String com o formato. ex: "##/##/####" ou "0xHHH"
	//@tamanho - Modifica o tamanho do JFormattedTexField
	//@toolTip - Acrescenta um "TollTip" no JFormattedTextField
	public CampoTextoFormatado(String formatter , int tamanho , String toolTip){
		super(createFormatter(formatter , ""));
		setColumns(tamanho);
		setToolTipText(toolTip);
	}
	
	//Construtor com os parâmetros formatter , validCharacters , tamanho e toolTip
	//@formatter - String com o formato. ex: "##/##/####" ou "0xHHH"
	//@validCharacters - String com os valores válidos ou permitidos no JFormattedTextField
	//@tamanho - Modifica o tamanho do JFormattedTexField
	//@toolTip - Acrescenta um "TollTip" no JFormattedTextField
	public CampoTextoFormatado(String formatter , String validCharacters, int tamanho , String toolTip){
		super(createFormatter(formatter , validCharacters));
		setColumns(tamanho);
		setToolTipText(toolTip);
	}
	
	//Método que retornará/criará um Objeto MaskFormatter formatado
	private static MaskFormatter createFormatter(String format , String validCharacters){
		MaskFormatter formatter = null;
		try {
	        formatter = new MaskFormatter(format);
	        if(validCharacters.equals("") != true){
	        	formatter.setValidCharacters(validCharacters);
	        }
	    } catch (java.text.ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	        System.exit(-1);
	    }	
		return formatter;
	}
	
}
