//Classe FormaPagamentoDAO
package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Cheque;

public class FormaPagamentoPostgresDAO extends FormaPagamentoGenericoPostgresDAO{

	
	public FormaPagamentoPostgresDAO(){
		super();
	}
	
	
	public void inserirFormaPag(Cheque cheque) throws Exception{
		super.inserirFormaPag(cheque);
		int ultimoRegistro = obterUltimoRegistro();
		
		String sqlInsert = "insert into cheque (nomeBanco , numAgencia , numCCO , nomeTitular , cpfTitular , foneTitular , idFormaPagamentoFK) values " +
							"(? , ? , ? , ? , ? , ? , ?)";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela Cheque
			//
			stm = conn.prepareStatement(sqlInsert);

			stm.setString(1, cheque.getNomeBanco());
			stm.setString(2, cheque.getNumAgencia());
			stm.setString(3, cheque.getNumCCO());
			stm.setString(4, cheque.getNomeTitular());
			stm.setString(5, cheque.getCpfTitular());
			stm.setString(6, cheque.getFoneTitular());
			stm.setInt(7, ultimoRegistro);
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
}
