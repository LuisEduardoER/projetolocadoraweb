package model.dao;

import java.util.ArrayList;

import model.Grupo;
import model.Veiculo;

public interface VeiculoDao {
	
	public ArrayList<Grupo> getListGrupoByAgencia(int idAgencia);
	
	public Veiculo consultar(int idVeiculoAg);
		
	public ArrayList<Grupo> getListGrupo();
	
	public Veiculo consultarById(int id);
	
	public void inserir(Veiculo veiculo, int agenciaCodigo) throws Exception;
	
	public void inserirVeiculoAgencia(int agenciaCodigo) throws Exception;	//old private void
	
	public int obterUltimoRegistro() throws Exception;	//old private void
	
	public void alterar(Veiculo veiculo) throws Exception;
	
	public void excluirVeiculoAgencia(Veiculo veiculo) throws Exception;	//old private void
	
	public void excluir(Veiculo veiculo) throws Exception;
	
}
