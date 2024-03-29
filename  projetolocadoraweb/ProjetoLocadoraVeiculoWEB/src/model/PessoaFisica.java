//Classe PessoaFisica
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import util.Verificacao;

import model.dao.ClienteDao;
import model.dao.ClienteDaoInterface;
import model.dao.DaoFactoryDinamico;

public class PessoaFisica extends Cliente{
	
	private int idPF;
	private Date dtaNascimento;
	private String sexo;
	private String rg;
	private String numHabilitacao;
	private String estadoEmissor;
	private Date primeiraHabilitacao;
	private Date validadeCartMotorista;
	
	//Construtor sem parametros, inicializa os metodos em branco
	public PessoaFisica(){
		super();
		setDtaNascimento(null);
		setSexo("");
		setRg("");
		setNumHabilitacao("");
		setEstadoEmissor("");
		setPrimeiraHabilitacao(null);
		setValidadeCartMotorista(null);
	}
	
	//Construtor com parametros
	public PessoaFisica(String nome , String registro , String fone, String email, Date dtaNascimento, String sexo,
					String rg,String numHabilitacao, String estadoEmissor, Date primeiraHabilitacao , Date validadeCarteira) {
		
		super(nome , registro , fone , email);
		setDtaNascimento(dtaNascimento);
		setSexo(sexo);
		setRg(rg);
		setNumHabilitacao(numHabilitacao);
		setEstadoEmissor(estadoEmissor);
		setPrimeiraHabilitacao(primeiraHabilitacao);
		setValidadeCartMotorista(validadeCarteira);
		
	}

//Getters and Setters==================================================================================================
	
	//GET DATA NASCIMENTO
	public Date getDtaNascimento() {
		return dtaNascimento;
	}
	//SET DATA DE NASCIMENTO
	public void setDtaNascimento(Date dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}
	// GET SEXO
	public String getSexo() {
		return sexo;
	}
	// SET SEXO
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	//GET RG
	public String getRg() {
		return rg;
	}
	//SET RG
	public void setRg(String rg) {
		this.rg = rg;
	}
	//GET NUMERO DA HABILITACAO 
	public String getNumHabilitacao() {
		return numHabilitacao;
	}
	//SET NUMERO DA HABILITACAO
	public void setNumHabilitacao(String numHabilitacao) {
		this.numHabilitacao = numHabilitacao;
	}
	//GET ESTADO EMISSOR
	public String getEstadoEmissor() {
		return estadoEmissor;
	}
	//SET ESTADO EMISSOR
	public void setEstadoEmissor(String estadoEmissor) {
		this.estadoEmissor = estadoEmissor;
	}
	//GET VALIDADE DE CARTEIRA DE MOTORISTA
	public Date getValidadeCartMotorista() {
		return validadeCartMotorista;
	}
	//SET VAIDADE DA CARTEIRA DE MOTORISTA
	public void setValidadeCartMotorista(Date validadeCartMotorista) {
		this.validadeCartMotorista = validadeCartMotorista;
	}
	//SET PRIMEIRA HABILITACAO
	public Date getPrimeiraHabilitacao() {
		return primeiraHabilitacao;
	}
	//GET PRIMEIRA HABILITACAO
	public void setPrimeiraHabilitacao(Date primeiraHabilitacao) {
		this.primeiraHabilitacao = primeiraHabilitacao;
	}
	//GET IDPF	
	public int getIdPF() {
		return idPF;
	}
	//SET IDPF
	public void setIdPF(int idPF) {
		this.idPF = idPF;
	}
//=====================================================================================================================
	public String toString(){
		
		return getId() + "\n" +
			getNome() + "\n" +
			getDtaNascimento() + "\n" +
			getSexo() + "\n" +
			getRegistro() + "\n" +
			getRg() + "\n" +
			getNumHabilitacao() + "\n" +
			getEstadoEmissor() + "\n" +
			getPrimeiraHabilitacao() + "\n" +
			getValidadeCartMotorista();
	}
	
	//Metodo responsavel por incluir um novo cliente PF
	@Override
	public void incluir()throws Exception{
		ClienteDaoInterface dao = DaoFactoryDinamico.obterClienteDao();
		dao.cadastrar(this);
	}
	
	//Metodo responsavel por alterar um cliente existente no banco de dados
	@Override
	public void alterar() throws Exception{
		ClienteDaoInterface cDAO = DaoFactoryDinamico.obterClienteDao();
		cDAO.alterar(this);
	}
	
	//Metodo responsavel por exibir os dados de um cliente
	public PessoaFisica pesquisar(){
		ClienteDaoInterface cDAO = DaoFactoryDinamico.obterClienteDao();
		return cDAO.consultarPF(getRegistro());
	}
	//Metodo responsave por excluir um cliente da base de dados
	@Override
	public void excluir() throws Exception{
		ClienteDaoInterface dao = DaoFactoryDinamico.obterClienteDao();
		dao.excluir(this);
	}
	
	/*Método que irá verificar se o cliente possui idade menor de 21 anos.
	* true - Possui idade maior que 21 anos
	* false - Possui idade menor que 21 anos
	*/
	public boolean verificarIdade(){
		if(Verificacao.getTotalAnos(getDtaNascimento()) <= 21){
			return false; //idade MENOR que 21 anos
		}
		else{
			return true; //idade MAIOR que 21 anos
		}
	}
	
	/*Método que irá verificar se o cliente tem menos de 2 anos de habilitação.
	* true - Cliente tem mais de 2 anos de habilitação
	* false - Cliente não tem menos de 2 anos de habilitação
	*/
	public boolean verificarHabilitacao(){
		
		if(Verificacao.getTotalAnos(getPrimeiraHabilitacao()) < 2){
			return false; //habilitação menor que 2 anos
		}
		else{
			return true; //condutor com mais de 2 anos
		}
	}

}
