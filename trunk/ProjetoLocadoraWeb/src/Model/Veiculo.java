//Classe Veiculo
package Model;

public class Veiculo {
	
	private int id;
	private String modelo;
	private String fabricante;
	private String chassi;
	private String placa;
	private String km;
	private String cidade;
	private String estado;
	private Grupo grupo;
	private int idVeiculoAg;
	private double totalAcessorios;
	
	public Veiculo(){
		
	}
	
	public Veiculo(int id ,String modelo , String fabricante , String chassi , String placa , String km , String cidade , String estado){
		setId(id);
		setModelo(modelo);
		setFabricante(fabricante);
		setChassi(chassi);
		setPlaca(placa);
		setKm(km);
		setCidade(cidade);
		setEstado(estado);
	}
	
	
	public Veiculo(int id) {
		setId(id);
	}

	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String getChassi() {
		return chassi;
	}
	
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getKm() {
		return km;
	}
	
	public void setKm(String km) {
		this.km = km;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public double getTotalAcessorios() {
		return totalAcessorios;
	}

	public void setTotalAcessorios(double totalAcessorios) {
		this.totalAcessorios = totalAcessorios;
	}

	public int getIdVeiculoAg() {
		return idVeiculoAg;
	}

	public void setIdVeiculoAg(int idVeiculoAg) {
		this.idVeiculoAg = idVeiculoAg;
	}
		
}
