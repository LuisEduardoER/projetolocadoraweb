//Classe Grupo
package model;

import java.util.ArrayList;

public class Grupo {
	
	private int id;
	private String nome;
	private double tarifaLivre;
	private double tarifaControloda;
	private ArrayList<Veiculo> veiculos;
	
	public Grupo(){
		veiculos = new ArrayList<Veiculo>();
	}
	
	public Grupo(String nome , double tarifaLivre , double tarifaControlada){
		setNome(nome);
		setTarifaLivre(tarifaLivre);
		setTarifaControloda(tarifaControlada);
		veiculos = new ArrayList<Veiculo>();
	}
	
		
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getTarifaLivre() {
		return tarifaLivre;
	}
	
	public void setTarifaLivre(double tarifaLivre) {
		this.tarifaLivre = tarifaLivre;
	}
	
	public double getTarifaControloda() {
		return tarifaControloda;
	}
	
	public void setTarifaControloda(double tarifaControloda) {
		this.tarifaControloda = tarifaControloda;
	}
	
//	Método irá retornar o valor do dia extra quando o atendente optar por escolher a Tarifa KM Livre e se for mais de 1 semana
	public double getDiaExtra(){
		return getSemanaLivre() / 7;
	}
	
//	Método retornará o calculo da Tarifa KM Livre de uma semana
	public double getSemanaLivre(){
		return getTarifaLivre() * 6;
	}
	
//	Método irá retornar a km extra da Tarifa KM Controlada
	public double getKmExtra(){
		return getTarifaControloda() * 0.0115;
	}
	
	public void addVeiculo(Veiculo veiculo){
		veiculos.add(veiculo);
	}
	
	public Veiculo getVeiculo(int i){
		return veiculos.get(i);
	}
		
	public ArrayList<Veiculo> getListaDeVeiculos() 
	{
		return veiculos;
	}

	public void setListaDeVeiculos(ArrayList<Veiculo> listaDeVeiculos) 
	{
		this.veiculos = listaDeVeiculos;
	}
	
	public String toString(){
		return getNome();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
