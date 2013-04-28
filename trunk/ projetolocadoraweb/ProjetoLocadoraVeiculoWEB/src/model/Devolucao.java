//Classe Devolucao
package model;

import java.util.Date;

public class Devolucao {
	
	private int id;
	private Date dtaDevolucao;
	private Agencia agenciaDevolucao;
	private double total;
	private int qtdDias;
	private int kmFinalControlado;
	private Locacao locacao;
	private FormaPagamento formaPagamento;
	
	public Devolucao(){
		
	}
	
	public Devolucao(int id){
		setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDtaDevolucao() {
		return dtaDevolucao;
	}

	public void setDtaDevolucao(Date dtaDevolucao) {
		this.dtaDevolucao = dtaDevolucao;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Agencia getAgenciaDevolucao() {
		return agenciaDevolucao;
	}

	public void setAgenciaDevolucao(Agencia agenciaDevolucao) {
		this.agenciaDevolucao = agenciaDevolucao;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}

	public int getKmFinalControlado() {
		return kmFinalControlado;
	}

	public void setKmFinalControlado(int kmFinalControlado) {
		this.kmFinalControlado = kmFinalControlado;
	}
	

}
