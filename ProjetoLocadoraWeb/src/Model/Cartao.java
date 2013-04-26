//Classe Cartao
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cartao extends FormaPagamento{
	
	private String tipo;
	private String nomeCliente;
	private String cpf;
	private String numCartao;
	private Date dtaValidade;
	private String codSeguran�a;
	
	
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNumCartao() {
		return numCartao;
	}
	
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	
	public Date getDtaValidade() {
		return dtaValidade;
	}
	
	public void setDtaValidade(Date dtaValidade) {
		this.dtaValidade = dtaValidade;
	}
	
	public String getCodSeguran�a() {
		return codSeguran�a;
	}
	
	public void setCodSeguran�a(String codSeguran�a) {
		this.codSeguran�a = codSeguran�a;
	}
	
	public String toString(){
		return "Cartao";
	}
	
		
	public String getCartaoStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return getTipo() + " " + getNomeCliente() + " " + getCpf() + " " + getNumCartao() + " " + sdf.format(getDtaValidade()) + " " +
				getCodSeguran�a();
	}
	
}
