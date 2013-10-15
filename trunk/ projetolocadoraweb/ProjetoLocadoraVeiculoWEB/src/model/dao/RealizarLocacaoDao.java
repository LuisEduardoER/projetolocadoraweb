package model.dao;

import java.util.ArrayList;

import model.Locacao;

public interface RealizarLocacaoDao {
	
	public void inserir(Locacao locacao)throws Exception;
	
	public int obterUltimoRegistro()throws Exception;
	
	public Locacao consultar(int id);
	
	public ArrayList<Integer> consultaLocacao(String registro);
	
}
