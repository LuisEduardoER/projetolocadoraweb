//Classe LocacaoDAO
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import model.Condutor;
import model.Locacao;


public class LocacaoDAO extends Dao{
	
	public LocacaoDAO(){
		super();
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void inserir(Locacao locacao)throws Exception{
		
		String sqlInsert = "INSERT INTO LOCACAO ( tipoTarifa , dtaRetirada , dtaPrevDevolucao , total , kmInicialControlado, idAgenciaDevolucaoFK , idAgenciaRetiradaFK , " +
							"idFormPagFK , idVeiculoAgFK , idClienteFK) VALUES " + 
							"( ? , ? , ? , ? ,  ? , ? , ? , ? , ? , ?)";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela LOCACAO
			//
			stm = conn.prepareStatement(sqlInsert);
			
//			Para inserir Data e Hora, devemos utilizar a classe Timestamp e passar como par�metro um hor�rio no tipo Long
//			date.getTime() - retorno a data e hora no formato de Long
			Timestamp dataRetirada = new Timestamp(locacao.getDtaRetirada().getTime());
			Timestamp dataDevolucao = new Timestamp(locacao.getDtaPrevDevolucao().getTime());
			
			stm.setString(1, locacao.getTipoTarifa());
			stm.setTimestamp(2, dataRetirada);
			stm.setTimestamp(3, dataDevolucao);
			stm.setDouble(4, locacao.getTotal());
			try{
				stm.setInt(5, locacao.getKmInicialControlado());
			}catch(Exception e){
				stm.setNull(5, Types.INTEGER);
			}
			stm.setInt(6, locacao.getAgenciaDevolucao().getCodigo());
			stm.setInt(7, locacao.getAgenciaRetirada().getCodigo());
			stm.setInt(8, locacao.getFormaPagamento().getId());
			try{
//				stm.setInt(9, locacao.getVeiculoEscolhido().getId());
				stm.setInt(9, locacao.getVeiculoEscolhido().getIdVeiculoAg());
			}catch(Exception e){
				stm.setNull(9, Types.SMALLINT);
			}
			stm.setInt(10, locacao.getClienteEscolhido().getId());
			
			stm.execute();
			conn.commit();
			if(locacao.getClienteEscolhido().getTipo().equals("PJ")){
				inserirCondutores(locacao.getCondutores(), obterUltimoRegistro());
			}

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
	//------------------------------------------------------------------------------------------------------------------------------------------------------------	
	private void inserirCondutores(ArrayList<Condutor> condutores , int idLocacao){
		
		String sqlInsert = "insert into condutor ( idLocacaoFK , idVeiculoAgFK , idPfFK , total , kmInicialControlado) values " + 
							"(? , ? , ? , ? , ?)";
		
		PreparedStatement stm = null;
		
		try 
		{
			//
			// Inclusao dos dados na tabela CONDUTOR
			//
			stm = conn.prepareStatement(sqlInsert);
			
			int i = 0;
			while(i < condutores.size()){
				Condutor condutor = condutores.get(i);
				stm.setInt(1, idLocacao);
				stm.setInt(2, condutor.getVeiculo().getId());
				stm.setInt(3, condutor.getPf().getIdPF());
				stm.setDouble(4, condutor.getTotal());
				try{
					stm.setInt(5, condutor.getKmInicialControlado());
				}catch(Exception e){
					stm.setNull(5, Types.INTEGER);
				}
				stm.execute();
				conn.commit();
				i++;
			}
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
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	public ArrayList<Condutor> consultarCondutores(int idLocacao){
		ArrayList<Condutor> condutores = new ArrayList<Condutor>();
		String sqlSelect = "select * from condutor where idLocacaoFK = ?";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			stm.setInt(1, idLocacao);
			rs = stm.executeQuery();
			
			while(rs.next()){
				//Criando o obj Condutor
				Condutor cond = new Condutor();
				cond.setId(rs.getInt("idCondutor")); 
				cond.setKmInicialControlado(rs.getInt("kmInicialControlado"));
				cond.setPf(DaoFactoryDinamico.consultarPfById(rs.getInt("idPfFk")));
				cond.setTotal(rs.getDouble("total"));
				cond.setVeiculo(DaoFactoryDinamico.obterVeiculoDao().consultarById(rs.getInt("idVeiculoAgFK")));
				
				condutores.add(cond);
				
			}
			rs.close();
			stm.close();
			return condutores;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return condutores;
		}
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	public int obterUltimoRegistro()throws Exception{
		int indice = -1;
		String sqlSelect = "select MAX(idLocacao) as idLocacao from LOCACAO";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rs = stm.executeQuery();
			
			if(rs.first()){
				
				indice = rs.getInt("idLocacao");
				
				
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
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public Locacao consultar(int id){
		Locacao locacao = null;
		String sqlSelect = "SELECT * FROM locacao where idLocacao = ?";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			stm.setInt(1, id);
			rs = stm.executeQuery();
			
			if(rs.first()){
				//Criando o obj Locacao
				locacao = new Locacao();
				locacao.setId(rs.getInt("idLocacao")); 
				locacao.setTipoTarifa(rs.getString("tipoTarifa"));
				locacao.setDtaRetirada(rs.getTimestamp("dtaRetirada"));
				locacao.setDtaPrevDevolucao((rs.getTimestamp("dtaPrevDevolucao")));
				locacao.setTotal(rs.getDouble("total"));
				locacao.setKmInicialControlado(rs.getInt("kmInicialControlado"));
				
				locacao.setAgenciaDevolucao(AgenciaDAO.consultarById(rs.getInt("idAgenciaDevolucaoFK")));
				locacao.setAgenciaRetirada(AgenciaDAO.consultarById(rs.getInt("idAgenciaRetiradaFK")));
				locacao.setFormaPagamento(FormaPagamentoPostgresDaoImpl.consultarById(rs.getInt("idFormPagFK")));
				
				locacao.setVeiculoEscolhido(DaoFactoryDinamico.obterVeiculoDao().consultarById(rs.getInt("idVeiculoAgFK")));
				
				locacao.setClienteEscolhido(DaoFactoryDinamico.consultarById(rs.getInt("idClienteFK")));
				if(locacao.getClienteEscolhido().getTipo().equals("PJ")){
					locacao.setCondutores(consultarCondutores(locacao.getId()));
				}		
				
				
			}
			rs.close();
			stm.close();
			return locacao;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return locacao;
		}
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
//	Retorna se a loca��o j� foi devolvida (true) ou n�o (false)
	public boolean isDevolvido(int idLocacao){
		boolean flag = false;
		String sqlSelect = "select * from devolucao where idLocacaoFK = ?";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		
		try{
						
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, idLocacao);
			rs = stm.executeQuery();
			
			if(rs.first()){
				flag = true;
			}
			rs.close();
			stm.close();
			return flag;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return flag;
		}
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
//	Retorna os n�meros das loca��es em aberto que o cliente PF efetuou
	public ArrayList<Integer> consultaLocacao(String registro){
		ArrayList<Integer> nroLocacoes = new ArrayList<Integer>();
		String sqlSelect = "select idLocacao from cliente " + 
							"inner join (SELECT idClienteFK , idLocacao FROM locacao " + 
								"WHERE locacao.idLocacao NOT IN ( " +
								"SELECT DISTINCT idLocacaoFK FROM devolucao)) wti on cliente.idCliente = wti.idClienteFK " + 
								"where registro = ?";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try{
			
			
			stm = conn.prepareStatement(sqlSelect);

			stm.setString(1, registro);
			rs = stm.executeQuery();
			
			while(rs.next()){
				nroLocacoes.add(rs.getInt("idLocacao"));
			}
			rs.close();
			stm.close();
			return nroLocacoes;
			
		} 
		catch (SQLException e){
			e.printStackTrace();
			return nroLocacoes;
		}
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	
//	INSERT INTO LOCACAO ( tipoTarifa , dtaRetirada , dtaPrevDevolucao , total , idAgenciaDevolucaoFK , idAgenciaRetiradaFK ,
//            idFormPagFK , idVeiculoAgFK , idClienteFK) VALUES
//( 'Livre' , '2012-10-15 00:00:00' , '2012-10-16 00:00:00' ,  123.32 , 2 , 1 , 1 , 1 , 1);
	
	/* 
	select idLocacao from pf
	  inner join cliente on pf.idClienteFK = cliente.idCliente
	  inner join (SELECT idClienteFK , idLocacao FROM locacao
	                WHERE locacao.idLocacao NOT IN (
	                  SELECT DISTINCT idLocacaoFK FROM devolucao)) wti on cliente.idCliente = wti.idClienteFK
	  where cpf = '321.123.321-01';
	*/
}
