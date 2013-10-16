//Classe Locacao
package model;

import java.util.ArrayList;
import java.util.Date;

import model.dao.DaoFactoryDinamico;
import model.dao.RealizarLocacaoDao;


public class Locacao {
	private int id;
	private String tipoTarifa;
	private Date dtaRetirada;
	private Date dtaPrevDevolucao;
	private double total;
	private int qtdDias;
	private Integer kmInicialControlado;
	private Agencia agenciaRetirada;
	private Agencia agenciaDevolucao;
	private Cliente clienteEscolhido;
	private Veiculo veiculoEscolhido;
	private FormaPagamento formaPagamento;
	private ArrayList<Condutor> condutores;
	
//	Método Construtor
//	Instancia os objs
	public Locacao(){
		condutores = new ArrayList<Condutor>();
		setAgenciaDevolucao(new Agencia());
		setAgenciaRetirada( new Agencia());
		setClienteEscolhido(new Cliente());
		setFormaPagamento(null);
		setVeiculoEscolhido(new Veiculo());
		setId(0);
		setTipoTarifa("");
		setDtaRetirada(new Date());
		setDtaPrevDevolucao(new Date());
		setTotal(0.0);
		setQtdDias(0);
		setKmInicialControlado(0);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipoTarifa() {
		return tipoTarifa;
	}
	
	public void setTipoTarifa(String tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}
	
	public Date getDtaRetirada() {
		return dtaRetirada;
	}
	
	public void setDtaRetirada(Date dtaRetirada) {
		this.dtaRetirada = dtaRetirada;
	}
	
	public Date getDtaPrevDevolucao() {
		return dtaPrevDevolucao;
	}
	
	public void setDtaPrevDevolucao(Date dtaPrevDevolucao) {
		this.dtaPrevDevolucao = dtaPrevDevolucao;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Agencia getAgenciaRetirada() {
		return agenciaRetirada;
	}
	
	public void setAgenciaRetirada(Agencia agenciaRetirada) {
		this.agenciaRetirada = agenciaRetirada;
	}
	
	public Agencia getAgenciaDevolucao() {
		return agenciaDevolucao;
	}
	
	public void setAgenciaDevolucao(Agencia agenciaDevolucao) {
		this.agenciaDevolucao = agenciaDevolucao;
	}
	
	public Cliente getClienteEscolhido() {
		return clienteEscolhido;
	}
	
	public void setClienteEscolhido(Cliente clienteEscolhido) {
		this.clienteEscolhido = clienteEscolhido;
	}
	
	public Veiculo getVeiculoEscolhido() {
		return veiculoEscolhido;
	}
	
	public void setVeiculoEscolhido(Veiculo veiculoEscolhido) {
		this.veiculoEscolhido = veiculoEscolhido;
	}
	
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}
	
	public String toString(){
		
		return getAgenciaDevolucao().getNome() + "\n" +
				getId() + "\n" + getTipoTarifa() + "\n" +
				getTotal() + "\n" + getAgenciaRetirada().getNome() + "\n" +
				getClienteEscolhido().getNome() + "\n" + getDtaPrevDevolucao().toString() + "\n" +
				getDtaRetirada().toString() + "\n" + getFormaPagamento().getTotal() + "\n" + getVeiculoEscolhido().getModelo();
	}

	public int getKmInicialControlado() {
		return kmInicialControlado;
	}

	public void setKmInicialControlado(int kmInicialControlado) {
		this.kmInicialControlado = kmInicialControlado;
	}

	public ArrayList<Condutor> getCondutores() {
		return condutores;
	}

	public void setCondutores(ArrayList<Condutor> condutores) {
		this.condutores = condutores;
	}
	
	public void addCondutor(Condutor condutor){
		this.condutores.add(condutor);
	}
	
	public Condutor getCondutor(int i){
		return condutores.get(i);
	}
	
//	Método de Negócio
//	Calcular Total da Locação
	
	public double calcularTotal(){
		if(getTipoTarifa().equals("livre")){
			setTotal(calcularTotalTarifaLivre());
		}
		else{
			setTotal(calcularTotalTarifaControlada());
		}
		return getTotal();
	}
	

	private double calcularTotalTarifaLivre() {
//		valor veiculo(s) escolhido(s)
//		qtd de dias
//		tipo de tarifa - ok
		
		double valorVeiculo = getVeiculoEscolhido().getGrupo().getTarifaLivre();
//		int qtdDias = calculaQtdDias();
		if(getQtdDias() < 7){
			valorVeiculo = valorVeiculo * (double) getQtdDias();
		}else{
			valorVeiculo = getVeiculoEscolhido().getGrupo().getDiaExtra() * getQtdDias();
		}
		valorVeiculo = valorVeiculo + getVeiculoEscolhido().getTotalAcessorios();
		return valorVeiculo;
	}

	private double calcularTotalTarifaControlada() {
		
		double valorVeiculo = getVeiculoEscolhido().getGrupo().getTarifaControloda();
		valorVeiculo = valorVeiculo * (double) getQtdDias();
		valorVeiculo = valorVeiculo + getVeiculoEscolhido().getTotalAcessorios();
		
		return valorVeiculo;
		
	}
	
	public void inserir() throws Exception {
		RealizarLocacaoDao dao = DaoFactoryDinamico.obterLocacaoDao();
		dao.inserir(this);
	}
	
	public int obterUltimoRegistro() throws Exception{
		RealizarLocacaoDao dao = DaoFactoryDinamico.obterLocacaoDao();
		return dao.obterUltimoRegistro();
	}
	
	public boolean isDevolvido(int idLocacao){
		RealizarLocacaoDao dao = DaoFactoryDinamico.obterLocacaoDao();
		return dao.isDevolvido(idLocacao);
	}
	
	public Locacao consultar(int id){
		RealizarLocacaoDao dao = DaoFactoryDinamico.obterLocacaoDao();
		return dao.consultar(id);
	}
	
	public ArrayList<Integer> consultaLocacao(String registro){
		RealizarLocacaoDao dao = DaoFactoryDinamico.obterLocacaoDao();
		return dao.consultaLocacao(registro);
	}
	
}
