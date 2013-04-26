//Classe FormaPagamentoGenericoDAO
package Model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.FormaPagamento;

public class FormaPagamentoGenericoDAO extends Dao {
	
	public FormaPagamentoGenericoDAO(){
		super();
	}
	
	public void inserirFormaPag(FormaPagamento pagamento){
		
		String sqlInsert = "insert into forma_pagamento (tipo , total) values (? , ?)";
			
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela FORMA_PAGAMENTO
			//
			stm = conn.prepareStatement(sqlInsert);

			stm.setString(1, pagamento.toString());
			stm.setDouble(2, pagamento.getTotal());
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
		String sqlSelect = "select MAX(idFormaPagamento) as idFormaPagamento from FORMA_PAGAMENTO";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			rs = stm.executeQuery();
			
			if(rs.first()){
				
				indice = rs.getInt("idFormaPagamento");
				
				
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
	
	private FormaPagamento consultar(int id){
		FormaPagamento formaPagamento = null;
		String sqlSelect = "select * from forma_pagamento where idFormaPagamento = ?";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			stm.setInt(1, id);
			rs = stm.executeQuery();
			
			if(rs.first()){
				//Criando o obj FormaPagamento
				formaPagamento = new FormaPagamento();
				formaPagamento.setId(rs.getInt("idFormaPagamento"));
				formaPagamento.setTotal(rs.getDouble("total"));
			}
			rs.close();
			stm.close();
			return formaPagamento;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	protected static FormaPagamento consultarById(int id){
		FormaPagamentoGenericoDAO dao = new FormaPagamentoDAO();
		return dao.consultar(id);
	}
	
}
