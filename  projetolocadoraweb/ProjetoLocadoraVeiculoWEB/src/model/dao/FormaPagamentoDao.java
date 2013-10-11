package model.dao;

import model.FormaPagamento;

public interface FormaPagamentoDao {
	
	public void inserirFormaPag(FormaPagamento pagamento)throws Exception;
	
	public int obterUltimoRegistro()throws Exception;
	
	
}
