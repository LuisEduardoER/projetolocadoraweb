package model.dao;

import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

public interface ClienteDao {
	public void cadastrar(PessoaFisica pf);
	
	//CADASTRAR PESSOA JURIDICA**
	public void cadastrar(PessoaJuridica pj);
	
	public int obterUltimoRegistro();
	
	public void cadastrarCliente(Cliente cliente);
	
	//ALTERAR PESSOA FISICA**
	public void alterar(PessoaFisica pf);
	
	public void alterar(PessoaJuridica pj);
	
	public void alterarCliente(Cliente cliente);
	
	public void excluir(Cliente cliente);
	
	public PessoaJuridica consultarPJ(String cnpj);
	
	public PessoaFisica consultarPF(String cpf);
	
	public Cliente consultar(int id);
	
	public String consultarRegistro(int id);
	
	public PessoaFisica consultarPessoaFisica(int idPf);
	
	public Cliente consultarById(int id);

	public PessoaFisica consultarPfById(int id);

}
