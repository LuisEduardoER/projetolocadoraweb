//Classe PessoaFisica
package model;

import java.util.Date;

public class PessoaFisica extends Cliente{
	
	private int idPF;
	private Date dtaNascimento;
	private String sexo;
	private String rg;
	private String numHabilitacao;
	private String estadoEmissor;
	private Date primeiraHabilitacao;
	private Date validadeCartMotorista;
	
	public PessoaFisica(){
		super();
		setDtaNascimento(null);
		setSexo("");
		setRg("");
		setNumHabilitacao("");
		setEstadoEmissor("");
		setPrimeiraHabilitacao(null);
		setValidadeCartMotorista(null);
	}
	
	
	
	public PessoaFisica(String nome , String registro , String fone, String email, Date dtaNascimento, String sexo, String rg,
			String numHabilitacao, String estadoEmissor, Date primeiraHabilitacao , Date validadeCarteira) {
		
		super(nome , registro , fone , email);
		setDtaNascimento(dtaNascimento);
		setSexo(sexo);
		setRg(rg);
		setNumHabilitacao(numHabilitacao);
		setEstadoEmissor(estadoEmissor);
		setPrimeiraHabilitacao(primeiraHabilitacao);
		setValidadeCartMotorista(validadeCarteira);
		
	}



	public Date getDtaNascimento() {
		return dtaNascimento;
	}
	public void setDtaNascimento(Date dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNumHabilitacao() {
		return numHabilitacao;
	}
	public void setNumHabilitacao(String numHabilitacao) {
		this.numHabilitacao = numHabilitacao;
	}
	public String getEstadoEmissor() {
		return estadoEmissor;
	}
	public void setEstadoEmissor(String estadoEmissor) {
		this.estadoEmissor = estadoEmissor;
	}
	public Date getValidadeCartMotorista() {
		return validadeCartMotorista;
	}
	public void setValidadeCartMotorista(Date validadeCartMotorista) {
		this.validadeCartMotorista = validadeCartMotorista;
	}

	public Date getPrimeiraHabilitacao() {
		return primeiraHabilitacao;
	}

	public void setPrimeiraHabilitacao(Date primeiraHabilitacao) {
		this.primeiraHabilitacao = primeiraHabilitacao;
	}
	
	public String toString(){
		
		return getId() + "\n" +
			getNome() + "\n" +
			getDtaNascimento() + "\n" +
			getSexo() + "\n" +
			getRegistro() + "\n" +
			getRg() + "\n" +
			getNumHabilitacao() + "\n" +
			getEstadoEmissor() + "\n" +
			getPrimeiraHabilitacao() + "\n" +
			getValidadeCartMotorista();
	}



	public int getIdPF() {
		return idPF;
	}



	public void setIdPF(int idPF) {
		this.idPF = idPF;
	}

}
