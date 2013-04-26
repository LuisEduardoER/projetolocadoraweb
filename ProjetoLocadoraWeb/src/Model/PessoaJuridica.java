//Classe PessoaJuridica
package Model;

public class PessoaJuridica extends Cliente{
	
	private String razaoSocial;

	
	public PessoaJuridica(){
		super();
		setRazaoSocial("");

	}
	
	public PessoaJuridica( String nome , String registro , String fone, String email, String razaoSocial , String nomeFantasia , String cnpj){
		super(nome , registro , fone , email);
		setRazaoSocial(razaoSocial);

	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	
	
}
