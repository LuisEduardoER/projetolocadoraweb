//Classe Dinheiro
package model;

import model.dao.DaoFactoryDinamico;
import model.dao.FormaPgtoDao;

public class Dinheiro extends FormaPagamento{
	
	
	public String toString(){
		return "Dinheiro";
	}

	@Override
	public void debitar() throws Exception{
		
		FormaPgtoDao dao = DaoFactoryDinamico.obterFormaPagamentoDao();
		dao.inserirFormaPag(this);
		setId(dao.obterUltimoRegistro());
		System.out.println("debitou com sucesso\n" + getId() );		
		
		
	}
}
