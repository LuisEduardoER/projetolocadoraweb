package model.dao;

import model.Devolucao;

public interface DevolucaoDaoInterface {
	
	public void inserir(Devolucao devolucao) throws Exception;
	
	public int obterUltimoRegistro();
	
}
