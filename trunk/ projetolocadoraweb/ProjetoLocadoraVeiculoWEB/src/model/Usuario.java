//Classe Usuario
package model;

public class Usuario {
	private int id;
	private String nome;
	private String login;
	private String senha;
	
	
	public Usuario(){
		
	}	
	
	public Usuario(String login, String senha) {
		setId(0);
		setLogin(login);
		setSenha(senha);
		setNome("");
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString(){
		
		return getId() + " - " + getLogin() + " - " + getSenha() + " - " + getNome();
		
	}
		
}
