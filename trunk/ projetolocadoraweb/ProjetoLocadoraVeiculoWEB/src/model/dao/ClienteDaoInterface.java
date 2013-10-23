package model.dao;

import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

public interface ClienteDaoInterface {
	
public void cadastrar(PessoaFisica pf)throws Exception;
	
	public void cadastrar(PessoaJuridica pj)throws Exception;
	
	public int obterUltimoRegistro();
		
	public void alterar(PessoaFisica pf)throws Exception;
	
	public void alterar(PessoaJuridica pj)throws Exception;
		
	public void excluir(Cliente cliente)throws Exception;
	
	public PessoaJuridica consultarPJ(String cnpj);
	
	public PessoaFisica consultarPF(String cpf);
	
}
