package controller.efetuarPagamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DataFormatada;

import model.Cartao;
import model.Cheque;
import model.Dinheiro;
//import Control.DevolverVeiculo.ConcluirDevolucaoCtrl;
//import Control.RealizarLocacao.ConcluirLocacaoCtrl;
import model.FormaPagamento;
import model.Grupo;
import model.SistemaCartaoCreditoImpl;
import model.Veiculo;
import model.dao.FormaPagamentoDAO;
//import Model.Cartao;
//import Model.Cheque;
//import Model.Dinheiro;
//import Model.SistemaCartaoCreditoImpl;
//import View.FormaPagamentoView;
//import View.Mensagens.Mensagem;

/**
 * Servlet implementation class FormaPagamentoController
 */
public class FormaPagamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormaPagamentoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double total = 321;
		request.getSession().setAttribute("totalPedido", total);
		response.sendRedirect("FormaPagamento.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("operacao");
		
		try {
			if ("Confirmar".equals(operacao)) {
//				response.sendRedirect("manterVeiculo");
				
				String opcao = request.getParameter("tipoPagamento"); 
				
				System.out.println(opcao);
				
				if("rbCartao".equals(opcao)){
					Cartao cartao = new Cartao();
					carregarObjetoCartao(request, response, cartao);
					debitar(cartao , request , response);

				}
				else if("rbCheque".equals(opcao)){
					Cheque cheque = new Cheque();
					carregarObjetoCheque(request, response, cheque);
										
					debitar(cheque , request , response);
					
				}
				else if("rbDinheiro".equals(opcao)){
					Dinheiro dinheiro = new Dinheiro();
					dinheiro.setTotal((Double)request.getSession().getAttribute("totalPedido"));
					debitar(dinheiro , request , response);
				}
				
				
//				request.getRequestDispatcher("FormaPagamento.jsp").forward(request, response);
				
			}
			else if("Voltar".equals(operacao)){
				
			}
			
		} catch (Exception e) {
			trataErro(request, response, e);
		}
		
	}
	
	
	private void debitar(Dinheiro dinheiro, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		dao.inserirFormaPag(dinheiro);
		dinheiro.setId(dao.obterUltimoRegistro());
		System.out.println("debitou com sucesso\n" + dinheiro.getId() );
		request.getRequestDispatcher("FormaPagamento.jsp").forward(request, response);
	}

	

	private void carregarObjetoCheque(HttpServletRequest request,
			HttpServletResponse response, Cheque cheque) {
		
		cheque.setTotal((Double)request.getSession().getAttribute("totalPedido"));
		cheque.setNomeBanco(request.getParameter("txtNomeBanco"));
		cheque.setNumAgencia(request.getParameter("txtNroAgencia"));
		cheque.setNumCCO(request.getParameter("txtCcoBanco"));
		cheque.setNomeTitular(request.getParameter("txtNomeCliBanco"));
		cheque.setCpfTitular(request.getParameter("txtCpfBanco"));
		cheque.setFoneTitular(request.getParameter("txtFoneBanco"));
				
	}

	private void debitar(Cheque cheque, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		dao.inserirFormaPag(cheque);
		cheque.setId(dao.obterUltimoRegistro());
		System.out.println("debitou com sucesso\n" + cheque.getId() );
		request.getRequestDispatcher("FormaPagamento.jsp").forward(request, response);
		
	}
	
	

	private void debitar(Cartao cartao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		IMPLEMENTAR A LEITURA DE ARQUIVO POSTERIORMENTE
		
//		SistemaCartaoCreditoImpl sistemaCartao = new SistemaCartaoCreditoImpl();
//		if(!sistemaCartao.debitar(cartao)){
//			System.out.println("não foi possível debitar o cartão");
//		}
//		else{
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		dao.inserirFormaPag(cartao);
		cartao.setId(dao.obterUltimoRegistro());
		System.out.println("debitou com sucesso\n" + cartao.getId() );
//		}
				
		request.getRequestDispatcher("FormaPagamento.jsp").forward(request, response);
	}
	
	
	
	
	private void trataErro(HttpServletRequest request,
			HttpServletResponse response, Exception e) {
		
		
	}
	
	
//	Método responsável por carregar um objeto Cartão do .jsp
	private void carregarObjetoCartao(HttpServletRequest request,
			HttpServletResponse response, Cartao cartao) {
		
//		cartao = new Cartao();
		cartao.setTotal((Double)request.getSession().getAttribute("totalPedido"));
		cartao.setTipo(request.getParameter("txtTipoCartao"));
		cartao.setNomeCliente(request.getParameter("txtNomeCliCartao"));
		cartao.setCpf(request.getParameter("txtCpfCartao"));
		cartao.setNumCartao(request.getParameter("txtNroCartao"));
		
//		RESOLVER O BUG DA DATA
		/*
		 * DATA ESTÁ VINDO DO JSP NO FORMATO yyyy-MM-dd
		 * tem q ser tratado no formato dd-MM-yyyy
		 * */
		cartao.setDtaValidade(DataFormatada.parseDataSimples(
								request.getParameter("txtDtaValidadeCartao")));
//		----BUG----
				
		cartao.setCodSeguranca(request.getParameter("txtCodSegCartao"));
	}//fim do método carregarObjetoCartao()
	
	
	/*
	public PagamentoCtrl(double total){
		pagamentoView = new FormaPagamentoView();
		pagamentoView.setTxtTotal(total);
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

	*/

}
