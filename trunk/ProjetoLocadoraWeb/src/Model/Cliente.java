//Classe Cliente
package Model;

public class Cliente {
	private int id;
	private String nome;
	private String telefone;
	private String email;
//	Atributo Registro - Pode ser o CPF do cliente PF ou o CNPJ do cliente PJ
	private String registro;
	private String tipo;
	
	public Cliente(){
		setId(0);
		setNome("");
		setTelefone("");
		setEmail("");
		setRegistro("");
		setTipo("");
	}
	
	
	
	public Cliente(String nome , String registro , String telefone, String email) {
		setNome(nome);
		setRegistro(registro);
		setTelefone(telefone);
		setEmail(email);
	}



	public Cliente(int id) {
		setId(id);
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



//	Métodos Get e Set do Registro
//	Registro pode ser o CPF do cliente Pessoa Fisica ou o CNPF do cliente Pessoa Jurídica
	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}


//	Métodos Get e Set do Nome
//	Nome pode ser o Nome do cliente Pessoa Fisica ou o Nome Fantasia do cliente Pessoa Jurídica
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
