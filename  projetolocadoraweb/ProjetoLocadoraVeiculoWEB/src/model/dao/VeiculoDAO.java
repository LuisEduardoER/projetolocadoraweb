//Classe VeiculoDAO
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.postgresql.util.PSQLException;




import model.Grupo;
import model.Veiculo;


public class VeiculoDAO extends Dao{
	
	public VeiculoDAO(){
		super();
	}
	
	
//	Método irá retornar ArrayList de gupo
	public ArrayList<Grupo> getListGrupoByAgencia(int idAgencia) {
		String sql = "select v.idveiculo , va.idVeiculoAg , g.idGrupo , g.nome , g.tarifaLivre , g.tarifaControlada , " +
					 "v.fabricante , v.placa , v.cidade , v.km , v.chassi , v.modelo , v.estado from grupo g inner join " +
					 "veiculo v on g.idGrupo = v.idGrupoFK inner join " + 
					 "veiculo_agencia va on v.idVeiculo = va.idVeiculoFK inner join " +
					 "agencia ag on va.idAgenciaFK = ag.idAgencia " +
					 "where ag.idAgencia = ? " +
					 "order by ag.nome , g.nome;";
		try{
			ArrayList<Grupo> grupos = new ArrayList<Grupo>();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idAgencia);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
//				Se o Array "grupos" estiver vazio .OU. o se não for o último grupo inserido
//				então inserir um novo grupo
				if(grupos.isEmpty() || !rs.getString("nome").equals(grupos.get(grupos.size() -1).getNome())){
					//Criando o obj Agencia
					Grupo grupo = new Grupo();
					grupo.setId(rs.getInt("idGrupo"));
					grupo.setNome(rs.getString("nome"));
					grupo.setTarifaControloda(rs.getDouble("tarifaControlada"));
					grupo.setTarifaLivre(rs.getDouble("tarifaLivre"));
					
					Veiculo veiculo = new Veiculo();
					veiculo.setId(rs.getInt("idVeiculo"));
					veiculo.setIdVeiculoAg(rs.getInt("idVeiculoag"));
					veiculo.setFabricante(rs.getString("fabricante"));
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setCidade(rs.getString("cidade"));
					veiculo.setKm(rs.getString("km"));
					veiculo.setChassi(rs.getString("chassi"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setEstado(rs.getString("estado"));
					veiculo.setGrupo(grupo); //adiciona o Grupo vigente no Veículo
					
					grupo.addVeiculo(veiculo);				
					//adicionando o objeto à lista
					grupos.add(grupo);
				}
				else{
//					Adicionar apenas o veículo no último grupo
					Veiculo veiculo = new Veiculo();
					veiculo.setId(rs.getInt("idVeiculo"));
					veiculo.setIdVeiculoAg(rs.getInt("idVeiculoag"));
					veiculo.setFabricante(rs.getString("fabricante"));
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setCidade(rs.getString("cidade"));
					veiculo.setKm(rs.getString("km"));
					veiculo.setChassi(rs.getString("chassi"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setEstado(rs.getString("estado"));
					veiculo.setGrupo(grupos.get(grupos.size() -1)); //adiciona o Grupo vigente no Veículo
					
					grupos.get(grupos.size() -1).addVeiculo(veiculo);
				}
				
			}
			rs.close();
			stmt.close();
			return grupos;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	private Veiculo consultar(int idVeiculoAg){
		Veiculo veiculo = null;
		String sqlSelect = "select * from grupo g inner join " +
							"veiculo v on g.idGrupo = v.idGrupoFK inner join " +
							"veiculo_agencia va on v.idVeiculo = va.idVeiculoFK " +
							"where va.idVeiculoAg = ?";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, idVeiculoAg);
			rs = stm.executeQuery();
			
			if(rs.first()){
				//Criando o obj Veiculo
				veiculo = new Veiculo();

				veiculo.setId(rs.getInt("idVeiculo"));
				veiculo.setIdVeiculoAg(rs.getInt("idVeiculoag"));
				veiculo.setFabricante(rs.getString("fabricante"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setCidade(rs.getString("cidade"));
				veiculo.setKm(rs.getString("km"));
				veiculo.setChassi(rs.getString("chassi"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setEstado(rs.getString("estado"));
				Grupo grupo = new Grupo();
				grupo.setId(rs.getInt("idGrupo"));
				grupo.setNome(rs.getString("nome"));
				grupo.setTarifaControloda(rs.getDouble("tarifaControlada"));
				grupo.setTarifaLivre(rs.getDouble("tarifaLivre"));
				veiculo.setGrupo(grupo);
			}
			rs.close();
			stm.close();
			return veiculo;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	protected static Veiculo consultarById(int id){
		VeiculoDAO dao = new VeiculoDAO();
		return dao.consultar(id);
	}
	
	public ArrayList<Grupo> getListGrupo(){
		String sql = "select * from grupo";
		
		try{
			ArrayList<Grupo> grupos = new ArrayList<Grupo>();
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Grupo grupo = new Grupo();
				grupo.setId(rs.getInt("idGrupo"));
				grupo.setNome(rs.getString("nome"));
				grupo.setTarifaControloda(rs.getDouble("tarifaControlada"));
				grupo.setTarifaLivre(rs.getDouble("tarifaLivre"));
				
				grupos.add(grupo);
								
			}
			rs.close();
			stmt.close();
			return grupos;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}


	public void inserir(Veiculo veiculo, int agenciaCodigo){
		String sqlInsert = "INSERT INTO VEICULO (fabricante , placa , cidade , km , chassi , modelo , estado , idgrupofk) VALUES "  + 
							"(? , ? , ? , ? , ? , ? , ? , ?)";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela CLIENTE
			//
			stm = conn.prepareStatement(sqlInsert);
			
//			stm.setInt(1, veiculo.getId());
			stm.setString(1, veiculo.getFabricante());
			stm.setString(2, veiculo.getPlaca());
			stm.setString(3, veiculo.getCidade());
			stm.setString(4, veiculo.getKm());
			stm.setString(5, veiculo.getChassi());
			stm.setString(6, veiculo.getModelo());
			stm.setString(7, veiculo.getEstado());
			stm.setInt(8, veiculo.getGrupo().getId());
			stm.execute();
			
			conn.commit();
			inserirVeiculoAgencia(agenciaCodigo);
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
				try 
				{
					conn.rollback();
				}
				catch (SQLException e1) 
				{
					System.out.print(e1.getStackTrace());
				}
		} 
		finally 
		{
			if (stm != null) 
			{
				try 
				{
					stm.close();
				} 
				catch (SQLException e1) 
				{
					System.out.print(e1.getStackTrace());
				}
			}
		}
		
	}
	
	private void inserirVeiculoAgencia(int agenciaCodigo) {
		String sqlSelect = "insert into veiculo_agencia (idveiculofk , idagenciafk) values (? , ?)";
		
		PreparedStatement stm = null;
		System.out.println(obterUltimoRegistro());
		try 
		{
			//
			// Inclusao dos dados na tabela CLIENTE
			//
			stm = conn.prepareStatement(sqlSelect);
			
			stm.setInt(1, obterUltimoRegistro());
			stm.setInt(2, agenciaCodigo);
			
			stm.execute();
			conn.commit();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
				try 
				{
					conn.rollback();
				}
				catch (SQLException e1) 
				{
					System.out.print(e1.getStackTrace());
				}
		} 
		finally 
		{
			if (stm != null) 
			{
				try 
				{
					stm.close();
				} 
				catch (SQLException e1) 
				{
					System.out.print(e1.getStackTrace());
				}
			}
		}
		
		
	}


	private int obterUltimoRegistro(){
		int indice = -1;
		String sqlSelect = "select MAX(idveiculo) as idveiculo from VEICULO";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
//			stm = conn.prepareStatement(sqlSelect);
			stm = conn.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
			rs = stm.executeQuery();
			
			if(rs.first()){
				
				indice = rs.getInt("idveiculo");
				
				
			}
			System.out.println(indice);
			rs.close();
			stm.close();
			return indice;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return indice;
		}	
	}


	public void alterar(Veiculo veiculo) {
		String sqlInsert = "UPDATE veiculo set fabricante = ? , placa = ? , cidade = ? , km = ? , chassi = ? , modelo = ? , estado = ? where idveiculo = ?";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela VEÍCULO
			//
			stm = conn.prepareStatement(sqlInsert);
			
			stm.setString(1, veiculo.getFabricante());
			stm.setString(2, veiculo.getPlaca());
			stm.setString(3, veiculo.getCidade());
			stm.setString(4, veiculo.getKm());
			stm.setString(5, veiculo.getChassi());
			stm.setString(6, veiculo.getModelo());
			stm.setString(7, veiculo.getEstado());
			stm.setInt(8, veiculo.getId());
			
			stm.execute();
			
			conn.commit();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
				try 
				{
					conn.rollback();
				}
				catch (SQLException e1) 
				{
					System.out.print(e1.getStackTrace());
				}
		} 
		finally 
		{
			if (stm != null) 
			{
				try 
				{
					stm.close();
				} 
				catch (SQLException e1) 
				{
					System.out.print(e1.getStackTrace());
				}
			}
		}
		
	}
	
	public void excluirVeiculoAgencia(Veiculo veiculo){
//		Connection con = null;
		PreparedStatement stmt = null;

		try {
			String sql = "delete from veiculo_agencia where idveiculoag = ?";
			
//			AcessoBD bd = new AcessoBD();
//			con = bd.obtemConexao();
			stmt = conn.prepareStatement(sql);

//			stmt.setLong(1, id);
			stmt.setInt(1, veiculo.getIdVeiculoAg());

			stmt.execute();
			conn.commit();

		} catch (SQLException sq) {
			sq.printStackTrace();

		} finally {
			// IMPORTANTE UTILIZACAO DO FINALLY PARA GARANTIR O FECHAMENTO
			// DA CONEXAO COM O BANCO DE DADOS.

			// fecha o statement
			//
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					//
				}
			}
			
		}
	}
	
	public void excluir(Veiculo veiculo){
//		Connection con = null;
		PreparedStatement stmt = null;

		try {
			excluirVeiculoAgencia(veiculo);
			
			String sql = "delete from veiculo where idveiculo = ?";
			
//			AcessoBD bd = new AcessoBD();
//			con = bd.obtemConexao();
			stmt = conn.prepareStatement(sql);

//			stmt.setLong(1, id);
			stmt.setInt(1, veiculo.getId());

			stmt.execute();
			conn.commit();

		} catch (SQLException sq) {
			sq.printStackTrace();

		} finally {
			// IMPORTANTE UTILIZACAO DO FINALLY PARA GARANTIR O FECHAMENTO
			// DA CONEXAO COM O BANCO DE DADOS.

			// fecha o statement
			//
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					//
				}
			}
			
		}
	}
	
	

//	public void excluir(Veiculo veiculo, int agenciaCodigo) {
////		String sql = "DELETE FROM veiculo_agencia WHERE idveiculofk = ?";
//		System.out.println("metodo excluirDAO   ID: " + veiculo.getId());
//		excluirVeiculo(veiculo);
//		
//		String sql = "DELETE FROM veiculo WHERE idveiculo = ?";
//		
//		PreparedStatement stmt = null;
//
//		try {
////			String sql = "delete from aluno where id = ?";
//
////			AcessoBD bd = new AcessoBD();
////			conn = bd.obtemConexao();
////			String sql = "delete from aluno where id = ?";
////
////			AcessoBD bd = new AcessoBD();
////			con = bd.obtemConexao();
////			stmt = con.prepareStatement(sql);
////
////			stmt.setLong(1, id);
////
////			stmt.execute();
//			
//			
//			stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, veiculo.getId());
//			System.out.println(sql);
//			stmt.execute();
////			excluirVeiculo(veiculo);
//			
////			String sql = "delete from aluno where id = ?";
////
////			AcessoBD bd = new AcessoBD();
////			con = bd.obtemConexao();
////			stmt = con.prepareStatement(sql);
////
////			stmt.setLong(1, id);
////
////			stmt.execute();
//			
//
//		} catch (SQLException sq) {
//			sq.printStackTrace();
//			System.out.println("error 1st");
//		}finally{
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//				//
//				}
//			}
//		}
////		} finally {
////			// IMPORTANTE UTILIZACAO DO FINALLY PARA GARANTIR O FECHAMENTO
////			// DA CONEXAO COM O BANCO DE DADOS.
////
////			// fecha o statement
////			//
////			if (stmt != null) {
////				try {
////					stmt.close();
////				} catch (SQLException e) {
////					//
////				}
////			}
////			// fecha a conexao
////			//
////			if (conn != null) {
////				try {
////					conn.close();
////				} catch (SQLException e) {
////					//
////				}
////			}
////		}
//		
//	}
//
//
//	private void excluirVeiculo(Veiculo veiculo) {
////		String sql = "DELETE FROM veiculo WHERE idveiculo = ?";
//		String sql = "DELETE FROM veiculo_agencia WHERE idveiculofk = ?";
//		PreparedStatement stmt = null;
//
//		try {
////			String sql = "delete from aluno where id = ?";
//
////			AcessoBD bd = new AcessoBD();
////			conn = bd.obtemConexao();
//			
//			stmt.setInt(1, veiculo.getId());
//			stmt = conn.prepareStatement(sql);
//			stmt.execute();
//
//		} catch (SQLException sq) {
//			sq.printStackTrace();
//			System.out.println("error 2nd");
//		}finally{
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//				//
//				}
//			}
//		}
//	}
	
	
//	Select para retornar o veículo na sua respectiva agência
	/*
	select va.idVeiculoAg , g.idGrupo , g.nome , g.tarifaLivre , g.tarifaControlada ,
      v.fabricante , v.placa , v.cidade , v.km , v.chassi , v.modelo , v.estado from grupo g inner join
	  veiculo v on g.idGrupo = v.idGrupoFK inner join
	  veiculo_agencia va on v.idVeiculo = va.idVeiculoFK inner join
	  agencia ag on va.idAgenciaFK = ag.idAgencia
	  where ag.idAgencia = 1
	order by ag.nome;
	*/	
}
