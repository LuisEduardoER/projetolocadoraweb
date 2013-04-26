//Classe FormaPagamento
package Model;

public class FormaPagamento {
	
	private int id;
	private double total;
	
	public FormaPagamento(){
		
	}
	
	public FormaPagamento(int id){
		setId(id);
	}
	
	public FormaPagamento(double total){
		setTotal(total);
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	
}
