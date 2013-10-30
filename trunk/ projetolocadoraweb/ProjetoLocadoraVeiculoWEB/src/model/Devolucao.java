//Classe Devolucao
package model;

import java.util.ArrayList;
import java.util.Date;

import model.dao.DaoFactoryDinamico;
import model.dao.DevolucaoDaoInterface;
import model.dao.RealizarLocacaoDao;

import util.Verificacao;

public class Devolucao {
	
	private int id;
	private Date dtaDevolucao;
	private Agencia agenciaDevolucao;
	private double total;
	private int qtdDias;
	private int kmFinalControlado;
	private Locacao locacao;
	private FormaPagamento formaPagamento;
	private ArrayList valoresAdicionais;
	
	/*
	 TABELA DE KM ENTRE CIDADES
	 				Guarulhos	Carapicuíba		Rio		Sorocaba	São Paulo
		Guarulhos		0			39.5	    425		  112			22
		Carapicuíba	   39.5			 0			460		  77.4			34.4
		Rio			   425			460			 0		  532			439
		Sorocaba	   112			77.4		532		   0			101
		São Paulo		22			34.4		439		  101			 0	  
	 */
		
	private final double[][] cidDistancia = 
		{ {0 ,	39.5 ,	425 ,	112	, 22} ,
		  {39.5 ,	0 ,	460	, 77.4 , 34.4} ,
		  {	425	, 460	, 0	, 532	,439},
		  {	112 , 77.4	, 532	, 0	, 101} ,
		  {	22	, 34.4	, 439	, 101 , 0} };
	
	private double subtotalAcrescimo;
	private double subtotalDecrescimo;
	
	public Devolucao(){
		setValoresAdicionais(new ArrayList<>());
	}
	
	public Devolucao(int id){
		setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDtaDevolucao() {
		return dtaDevolucao;
	}

	public void setDtaDevolucao(Date dtaDevolucao) {
		this.dtaDevolucao = dtaDevolucao;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Agencia getAgenciaDevolucao() {
		return agenciaDevolucao;
	}

	public void setAgenciaDevolucao(Agencia agenciaDevolucao) {
		this.agenciaDevolucao = agenciaDevolucao;
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

	public int getKmFinalControlado() {
		return kmFinalControlado;
	}

	public void setKmFinalControlado(int kmFinalControlado) {
		this.kmFinalControlado = kmFinalControlado;
	}
	
	private void calcularAcrescimo(int difDias){
		double dtaAcrescimo;
		System.out.println(difDias); //debug
		if(difDias >= 0){
			dtaAcrescimo = 0.0;
		}
		else{
			difDias = difDias * -1;
			dtaAcrescimo = calcularDifData(difDias);
		}
		
		double cidadeAcrescimo = calcularDifCidade();
		double agAcrescimo = calcularDifAgencia();
		setSubtotalAcrescimo((dtaAcrescimo + cidadeAcrescimo + agAcrescimo));
//		Atualiza os valores nos campos da View
		getValoresAdicionais().add(0, dtaAcrescimo);
		getValoresAdicionais().add(1, cidadeAcrescimo);
		getValoresAdicionais().add(2, agAcrescimo);
		
//		calcularView.setTxtDtaDevolucaoAcrescimo(dtaAcrescimo);
//		calcularView.setTxtCidadeDevolucao(cidadeAcrescimo);
//		calcularView.setTxtAgenciaDevolucao(agAcrescimo);
	}
	
//	Calcula diferença pela data prevista (30% a mais ou a menos por dia do valor da locação do automóvel)
	private double calcularDifData(int difDias){
//		int difDias = Verificacao.getDiferencaDias(devolucao.getDtaDevolucao(), devolucao.getLocacao().getDtaPrevDevolucao());
		double valor;
		valor = getLocacao().getTotal() * 0.30;
		valor = valor * (double) difDias;
		return valor;
	}
	
//	Método para Calcular a Cidade de Devolução diferente da retirada
//	Acréscimo de R$2.50 por km de distância
	private double calcularDifCidade(){
		int cidRetirada = getLocacao().getAgenciaRetirada().getIdCidade();
		int cidDevolucao = getAgenciaDevolucao().getIdCidade();
		
		if(cidRetirada == cidDevolucao){ 
			return 0.0; //Agência de devolução pertence na mesma cidade de retirada
		}else{ //Cidade de Devolução diferente da retirada
			
			double valor = cidDistancia[cidRetirada][cidDevolucao];
			return valor * 2.50;
		}
	}
	
//	Método para Calcular a Agência da Devolução diferente da retirada
//	quando na mesma cidade da retirada, Acréscimo de R$20,00
	private double calcularDifAgencia(){
		String cidRetirada = getLocacao().getAgenciaRetirada().getCidade();
		String cidDevolucao = getAgenciaDevolucao().getCidade();
		
		if(!cidRetirada.equals(cidDevolucao)){
			return 0.0;
		}
		else{
			int agRetirada = getLocacao().getAgenciaRetirada().getCodigo();
			int agDevolucao = getAgenciaDevolucao().getCodigo();
			
			if(agRetirada != agDevolucao){
				return 20.0;
			}
			else{
				return 0.0;
			}
		}
	}
	
	private void calcularDecrescimo(int difDias){
		double valor = 0.0;
		if(difDias >= 0){
			difDias = 1 * difDias;
			valor = calcularDifData(difDias);
			setSubtotalDecrescimo(valor);
			
		}
		else{
			setSubtotalDecrescimo(valor);
		}
		getValoresAdicionais().add(3, valor);
//		calcularView.setTxtDtaDevolucaoDecrescimo(valor);
	}
	
	public void calcularValAdicionais(){
		int difDias = Verificacao.getDiferencaDias(getDtaDevolucao(), getLocacao().getDtaPrevDevolucao());
		setQtdDias(difDias);
		calcularAcrescimo(difDias);
		calcularDecrescimo(difDias);
		getValoresAdicionais().add(4, getSubtotalAcrescimo());
		getValoresAdicionais().add(5, getSubtotalDecrescimo());
//		calcularView.setTxtSubTotalAcrescimo(subtotalAcrescimo);
//		calcularView.setTxtSubTotalDecrescimo(subtotalDecrescimo);
		double total = getSubtotalAcrescimo() - getSubtotalDecrescimo();
		if(getLocacao().getTipoTarifa().equals("controlado")){
			total = total + calcularKmControlado();
		}
//		calcularView.setTxtTotal(total);
		setTotal(total);
	}
	
	private double calcularKmControlado(){
		if(getLocacao().getClienteEscolhido().getTipo().equals("PF")){
			int totalKm = getKmFinalControlado() - getLocacao().getKmInicialControlado();
			return getLocacao().getVeiculoEscolhido().getGrupo().getKmExtra() * (double) totalKm;
		}else{
			int i = 0;
			double total = 0.0;
			while(i < getLocacao().getCondutores().size()){
				int totalKm = getLocacao().getCondutor(i).getKmFinalControlado() - getLocacao().getCondutor(i).getKmInicialControlado(); 
				total = total + (getLocacao().getCondutor(i).getVeiculo().getGrupo().getKmExtra() * (double) totalKm);
				i++;
			}
			return total;
		}
	}

	public double getSubtotalAcrescimo() {
		return subtotalAcrescimo;
	}

	public void setSubtotalAcrescimo(double subtotalAcrescimo) {
		this.subtotalAcrescimo = subtotalAcrescimo;
	}

	public double getSubtotalDecrescimo() {
		return subtotalDecrescimo;
	}

	public void setSubtotalDecrescimo(double subtotalDecrescimo) {
		this.subtotalDecrescimo = subtotalDecrescimo;
	}

	public ArrayList getValoresAdicionais() {
		return valoresAdicionais;
	}

	public void setValoresAdicionais(ArrayList valoresAdicionais) {
		this.valoresAdicionais = valoresAdicionais;
	}
	
	public void inserir() throws Exception {
		DevolucaoDaoInterface dao = DaoFactoryDinamico.obterDevolucaoDao();
		dao.inserir(this);
	}
	
	public int obterUltimoRegistro() throws Exception{
		DevolucaoDaoInterface dao = DaoFactoryDinamico.obterDevolucaoDao();
		return dao.obterUltimoRegistro();
	}

}
