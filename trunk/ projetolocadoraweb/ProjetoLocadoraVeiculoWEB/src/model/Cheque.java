//Classe Cheque
package model;

public class Cheque extends FormaPagamento{
	
	private String nomeBanco;
	private String numAgencia;
	private String numCCO;
	private String nomeTitular;
	private String cpfTitular;
	private String foneTitular;
	
	
	
	public String getNomeBanco() {
		return nomeBanco;
	}
	
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	
	public String getNumAgencia() {
		return numAgencia;
	}
	
	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}
	
	public String getNumCCO() {
		return numCCO;
	}
	
	public void setNumCCO(String numCCO) {
		this.numCCO = numCCO;
	}
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	
	public String getCpfTitular() {
		return cpfTitular;
	}
	
	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}
	
	public String getFoneTitular() {
		return foneTitular;
	}
	
	public void setFoneTitular(String foneTitular) {
		this.foneTitular = foneTitular;
	}
	
	public String toString(){
		return "Cheque";
	}
	
}
