//Classe TarifaControladaCtrl
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import Model.Devolucao;
import Model.Locacao;

import Control.DevolverVeiculo.CalcularDevolucaoCtrl;
import Control.DevolverVeiculo.DevolverLocacaoCtrl;
import Control.RealizarLocacao.CalcularLocacaoCtrl;
import Control.RealizarLocacao.RealizarLocacaoCtrl;
import View.TarifaControladaView;
import View.Mensagens.Mensagem;

public class TarifaControladaCtrl {
	
	private TarifaControladaView view;
	private Locacao locacao = null;
	private Devolucao devolucao = null;
	// Obtem o modelo da JTable  
	private DefaultTableModel modelo;
	
	public TarifaControladaCtrl(){
		
	}
	
	public TarifaControladaCtrl(Locacao locacao){
		this.locacao = locacao;
		view = new TarifaControladaView();
		adicionarListener();
		modelo = (DefaultTableModel) view.getTabela().getModel();
		preencheTableLocacao();
		
	}
	
	public TarifaControladaCtrl(Devolucao devolucao) {
		this.devolucao = devolucao;
		view = new TarifaControladaView();
		adicionarListener();
		modelo = (DefaultTableModel) view.getTabela().getModel();
		preencheTableDevolucao();
		
	}

	private void adicionarListener(){
		view.addBtVoltarListener(new VoltarListener());
		view.addBtConcluirListener(new ConcluirListener());
	}
	
	class VoltarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			view.dispose();
			if(locacao != null){
				RealizarLocacaoCtrl locacaoCtrl = new RealizarLocacaoCtrl(locacao);
			}else{
				if(devolucao != null){
					DevolverLocacaoCtrl devolverCtrl = new DevolverLocacaoCtrl(devolucao.getAgenciaDevolucao());
				}
			}
		}
		
	}
	
	class ConcluirListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(locacao != null){
				concluirLocacao();
			}
			else{
				if(devolucao != null){
					concluirDevolucao();
				}
			}
			
		}
		
	}
	
	public void preencheTableLocacao(){
		if(locacao.getClienteEscolhido().getTipo().equals("PF")){
			modelo.addRow(new Object [] { locacao.getClienteEscolhido().getNome() ,
										  locacao.getVeiculoEscolhido().getModelo()});
		}else{
			int i = 0;
			while(i < locacao.getCondutores().size()){
				modelo.addRow(new Object [] { locacao.getCondutor(i).getPf().getNome() ,
						  locacao.getCondutor(i).getVeiculo().getModelo()});
				i++;
			}
		}
	}
	
	public void preencheTableDevolucao(){
		if(devolucao.getLocacao().getClienteEscolhido().getTipo().equals("PF")){
			modelo.addRow(new Object [] { devolucao.getLocacao().getClienteEscolhido().getNome() ,
					devolucao.getLocacao().getVeiculoEscolhido().getModelo() , 
					devolucao.getLocacao().getKmInicialControlado()});
		}else{
			int i = 0;
			while(i < devolucao.getLocacao().getCondutores().size()){
				modelo.addRow(new Object [] { devolucao.getLocacao().getCondutor(i).getPf().getNome() ,
						devolucao.getLocacao().getCondutor(i).getVeiculo().getModelo() , 
						devolucao.getLocacao().getCondutor(i).getKmInicialControlado()});
				System.out.println(i);
				System.out.println(devolucao.getLocacao().getCondutores().size());
				i++;
				
			}
		}
	}
	
	public void concluirLocacao(){
		if(locacao.getClienteEscolhido().getTipo().equals("PF")){
			try{
				int valor = getValor(0, 2);
				locacao.setKmInicialControlado(valor);
				CalcularLocacaoCtrl calcularLocacao = new CalcularLocacaoCtrl(locacao);
				view.dispose();
			
			}catch(Exception e){
				Mensagem.temCampoBranco();
			}
		}else{
			try{
				int i = 0;
				while(i < locacao.getCondutores().size()){
					int valor = getValor(i, 2);
					locacao.getCondutor(i).setKmInicialControlado(valor);
					i++;
				}
				CalcularLocacaoCtrl calcularLocacao = new CalcularLocacaoCtrl(locacao);
				view.dispose();
			}catch(Exception e){
				Mensagem.temCampoBranco();
			}
		}
	}
	
	public void concluirDevolucao(){
		if(devolucao.getLocacao().getClienteEscolhido().getTipo().equals("PF")){
			try{
				int valor = getValor(0, 3);
				devolucao.setKmFinalControlado(valor);
				CalcularDevolucaoCtrl calcularLocacao = new CalcularDevolucaoCtrl(devolucao);
				view.dispose();
			
			}catch(Exception e){
				Mensagem.temCampoBranco();
			}
		}else{
			try{
				int i = 0;
				while(i < devolucao.getLocacao().getCondutores().size()){
					int valor = getValor(i, 3);
					devolucao.getLocacao().getCondutor(i).setKmFinalControlado(valor);
					i++;
				}
				CalcularDevolucaoCtrl calcularLocacao = new CalcularDevolucaoCtrl(devolucao);
				view.dispose();
			}catch(Exception e){
				Mensagem.temCampoBranco();
			}
		}
	}
	
	
	private int getValor(int row , int column){
		return Integer.parseInt((String) modelo.getValueAt(row, column));
	}
}
