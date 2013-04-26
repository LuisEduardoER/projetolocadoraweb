//Interface SistemaCartaoCredito
package Model;

public interface SistemaCartaoCredito {
	
	public boolean validar();
	
	public boolean debitar(Cartao cartao);
	
}
