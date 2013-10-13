package model.dao;

import model.FormaPagamento;

public interface FormaPgtoDao {
	
	public void inserirFormaPag(FormaPagamento pagamento) throws Exception;
	
	public int obterUltimoRegistro()throws Exception;
	
}
