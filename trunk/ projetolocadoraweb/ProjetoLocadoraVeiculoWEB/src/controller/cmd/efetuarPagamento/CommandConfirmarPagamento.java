package controller.cmd.efetuarPagamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DataFormatada;
import model.Cartao;
import model.Cheque;
import model.Dinheiro;
import model.FormaPagamento;
import model.Locacao;
import model.dao.LocacaoDAO;
import controller.cmd.Command;

public class CommandConfirmarPagamento extends Command {

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String nextPage = null;
		String opcao = request.getParameter("tipoPagamento");
		
		System.out.println(opcao);
		
		FormaPagamento fp = null;
		
		if("rbCartao".equals(opcao)){
			Cartao cartao = new Cartao();
			carregarObjetoCartao(request, response, cartao);
			fp = cartao;
			
		}
		else if("rbCheque".equals(opcao)){
			Cheque cheque = new Cheque();
			carregarObjetoCheque(request, response, cheque);
			fp = cheque;
						
		}
		else if("rbDinheiro".equals(opcao)){
			Dinheiro dinheiro = new Dinheiro();
			dinheiro.setTotal((Double)request.getSession().getAttribute("totalPedido"));
			fp = dinheiro;
			
		}
		
		try{
			fp.debitar();
			
			String acao = (String) request.getSession().getAttribute("acaoLocarDevolver");
			if("Locar".equals(acao)){
//				Recupera a Locação e adiciona a Forma de Pagamento
				Locacao locacao = (Locacao) request.getSession().getAttribute("locacao");
				locacao.setFormaPagamento(fp);
				
//				Criar uma Locação no Banco
				LocacaoDAO dao = new LocacaoDAO();
				dao.inserir(locacao);
				locacao.setId(dao.obterUltimoRegistro());
				request.getSession().setAttribute("locacao", locacao);
				
				nextPage = "LocacaoComprovante.jsp";
				
			}else if("Devolver".equals(acao)){
				nextPage = "LocacaoComprovante.jsp";
			}
			
		}catch(Exception e){
			nextPage = "HomePageView.jsp";
		}
		
//		return "FormaPagamento.jsp";
//		return "HomePageView.jsp";
		return nextPage;
	}
	
	
//	public void debitar(FormaPagamento formaPagamento){
//		FormaPagamentoDAO dao = new FormaPagamentoDAO();
//		dao.inserirFormaPag(formaPagamento);
//		Mensagem.pagamentoSucesso();
//		formaPagamento.setId(dao.obterUltimoRegistro());
//		pagamentoView.dispose();
//		if(getLocacao() != null){
//			getLocacao().setFormaPagamento(formaPagamento);
//			ConcluirLocacaoCtrl app = new ConcluirLocacaoCtrl(getLocacao());
//		}else{
//			if(getDevolucao() != null){
//				getDevolucao().setFormaPagamento(formaPagamento);
//				getDevolucao().setTotal( getDevolucao().getTotal() + getDevolucao().getLocacao().getTotal() );
//				ConcluirDevolucaoCtrl app = new ConcluirDevolucaoCtrl(getDevolucao());
//			}
//		}
//	}
	
	
//	private void debitar(Dinheiro dinheiro, HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		
//		FormaPagamentoPostgresDAO dao = new FormaPagamentoPostgresDAO();
//		dao.inserirFormaPag(dinheiro);
//		dinheiro.setId(dao.obterUltimoRegistro());
//		System.out.println("debitou com sucesso\n" + dinheiro.getId() );
//		request.getRequestDispatcher("FormaPagamento.jsp").forward(request, response);
//	}

	

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

//	private void debitar(Cheque cheque, HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		
//		FormaPagamentoPostgresDAO dao = new FormaPagamentoPostgresDAO();
//		dao.inserirFormaPag(cheque);
//		cheque.setId(dao.obterUltimoRegistro());
//		System.out.println("debitou com sucesso\n" + cheque.getId() );
//		request.getRequestDispatcher("FormaPagamento.jsp").forward(request, response);
//		
//	}
	
	

//	private void debitar(Cartao cartao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
////		IMPLEMENTAR A LEITURA DE ARQUIVO POSTERIORMENTE
//		
////		SistemaCartaoCreditoImpl sistemaCartao = new SistemaCartaoCreditoImpl();
////		if(!sistemaCartao.debitar(cartao)){
////			System.out.println("n�o foi poss�vel debitar o cart�o");
////		}
////		else{
//		FormaPagamentoPostgresDAO dao = new FormaPagamentoPostgresDAO();
//		dao.inserirFormaPag(cartao);
//		cartao.setId(dao.obterUltimoRegistro());
//		System.out.println("debitou com sucesso\n" + cartao.getId() );
////		}
//				
//		request.getRequestDispatcher("FormaPagamento.jsp").forward(request, response);
//	}
	
//	M�todo respons�vel por carregar um objeto Cart�o do .jsp
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
		 * DATA EST� VINDO DO JSP NO FORMATO yyyy-MM-dd
		 * tem q ser tratado no formato dd-MM-yyyy
		 * */
		cartao.setDtaValidade(DataFormatada.parseDataSimples(
								request.getParameter("txtDtaValidadeCartao")));
//		----BUG----
				
		cartao.setCodSeguranca(request.getParameter("txtCodSegCartao"));
	}//fim do m�todo carregarObjetoCartao()
	
}
