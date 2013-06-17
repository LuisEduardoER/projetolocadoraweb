package controller.homePage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agencia;

public class HomePageController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public HomePageController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("HomePageView.jsp");
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("operacao");

		try {
			if ("Manter Veiculo".equals(operacao)) {
				response.sendRedirect("manterVeiculo");
			}
			else if("Realizar Locacao".equals(operacao)){
				response.sendRedirect("realizarLocacao");
			}
			
		} catch (Exception e) {
			trataErro(request, response, e);
		}
	
	}

	private void trataErro(HttpServletRequest request,
			HttpServletResponse response, Exception e) {
				
	}
	
}
