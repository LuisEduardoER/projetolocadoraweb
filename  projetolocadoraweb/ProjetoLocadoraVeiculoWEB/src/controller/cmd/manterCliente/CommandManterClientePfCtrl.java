package controller.cmd.manterCliente;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.cmd.Command;

import model.PessoaFisica;

public class CommandManterClientePfCtrl extends Command{

	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Metodo responsavel por selecionar um cliente
		
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
	protected void trataErro(HttpServletRequest request,
			HttpServletResponse response, Exception e) throws ServletException,
			IOException {
		// envia para pagina de erro
		//
		request.getSession().setAttribute("erro", e.toString());
		request.getRequestDispatcher("erro.jsp").forward(request, response);
	}

	protected PessoaFisica selecionarCliente(HttpServletRequest request,
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
