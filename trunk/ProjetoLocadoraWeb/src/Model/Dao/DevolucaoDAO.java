//Classe DevolucaoDAO
package Model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Model.Devolucao;


public class DevolucaoDAO extends Dao{
	
	public DevolucaoDAO(){
		super();
	}
	
	
	public void inserir(Devolucao devolucao){
		
		String sqlInsert = "insert into devolucao (dtaDevolucao , total , idLocacaoFK , idFormPagFK , idAgenciaDevolucaoFK) values " + 
				"(? , ? , ? , ? , ?)";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela DEVOLUÇÃO
			//
			stm = conn.prepareStatement(sqlInsert);
			
//			Para inserir Data e Hora, devemos utilizar a classe Timestamp e passar como parâmetro um horário no tipo Long
//			date.getTime() - retorno a data e hora no formato de Long
//			Timestamp dataRetirada = new Timestamp(locacao.getDtaRetirada().getTime());
			Timestamp dataDevolucao = new Timestamp(devolucao.getDtaDevolucao().getTime());
			
			stm.setTimestamp(1, dataDevolucao);
			stm.setDouble(2, devolucao.getTotal());
			stm.setInt(3, devolucao.getLocacao().getId());
			try{
				stm.setInt(4, devolucao.getFormaPagamento().getId());
			}catch(Exception e){
				stm.setNull(4, java.sql.Types.SMALLINT);
			}
			stm.setInt(5, devolucao.getAgenciaDevolucao().getCodigo());
			
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


	public int obterUltimoRegistro(){
		int indice = -1;
		String sqlSelect = "select MAX(idDevolucao) as idDevolucao from DEVOLUCAO";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			rs = stm.executeQuery();
			
			if(rs.first()){
				
				indice = rs.getInt("idDevolucao");
				
				
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
}
