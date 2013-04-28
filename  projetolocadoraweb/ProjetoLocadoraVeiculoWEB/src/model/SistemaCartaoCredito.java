//Interface SistemaCartaoCredito
package model;

public interface SistemaCartaoCredito {
	
	public boolean validar();
	
	public boolean debitar(Cartao cartao);
	
}
