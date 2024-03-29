//Classe UsuarioDAO
package Model.Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Usuario;



public class UsuarioDAO extends Dao{
	
	
	public UsuarioDAO(){
		super();
	}
		
	
	
	public ArrayList<Usuario> getList(){
		try{
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = conn.prepareStatement("select * from usuario");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				//Criando o obj Usuario
				Usuario user = new Usuario();
//				user.setId(rs.getInt("id")); //CASO NECESSITA COLETAR QUAL O ID DO ATENDENTE
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
				user.setNome(rs.getString("nome"));
				
				//adicionando o objeto � lista
				usuarios.add(user);
			}
			rs.close();
			stmt.close();
			return usuarios;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Usuario verificaLogin(Usuario usuario){
		Usuario user = null;
		String sqlSelect = "select * from usuario where login = ? AND senha = ?";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
//			stm = conn.prepareStatement(sqlSelect);
			stm = conn.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			stm.setString(1, usuario.getLogin());
			stm.setString(2, usuario.getSenha());
			rs = stm.executeQuery();
			
			if(rs.first()){
				//Criando o obj Usuario
				user = new Usuario();
				user.setId(rs.getInt("idUsuario")); 
				user.setNome(rs.getString("nome"));
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
				//adicionando o objeto � lista
				
			}
			rs.close();
			stm.close();
			return user;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return user;
		}
	}
}
