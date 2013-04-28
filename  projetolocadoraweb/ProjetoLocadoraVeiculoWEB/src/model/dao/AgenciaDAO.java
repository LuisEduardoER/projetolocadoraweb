//Classe AgenciaDAO
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Agencia;


public class AgenciaDAO extends Dao{
	
	public AgenciaDAO(){
		super();
	}
	
	//MÉTODO IRÁ RETORNAR TODAS AS AGÊNCIAS
	public ArrayList<Agencia> getList(){
		try{
			ArrayList<Agencia> agencias = new ArrayList<Agencia>();
			PreparedStatement stmt = conn.prepareStatement("select * from agencia");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				//Criando o obj Agencia
				Agencia ag = new Agencia();
				ag.setCodigo(rs.getInt("idAgencia"));
				ag.setNome(rs.getString("nome"));
				ag.setCidade(rs.getString("cidade"));
				ag.setEstado(rs.getString("estado"));
				ag.setPais(rs.getString("pais"));
				ag.setIdCidade(rs.getInt("idCidade"));
				
				//adicionando o objeto à lista
				agencias.add(ag);
			}
			rs.close();
			stmt.close();
			return agencias;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
//	Método irá consultar uma agência pela FK
	private Agencia consultar(int codigo){
		Agencia agencia = null;
		String sqlSelect = "select * from agencia where idAgencia = ?";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			stm.setInt(1, codigo);
//			stm.setString(2, usuario.getSenha());
			rs = stm.executeQuery();
			
			if(rs.first()){
				//Criando o obj Agencia
				agencia = new Agencia();
				agencia.setCodigo(rs.getInt("idAgencia"));
				agencia.setNome(rs.getString("nome"));
				agencia.setCidade(rs.getString("cidade"));
				agencia.setEstado(rs.getString("estado"));
				agencia.setPais(rs.getString("pais"));
				agencia.setIdCidade(rs.getInt("idCidade"));
			}
			rs.close();
			stm.close();
			return agencia;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	protected static Agencia consultarById(int codigo){
		AgenciaDAO dao = new AgenciaDAO();
		return dao.consultar(codigo);		
	}

}
