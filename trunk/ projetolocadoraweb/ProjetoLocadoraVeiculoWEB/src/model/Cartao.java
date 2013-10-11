//Classe Cartao
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cartao extends FormaPagamento{
	
	private String tipo;
	private String nomeCliente;
	private String cpf;
	private String numCartao;
	private Date dtaValidade;
	private String codSeguranca;
	
	
	
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
	
	public String getCodSeguranca() {
		return codSeguranca;
	}
	
	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}
	
	public String toString(){
		return "Cartao";
	}
	
		
	public String getCartaoStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return getTipo() + " " + getNomeCliente() + " " + getCpf() + " " + getNumCartao() + " " + sdf.format(getDtaValidade()) + " " +
				getCodSeguranca();
	}

	@Override
	public void debitar() {
		// TODO Auto-generated method stub
		
	}
	
}
