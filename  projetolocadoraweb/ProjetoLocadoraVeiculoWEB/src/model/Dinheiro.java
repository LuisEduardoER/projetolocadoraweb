//Classe Dinheiro
package model;

import model.dao.DaoFactoryDinamico;
import model.dao.FormaPagamentoDao;
import model.dao.FormaPagamentoPostgresDAO;
import model.dao.VeiculoDao;

public class Dinheiro extends FormaPagamento{
	
	
	public String toString(){
		return "Dinheiro";
	}

	@Override
	public void debitar() throws Exception{
		
		FormaPagamentoDao dao = DaoFactoryDinamico.obterFormaPagamentoDao();
		dao.inserirFormaPag(this);
		setId(dao.obterUltimoRegistro());
		System.out.println("debitou com sucesso\n" + getId() );		
		
		
	}
}
