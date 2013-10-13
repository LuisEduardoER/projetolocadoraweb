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
