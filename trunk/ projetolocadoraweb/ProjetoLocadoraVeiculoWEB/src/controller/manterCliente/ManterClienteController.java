package controller.manterCliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PessoaFisica;;

/**
 * Servlet implementation class ManterClienteController
 */
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterClienteController() {
		super();
	}

	/**
	 * No caso deste exemplo, metodo GET indica entrada no sistema
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// coloca uma lista vazia na sessao
		//
		//request.getSession().setAttribute("listaClientes",new ArrayList<PessoaFisica>());
		request.getRequestDispatcher("ClientePFConsulta.jsp").forward(request, response);
	}

	/**
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//
		// Verifica a acao do usuario.
		//

		String operacao = request.getParameter("operacao");

		try {
			if ("consultar".equals(operacao)) {
				//
				// Usuario clicou no botao 'pesquisar'
				//
				// Define parametros de busca e executa metodo pesquisar
				// da classe Cliente
				//
				PessoaFisica pf = new PessoaFisica();
				pf.setRegistro(request.getParameter("cpf"));
				//pf.setRg(request.getParameter("rg"));

				//List<PessoaFisica> retorno = new ArrayList<PessoaFisica>();
				//retorno = pf.pesquisar(); //OBS: TEM QUE COLOCAR O PESQUISAR*****************************************
				//
				// coloca o resultado na pesquisa na sesscao Web
				//
				
				request.getSession().setAttribute("listaCliente", pf.pesquisar());
				request.getRequestDispatcher("ClientePFDetalhe.jsp").forward(request,response);				

			} else if ("incluir".equals(operacao)) {
				request.getRequestDispatcher("ClientePFInclusao.jsp").forward(request,response);
				
			} else if ("salvarInclusao".equals(operacao)) {
				PessoaFisica pf = new PessoaFisica();
				pf.setNome(request.getParameter("nome"));
				pf.setRg(request.getParameter("rg"));
				pf.incluir(); //OBS: TEM QUE COLOCAR O INCLUIR*******************************************************
				
				request.getSession().setAttribute("listaCliente", new ArrayList<PessoaFisica>());				
				request.getRequestDispatcher("consulta.jsp").forward(request,response);

			} else if ("alterar".equals(request.getParameter("operacao"))) {
				// Seleciona cliente na lista para alteracao
				//
				selecionarCliente(request, response);

				request.setAttribute("operacao", "alterar");
				request.getSession().setAttribute("idCliente", Integer.parseInt(request.getParameter("item")));
				request.getRequestDispatcher("alteracao.jsp").forward(request, response);

			} else if ("salvarAlteracao".equals(request.getParameter("operacao"))) {
				PessoaFisica v = new PessoaFisica();
				v.setRegistro(request.getParameter("cpf"));
				v.setNome(request.getParameter("nome"));
				v.setRg(request.getParameter("rg"));

				v.alterar(new PessoaFisica());// IMPLENTAR O ALTERAR CORRETAMENTE**************************************
				
				request.getSession().setAttribute("listaCliente",
						new ArrayList<PessoaFisica>());
				request.getRequestDispatcher("consulta.jsp").forward(request,response);


			} else if ("detalhar".equals(request.getParameter("operacao"))) {
				selecionarCliente(request, response);

				request.getSession().setAttribute("operacao", "detalhar");
				request.getSession().setAttribute("idCliente",
						new Long(request.getParameter("item")));
				request.getRequestDispatcher("detalhe.jsp").forward(request,
						response);

			} else if ("excluir".equals(request.getParameter("operacao"))) {
				PessoaFisica pf = new PessoaFisica();
				pf.setIdPF(Integer.parseInt(request.getParameter("id")));
				pf.setNome(request.getParameter("nome"));
				pf.setRg(request.getParameter("ra"));

				pf.excluir();
				
				request.getSession().setAttribute("listaCliente",new ArrayList<PessoaFisica>());				
				request.getRequestDispatcher("ClientePFConsulta.jsp").forward(request,response);


			} else {
			
				request.getRequestDispatcher("ClientePFConsulta.jsp").forward(request,response);
			}

		} catch (Exception e) {
			trataErro(request, response, e);
		}
	}

	/**
	 * Metodo auxiliar para selecionar objeto Cliente da sessao do usuario.
	 * 
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */

	/**
	 * Metodo auxiliar para tratamento de erros
	 * 
	 * @param request
	 * @param response
	 * @param e
	 * @throws ServletException
	 * @throws IOException
	 */
	private void trataErro(HttpServletRequest request,
			HttpServletResponse response, Exception e) throws ServletException,
			IOException {
		// envia para pagina de erro
		//
		request.getSession().setAttribute("erro", e.toString());
		request.getRequestDispatcher("erro.jsp").forward(request, response);
	}

	private PessoaFisica selecionarCliente(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<PessoaFisica> retorno = null;

		PessoaFisica clienteSelecionado = null;

		//
		// Verificacao para garantir que usuario selecionou
		// um item na lista de clientes
		//
		if (request.getParameter("item") != null) {
			List<PessoaFisica> cliente = (List) request.getSession().getAttribute("listaCliente");
			int id = Integer.parseInt(request.getParameter("item"));
			for (Iterator<PessoaFisica> it = cliente.iterator(); it.hasNext();) {
				
				clienteSelecionado = (PessoaFisica) it.next();
				if (clienteSelecionado.getIdPF() == id) {
					break;
				}
			}
			request.getSession().setAttribute("clienteSelecionado", clienteSelecionado);
		}

		return clienteSelecionado;
	}

}
