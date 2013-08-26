//Classe VeiculoDAO
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.InsercaoIncorretaException;

import model.Grupo;
import model.Veiculo;

public class VeiculoPostgresDao extends Dao implements VeiculoDao2{
	
	public VeiculoPostgresDao(){
		super();
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	// Método irá retornar ArrayList de gupo
	public ArrayList<Grupo> getListGrupoByAgencia(int idAgencia){
		String sql = "select v.idveiculo , va.idVeiculoAg , g.idGrupo , g.nome , g.tarifaLivre , g.tarifaControlada , " +
					 "v.fabricante , v.placa , v.cidade , v.km , v.chassi , v.modelo , v.estado from grupo g inner join " +
					 "veiculo v on g.idGrupo = v.idGrupoFK inner join " + 
					 "veiculo_agencia va on v.idVeiculo = va.idVeiculoFK inner join " +
					 "agencia ag on va.idAgenciaFK = ag.idAgencia " +
					 "where ag.idAgencia = ? " +
					 "order by ag.nome , g.nome;";
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList<Grupo> grupos = null;
		
		try{
			grupos = new ArrayList<Grupo>();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idAgencia);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
//				Se o Array "grupos" estiver vazio .OU. o se n�o for o �ltimo grupo inserido
//				ent�o inserir um novo grupo
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
					veiculo.setGrupo(grupo); //adiciona o Grupo vigente no Ve�culo
					
					grupo.addVeiculo(veiculo);				
					//adicionando o objeto � lista
					grupos.add(grupo);
				}
				else{
//					Adicionar apenas o ve�culo no �ltimo grupo
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
					veiculo.setGrupo(grupos.get(grupos.size() -1)); //adiciona o Grupo vigente no Ve�culo
					
					grupos.get(grupos.size() -1).addVeiculo(veiculo);
				}
				
			}
//			rs.close();
//			stmt.close();
//			return grupos;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
//			return null;
			grupos = null;
		}
		finally {
			// IMPORTANTE UTILIZACAO DO FINALLY PARA GARANTIR O FECHAMENTO
			// DA CONEXAO COM O BANCO DE DADOS.

			// fecha o resultset
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					//
				}
			}
			// fecha o statement
			//
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					//
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					//
				}
			}
		}
		return grupos;
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	public Veiculo consultar(int idVeiculoAg){	//Passei de private para public pq estava com erro como private depois verificar o motivo
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
//			rs.close();
//			stm.close();
//			return veiculo;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
//			return null;
			veiculo = null;
		}
		finally {
			// IMPORTANTE UTILIZACAO DO FINALLY PARA GARANTIR O FECHAMENTO
			// DA CONEXAO COM O BANCO DE DADOS.

			// fecha o resultset
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					//
				}
			}
			// fecha o statement
			//
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					//
				}
			}
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					//
				}
			}
		}		
		return veiculo;
		
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	public Veiculo consultarById(int id){
//		VeiculoPostgresDao dao = new VeiculoPostgresDao();
//		return dao.consultar(id);
		return consultar(id);
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
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
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	public void inserir(Veiculo veiculo, int agenciaCodigo) throws Exception {
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
		catch (SQLException e) 
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
			throw new InsercaoIncorretaException(e);
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
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					//
					System.out.print(e.getStackTrace());
				}
			}
		}
		
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	public void inserirVeiculoAgencia(int agenciaCodigo) throws Exception {
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
		catch (SQLException e) 
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
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	public int obterUltimoRegistro() throws Exception{
		int indice = -1;
		String sqlSelect = "select MAX(idveiculo) as idveiculo from VEICULO";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			stm = conn.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rs = stm.executeQuery();
			
			if(rs.first()){
				indice = rs.getInt("idveiculo");
			}
			rs.close();
			stm.close();
			return indice;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return indice;
		}	
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	public void alterar(Veiculo veiculo) throws Exception{
		String sqlInsert = "UPDATE veiculo set fabricante = ? , placa = ? , cidade = ? , km = ? , chassi = ? , modelo = ? , estado = ? where idveiculo = ?";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela VE�CULO
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
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					//
				}
			}
		}
		
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	public void excluirVeiculoAgencia(Veiculo veiculo) throws Exception{

		PreparedStatement stmt = null;

		try {
			String sql = "delete from veiculo_agencia where idveiculoag = ?";
			
			stmt = conn.prepareStatement(sql);

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
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	public void excluir(Veiculo veiculo) throws Exception{

		PreparedStatement stmt = null;

		try {
			excluirVeiculoAgencia(veiculo);
			
			String sql = "delete from veiculo where idveiculo = ?";
			
			stmt = conn.prepareStatement(sql);

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
			// fecha a conexao
			//
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
						//
				}
			}
		}
	}

//	Select para retornar o ve�culo na sua respectiva ag�ncia
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
