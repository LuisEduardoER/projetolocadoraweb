//Classe ClienteDAO
package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;


public class ClienteDAO extends Dao {
	
	public ClienteDAO(){
		super();
	}

	public void cadastrar(PessoaFisica pf) {
		pf.setTipo("PF");
		cadastrarCliente(pf);
		
		pf.setId(obterUltimoRegistro());
		
		String sqlInsert = "INSERT INTO PF (idClienteFK , sexo , dtaNascimento ,  rg , numHabilitacao , estadoEmissor , primeiraHabilitacao , validadeCartMotorista) VALUES (? ,  ? , ? , ? , ? , ? , ? , ?)";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela CLIENTE
			//
			stm = conn.prepareStatement(sqlInsert);
			
			stm.setInt(1, pf.getId());
			stm.setString(2, pf.getSexo());
			stm.setDate(3, new java.sql.Date(pf.getDtaNascimento().getTime()));
			stm.setString(4, pf.getRg());
			stm.setString(5, pf.getNumHabilitacao());
			stm.setString(6, pf.getEstadoEmissor());
			stm.setDate(7, new java.sql.Date(pf.getPrimeiraHabilitacao().getTime()));
			stm.setDate(8, new java.sql.Date(pf.getValidadeCartMotorista().getTime()));
			
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
	

	public void cadastrar(PessoaJuridica pj) {
		pj.setTipo("PJ");
		cadastrarCliente(pj);
		
		pj.setId(obterUltimoRegistro());
		
		String sqlInsert = "INSERT INTO PJ (idClienteFK , razaoSocial ) VALUES (? , ? )";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela CLIENTE
			//
			stm = conn.prepareStatement(sqlInsert);
			
			stm.setInt(1, pj.getId());
			stm.setString(2, pj.getRazaoSocial());
			
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
		String sqlSelect = "select MAX(idCliente) as idCliente from CLIENTE";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			rs = stm.executeQuery();
			
			if(rs.first()){
				
				indice = rs.getInt("idCliente");
				
				
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
	
	private void cadastrarCliente(Cliente cliente){
		
		String sqlInsert = "INSERT INTO CLIENTE (nome , registro , telefone , email , tipo , status) VALUES ( ? , ? , ? , ? , ? , 'Y')";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela CLIENTE
			//
			stm = conn.prepareStatement(sqlInsert);
			
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getRegistro());
			stm.setString(3, cliente.getTelefone());
			stm.setString(4, cliente.getEmail());
			stm.setString(5, cliente.getTipo());
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

	public void alterar(PessoaFisica pf) {
		alterarCliente(pf);
				
		String sqlInsert = "update pf set sexo = ? , dtaNascimento = ? , rg = ? , "+ 
							"numHabilitacao = ? , estadoEmissor = ? , primeiraHabilitacao = ? , validadeCartMotorista = ? " +
							"where idClienteFK = ?";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela CLIENTE
			//
			stm = conn.prepareStatement(sqlInsert);
			
			
			stm.setString(1, pf.getSexo());
			stm.setDate(2, new java.sql.Date(pf.getDtaNascimento().getTime()));
			stm.setString(3, pf.getRg());
			stm.setString(4, pf.getNumHabilitacao());
			stm.setString(5, pf.getEstadoEmissor());
			stm.setDate(6, new java.sql.Date(pf.getPrimeiraHabilitacao().getTime()));
			stm.setDate(7, new java.sql.Date(pf.getValidadeCartMotorista().getTime()));
			stm.setInt(8, pf.getId());
			
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
	
	public void alterar(PessoaJuridica pj) {
		alterarCliente(pj);
				
		String sqlInsert = "UPDATE pj set razaoSocial = ?  where idClienteFK = ?";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela CLIENTE
			//
			stm = conn.prepareStatement(sqlInsert);
						
			stm.setString(1, pj.getRazaoSocial());
			stm.setInt(2, pj.getId());
			
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
	
	private void alterarCliente(Cliente cliente){
		String sqlInsert = "UPDATE cliente set nome = ? , registro = ? , telefone = ? , email = ? where idCliente = ?";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela CLIENTE
			//
			stm = conn.prepareStatement(sqlInsert);
			
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getRegistro());
			stm.setString(3, cliente.getTelefone());
			stm.setString(4, cliente.getEmail());
			stm.setInt(5, cliente.getId());
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

	public void excluir(Cliente cliente) {
		String sqlDelete = "update cliente set status = 'N' where idCliente = ?";

		PreparedStatement stm = null;
		try
		{
			stm = conn.prepareStatement(sqlDelete);
			stm.setInt(1, cliente.getId());

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

	public PessoaJuridica consultarPJ(String cnpj) {
		PessoaJuridica pj = null;
		String sqlSelect = "select cl.nome , cl.idCliente , cl.telefone , cl.email , cl.tipo , pj.razaoSocial , cl.registro from " +
							"cliente cl inner join pj on cl.idCliente = pj.idClienteFK " + 
							"where cl.registro = ? AND cl.status = 'Y'";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			stm.setString(1, cnpj);
			rs = stm.executeQuery();
			
			if(rs.first()){
				//Criando o obj Login
				pj = new PessoaJuridica();
				pj.setId(rs.getInt("idCliente")); 
				pj.setTelefone(rs.getString("telefone"));
				pj.setEmail(rs.getString("email"));
				pj.setTipo(rs.getString("tipo"));
				pj.setRazaoSocial(rs.getString("razaoSocial"));
				pj.setNome(rs.getString("nome"));
				pj.setRegistro(rs.getString("registro"));				
			}
			rs.close();
			stm.close();
			return pj;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return pj;
		}
	}

	public PessoaFisica consultarPF(String cpf) {
		PessoaFisica pf = null;
		String sqlSelect = "select cl.idCliente , cl.nome , cl.telefone , cl.email , cl.tipo , " +
							"pf.sexo , pf.idPF , pf.dtaNascimento , cl.registro , pf.rg , pf.numHabilitacao , pf.estadoEmissor , pf.primeiraHabilitacao , pf.validadeCartMotorista  from " +
							"cliente cl inner join pf on cl.idCliente = pf.idClienteFK where cl.registro = ? AND cl.status = 'Y'";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			stm.setString(1, cpf);
//			stm.setString(2, usuario.getSenha());
			rs = stm.executeQuery();
			
			if(rs.first()){
				//Criando o obj Login
				pf = new PessoaFisica();
				pf.setId(rs.getInt("idCliente"));
				pf.setIdPF(rs.getInt("idPF"));
				pf.setTelefone(rs.getString("telefone"));
				pf.setEmail(rs.getString("email"));
				pf.setTipo(rs.getString("tipo"));
				pf.setNome(rs.getString("nome"));
				pf.setSexo(rs.getString("sexo"));
				pf.setDtaNascimento(rs.getDate("dtaNascimento"));
				pf.setRegistro(rs.getString("registro"));
				pf.setRg(rs.getString("rg"));
				pf.setNumHabilitacao(rs.getString("numHabilitacao"));
				pf.setEstadoEmissor(rs.getString("estadoEmissor"));
				pf.setPrimeiraHabilitacao(rs.getDate("primeiraHabilitacao"));
				pf.setValidadeCartMotorista(rs.getDate("validadeCartMotorista"));
			}
			rs.close();
			stm.close();
			return pf;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return pf;
		}
	}
	
	private Cliente consultar(int id) {
		Cliente cliente = null;
		String sqlSelect = "select * from cliente where idCliente = ?";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			stm.setInt(1, id);
			rs = stm.executeQuery();
			
			if(rs.first()){
				//Criando o obj Agencia
				cliente = new Cliente();
				cliente.setId(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setRegistro(rs.getString("registro"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTipo(rs.getString("tipo"));
				cliente.setRegistro(consultarRegistro(id));
				
			}
			rs.close();
			stm.close();
			return cliente;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	private String consultarRegistro(int id) {
		String sqlSelect = "select * from cliente where idCliente = ?";
		String registro = null;
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			stm.setInt(1, id);
			rs = stm.executeQuery();
			
			if(rs.first()){
				registro = rs.getString("registro");
			}
			rs.close();
			stm.close();
			return registro;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}

		
	private PessoaFisica consultarPessoaFisica(int idPf){
		PessoaFisica pf = null;
		String sqlSelect = "select * from pf inner join cliente on idCliente = idClienteFK where idPF = ?";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			stm.setInt(1, idPf);
			rs = stm.executeQuery();
			
			if(rs.first()){
				//Criando o obj PF
				pf = new PessoaFisica();
				pf.setId(rs.getInt("idCliente"));
				pf.setIdPF(rs.getInt("idPF"));
				pf.setTelefone(rs.getString("telefone"));
				pf.setEmail(rs.getString("email"));
				pf.setTipo(rs.getString("tipo"));
				pf.setNome(rs.getString("nome"));
				pf.setSexo(rs.getString("sexo"));
				pf.setDtaNascimento(rs.getDate("dtaNascimento"));
				pf.setRegistro(rs.getString("registro"));
				pf.setRg(rs.getString("rg"));
				pf.setNumHabilitacao(rs.getString("numHabilitacao"));
				pf.setEstadoEmissor(rs.getString("estadoEmissor"));
				pf.setPrimeiraHabilitacao(rs.getDate("primeiraHabilitacao"));
				pf.setValidadeCartMotorista(rs.getDate("validadeCartMotorista"));
			}
			rs.close();
			stm.close();
			return pf;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return pf;
		}
	}

	protected static Cliente consultarById(int id){
		ClienteDAO dao = new ClienteDAO();
		return dao.consultar(id);
	}

	protected static PessoaFisica consultarPfById(int id) {
		ClienteDAO dao = new ClienteDAO();
		return dao.consultarPessoaFisica(id);
	}
	
}
