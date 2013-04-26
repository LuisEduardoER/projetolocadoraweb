//Classe PagamentoCtrl
package Control;

import model.Devolucao;
import model.FormaPagamento;
import model.Locacao;
import model.Dao.FormaPagamentoDAO;
import Control.DevolverVeiculo.ConcluirDevolucaoCtrl;
import Control.RealizarLocacao.ConcluirLocacaoCtrl;
import View.FormaPagamentoView;
import View.Mensagens.Mensagem;

public abstract class PagamentoCtrl {
	
	protected FormaPagamentoView pagamentoView;
	private Locacao locacao = null;
	private Devolucao devolucao = null;
	
	public PagamentoCtrl(double total){
		pagamentoView = new FormaPagamentoView();
		pagamentoView.setTxtTotal(total);
	}
	
	public PagamentoCtrl(){
		
	}
	
	public void debitar(FormaPagamento formaPagamento){
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		dao.inserirFormaPag(formaPagamento);
		Mensagem.pagamentoSucesso();
		formaPagamento.setId(dao.obterUltimoRegistro());
		pagamentoView.dispose();
		if(getLocacao() != null){
			getLocacao().setFormaPagamento(formaPagamento);
			ConcluirLocacaoCtrl app = new ConcluirLocacaoCtrl(getLocacao());
		}else{
			if(getDevolucao() != null){
				getDevolucao().setFormaPagamento(formaPagamento);
				getDevolucao().setTotal( getDevolucao().getTotal() + getDevolucao().getLocacao().getTotal() );
				ConcluirDevolucaoCtrl app = new ConcluirDevolucaoCtrl(getDevolucao());
			}
		}
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Devolucao getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}
	
}
