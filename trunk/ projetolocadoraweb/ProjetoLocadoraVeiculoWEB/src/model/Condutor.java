//Classe Condutor
package model;

public class Condutor {
	
	private int id;
	private PessoaFisica pf;
	private Veiculo veiculo;
	private double total;
	private Integer kmInicialControlado;
	private int kmFinalControlado;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public PessoaFisica getPf() {
		return pf;
	}
	
	public void setPf(PessoaFisica pf) {
		this.pf = pf;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getKmInicialControlado() {
		return kmInicialControlado;
	}
	
	public void setKmInicialControlado(int kmInicialControlado) {
		this.kmInicialControlado = kmInicialControlado;
	}

	public int getKmFinalControlado() {
		return kmFinalControlado;
	}

	public void setKmFinalControlado(int kmFinalControlado) {
		this.kmFinalControlado = kmFinalControlado;
	}
	
}
