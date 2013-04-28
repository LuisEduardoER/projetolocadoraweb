//Classe AcessoBD
package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável pela conexão com banco de dados MySQL
 */
 
public class AcessoBD
{
	// -----------------------------------------------------------
	// Carrega driver JDBC
	//
	static
	{
		try
		{
			Class.forName("org.postgresql.Driver");
		}
		catch (ClassNotFoundException e) 
		{
			throw new RuntimeException(e);
		}
	}

	// -----------------------------------------------------------
	// Obtém conexão com o banco de dados
	public Connection obtemConexao() throws SQLException
	{
		// string postgres: jdbc:postgresql://localhost:5432/<nome banco>
		// string mysql   : jdbc:mysql://<host>:<porta>/<nome banco>
		return DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/locadora", 	//banco de dados 
				"postgres", 									//usuario
				"postgres");									//senha
	}
}
