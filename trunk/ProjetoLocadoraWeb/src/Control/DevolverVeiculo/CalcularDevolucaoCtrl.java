//Classe CalcularDevolucaoCtrl
package Control.DevolverVeiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import Model.Agencia;
import Model.Devolucao;
import Model.Locacao;
import Control.FormaPagamentoCtrl;
import Util.Conversao;
import Util.Verificacao;
import View.DevolucaoValAdicionaisView;
import View.Mensagens.Mensagem;

public class CalcularDevolucaoCtrl {
	
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
	
	
	private Devolucao devolucao;
	private DevolucaoValAdicionaisView calcularView;
	private double subtotalAcrescimo;
	private double subtotalDecrescimo;
	
	public CalcularDevolucaoCtrl(Locacao locacao , Agencia agencia) {
		
		devolucao = new Devolucao();
		devolucao.setAgenciaDevolucao(agencia);
		devolucao.setDtaDevolucao(new Date());
		devolucao.setLocacao(locacao);
		calcularView = new DevolucaoValAdicionaisView();
		adicionarListener();
		carregarCamposSuperior();
		calcularValAdicionais();
	}
	
	public CalcularDevolucaoCtrl(Devolucao devolucao){
		this.devolucao = devolucao;
		calcularView = new DevolucaoValAdicionaisView();
		adicionarListener();
		carregarCamposSuperior();
		calcularValAdicionais();
	}
	
	
	private void adicionarListener(){
		calcularView.addBtAvancarListener(new AvancarListener());
		calcularView.addBtVoltarListener(new VoltarListener());
	}
	
	class AvancarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			devolver();
			calcularView.dispose();
		}
	}
	
	class VoltarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			DevolverLocacaoCtrl devolverLocacao = new DevolverLocacaoCtrl(devolucao.getAgenciaDevolucao());
			calcularView.dispose();
		}
	}
	
	public void carregarCamposSuperior(){
		calcularView.setTxtIdLocacao(devolucao.getLocacao().getId());
		calcularView.setTxtNomeCliente(devolucao.getLocacao().getClienteEscolhido().getNome());
		calcularView.setTxtCnpj(devolucao.getLocacao().getClienteEscolhido().getRegistro());
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
		subtotalAcrescimo = (dtaAcrescimo + cidadeAcrescimo + agAcrescimo);
//		Atualiza os valores nos campos da View
		calcularView.setTxtDtaDevolucaoAcrescimo(dtaAcrescimo);
		calcularView.setTxtCidadeDevolucao(cidadeAcrescimo);
		calcularView.setTxtAgenciaDevolucao(agAcrescimo);
	}
	
//	Calcula diferença pela data prevista (30% a mais ou a menos por dia do valor da locação do automóvel)
	private double calcularDifData(int difDias){
//		int difDias = Verificacao.getDiferencaDias(devolucao.getDtaDevolucao(), devolucao.getLocacao().getDtaPrevDevolucao());
		double valor;
		valor = devolucao.getLocacao().getTotal() * 0.30;
		valor = valor * (double) difDias;
		return valor;
	}
	
//	Método para Calcular a Cidade de Devolução diferente da retirada
//	Acréscimo de R$2.50 por km de distância
	private double calcularDifCidade(){
		int cidRetirada = devolucao.getLocacao().getAgenciaRetirada().getIdCidade();
		int cidDevolucao = devolucao.getAgenciaDevolucao().getIdCidade();
		
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
		String cidRetirada = devolucao.getLocacao().getAgenciaRetirada().getCidade();
		String cidDevolucao = devolucao.getAgenciaDevolucao().getCidade();
		
		if(!cidRetirada.equals(cidDevolucao)){
			return 0.0;
		}
		else{
			int agRetirada = devolucao.getLocacao().getAgenciaRetirada().getCodigo();
			int agDevolucao = devolucao.getAgenciaDevolucao().getCodigo();
			
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
			subtotalDecrescimo = valor;
			
		}
		else{
			subtotalDecrescimo = valor;
		}
		calcularView.setTxtDtaDevolucaoDecrescimo(valor);
	}
	
	private void calcularValAdicionais(){
		int difDias = Verificacao.getDiferencaDias(devolucao.getDtaDevolucao(), devolucao.getLocacao().getDtaPrevDevolucao());
		devolucao.setQtdDias(difDias);
		calcularAcrescimo(difDias);
		calcularDecrescimo(difDias);
		calcularView.setTxtSubTotalAcrescimo(subtotalAcrescimo);
		calcularView.setTxtSubTotalDecrescimo(subtotalDecrescimo);
		double total = subtotalAcrescimo - subtotalDecrescimo;
		if(devolucao.getLocacao().getTipoTarifa().equals("controlado")){
			total = total + calcularKmControlado();
		}
		calcularView.setTxtTotal(total);
		devolucao.setTotal(total);
	}
	
	private void devolver(){
		if(devolucao.getTotal() < 0.0){
			String valor = Conversao.formatDouble( (-1 * devolucao.getTotal()) );
			Mensagem.retornarTroco(valor);
			devolucao.setTotal( devolucao.getTotal() + devolucao.getLocacao().getTotal() );
			ConcluirDevolucaoCtrl concluirDevolucao = new ConcluirDevolucaoCtrl(devolucao);
		}
		else{
			if(devolucao.getTotal() == 0.0){
				devolucao.setTotal( devolucao.getTotal() + devolucao.getLocacao().getTotal() );
				ConcluirDevolucaoCtrl concluirDevolucao = new ConcluirDevolucaoCtrl(devolucao);
			}
			else{
				FormaPagamentoCtrl pagamentoCtrl = new FormaPagamentoCtrl(devolucao);
				
			}
		}	
	}
	
	private double calcularKmControlado(){
		if(devolucao.getLocacao().getClienteEscolhido().getTipo().equals("PF")){
			int totalKm = devolucao.getKmFinalControlado() - devolucao.getLocacao().getKmInicialControlado();
			return devolucao.getLocacao().getVeiculoEscolhido().getGrupo().getKmExtra() * (double) totalKm;
		}else{
			int i = 0;
			double total = 0.0;
			while(i < devolucao.getLocacao().getCondutores().size()){
				int totalKm = devolucao.getLocacao().getCondutor(i).getKmFinalControlado() - devolucao.getLocacao().getCondutor(i).getKmInicialControlado(); 
				total = total + (devolucao.getLocacao().getCondutor(i).getVeiculo().getGrupo().getKmExtra() * (double) totalKm);
				i++;
			}
			return total;
		}
	}
}
