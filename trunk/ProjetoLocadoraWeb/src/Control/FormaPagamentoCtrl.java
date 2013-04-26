//Classe FormaPagamentoCtrl
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.Cartao;
import model.Cheque;
import model.Devolucao;
import model.Dinheiro;
import model.Locacao;
import model.SistemaCartaoCreditoImpl;
import model.Dao.FormaPagamentoDAO;

import Control.DevolverVeiculo.CalcularDevolucaoCtrl;
import Control.DevolverVeiculo.ConcluirDevolucaoCtrl;
import Control.RealizarLocacao.CalcularLocacaoCtrl;
import Control.RealizarLocacao.ConcluirLocacaoCtrl;
import View.Mensagens.Mensagem;

public class FormaPagamentoCtrl extends PagamentoCtrl{
	
	private Cartao cartao;
	private Cheque cheque;
	private Dinheiro dinheiro;
	private double total;
	
	
	
	public FormaPagamentoCtrl(double total){
		super(total);
		adicionandoListener();
		setTotal(total);
	}


	public FormaPagamentoCtrl(Locacao locacao) {
		super(locacao.getTotal());
		adicionandoListener();
		setLocacao(locacao);
		setTotal(locacao.getTotal());
	}


	public FormaPagamentoCtrl(Devolucao devolucao) {
		super(devolucao.getTotal());
		adicionandoListener();
		setDevolucao(devolucao);
		setTotal(devolucao.getTotal());
	}


	private void adicionandoListener() {
		pagamentoView.addBtConfirmarListener(new ConfirmarListener());
		pagamentoView.addBtVoltarListener(new VoltarListener());
		pagamentoView.addRadioButtonListener(new RadioButtonsListener());
	}
	
	class ConfirmarListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(pagamentoView.getRbCartao().isSelected()){
				if(!carregarValoresCartao()){
//					Não foi possível adicionar o pagamento
				}
				else{ 
					debitar(cartao);
				}
			}
			if(pagamentoView.getRbCheque().isSelected()){
				if(!carregarValoresCheque()){
//					Não foi possível adicionar o pagamento
				}
				else{ 
					debitar(cheque);
				}
			}
			if(pagamentoView.getRbDinheiro().isSelected()){
				debitar(dinheiro);
			}
			
		}

				
	}
	
	class VoltarListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(getLocacao() != null){
				CalcularLocacaoCtrl calcularLocacao = new CalcularLocacaoCtrl(getLocacao());
				pagamentoView.dispose();
			}else{
				if(getDevolucao() != null){
					CalcularDevolucaoCtrl calcularDevolucao = new CalcularDevolucaoCtrl(getDevolucao());
					pagamentoView.dispose();
				}
			}
			
		}
	}
	
	class RadioButtonsListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent ev) {
			if(ev.getSource() == pagamentoView.getRbCartao()){
				pagamentoView.habilitarCamposCartao();
				pagamentoView.desabilitarCamposCheque();
			}
			if(ev.getSource() == pagamentoView.getRbCheque()){
				pagamentoView.habilitarCamposCheque();
				pagamentoView.desabilitarCamposCartao();
			}
			if(ev.getSource() == pagamentoView.getRbDinheiro()){
				pagamentoView.desabilitarCamposCheque();
				pagamentoView.desabilitarCamposCartao();
			}
		}
	}
	
//	=========================================
//	MÉTODO DE NEGÓCIO - ADICIONAR PAGAMENTO - CHEQUE
	public void debitar(Cheque cheque) {
		int op = Mensagem.desejaInserirPagamento();
		if(op == 0){
			FormaPagamentoDAO dao = new FormaPagamentoDAO();
			dao.inserirFormaPag(cheque);
			Mensagem.pagamentoSucesso();
			cheque.setId(dao.obterUltimoRegistro());
			
			if(getLocacao() != null){
				getLocacao().setFormaPagamento(cheque);
				pagamentoView.dispose();
				ConcluirLocacaoCtrl app = new ConcluirLocacaoCtrl(getLocacao());
			}else{
				if(getDevolucao() != null){
					getDevolucao().setFormaPagamento(cheque);
					getDevolucao().setTotal( getDevolucao().getTotal() + getDevolucao().getLocacao().getTotal() );
					pagamentoView.dispose();
					ConcluirDevolucaoCtrl app = new ConcluirDevolucaoCtrl(getDevolucao());
				}
			}
		}
	}
//	=========================================
	
//	=========================================
//	MÉTODO DE NEGÓCIO - ADICIONAR PAGAMENTO - DINHEIRO
	public void debitar(Dinheiro dinheiro) {
		int op = Mensagem.desejaInserirPagamento();
		if(op == 0){
			dinheiro = new Dinheiro();
			dinheiro.setTotal(getTotal());
			super.debitar(dinheiro);
		}
	}
//	=========================================

//	=========================================
//	MÉTODO DE NEGÓCIO - ADICIONAR PAGAMENTO - CARTÃO
	public void debitar(Cartao cartao) {
		int op = Mensagem.desejaInserirPagamento();
		if(op == 0){
			SistemaCartaoCreditoImpl sistemaCartao = new SistemaCartaoCreditoImpl();
			if(!sistemaCartao.debitar(cartao)){
				Mensagem.impossivelConcluirCartao();
			}
			else{
				super.debitar(cartao);
			}
		}
		
	}
//	=========================================
	
	
	
	private boolean carregarValoresCartao(){
		if(!pagamentoView.verificaCamposBrancoCartao()){
			cartao = new Cartao();
			cartao.setTotal(getTotal());
			cartao.setTipo(pagamentoView.getTxtTipoCartao());
			cartao.setNomeCliente(pagamentoView.getTxtNomeCliCartao());
			cartao.setCpf(pagamentoView.getTxtCpfCartao());
			cartao.setNumCartao(pagamentoView.getTxtNroCartao());
			cartao.setDtaValidade(pagamentoView.getTxtDtaValidadeCartao());
			cartao.setCodSegurança(pagamentoView.getTxtCodSegCartao());
			
			return true;
		}else{
			Mensagem.temCampoBranco();
			return false;
		}
	}
	
	private boolean carregarValoresCheque(){
		if(!pagamentoView.verificaCamposBrancoCheque()){
			cheque = new Cheque();
			cheque.setTotal(getTotal());
			cheque.setNomeBanco(pagamentoView.getTxtNomeBanco());
			cheque.setNumAgencia(pagamentoView.getTxtNroAgencia());
			cheque.setNumCCO(pagamentoView.getTxtCcoBanco());
			cheque.setNomeTitular(pagamentoView.getTxtNomeCliBanco());
			cheque.setCpfTitular(pagamentoView.getTxtCpfBanco());
			cheque.setFoneTitular(pagamentoView.getTxtFoneBanco());
			
			return true;
		}else{
			Mensagem.temCampoBranco();
			return false;
		}		
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
		
}
