//Classe Dao
package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class Dao {
	
	protected Connection conn;
	
	public Dao(){
		try{		
			conn = new AcessoBD().obtemConexao();
			conn.setAutoCommit(false);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			if (conn != null)
			{
				try
				{
					conn.rollback();
				}
				catch (SQLException e1)
				{
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
}
