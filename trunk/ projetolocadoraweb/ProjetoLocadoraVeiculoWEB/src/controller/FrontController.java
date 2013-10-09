package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agencia;
import model.dao.AgenciaDAO;

import controller.cmd.Command;
import controller.cmd.CommandFactory;

/**
 * Servlet implementation class FrontController
 */

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("protected/HomePageView.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		// Verifica a acao do usuario.
		//

		String operacao = request.getParameter("operacao");
		System.out.println(operacao);
		try {
			Command cmd = CommandFactory.obterCommand(operacao);
			String paginaDestino = "protected/" + cmd.executar(request, response);
			
			request.getRequestDispatcher(paginaDestino).forward(request,response);

		} catch (Exception e) {
			// tratamento de erro
			//
			trataErro(request, response, e);
		}
	}
	
	private void trataErro(HttpServletRequest request,
			HttpServletResponse response, Exception e) throws ServletException,
			IOException {
		// envia para pagina de erro
		//
		request.getSession().setAttribute("erro", e.toString());
		request.getSession().setAttribute("errorTitle", "Front Controller Error");
		request.getRequestDispatcher("ManterVeiculoErro.jsp").forward(request, response);
	}
	

}
