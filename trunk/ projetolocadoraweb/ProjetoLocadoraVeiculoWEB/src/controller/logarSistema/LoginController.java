package controller.logarSistema;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Agencia;
import model.Usuario;
import model.dao.AgenciaDAO;
import model.dao.UsuarioDAO;

/**
 * Servlet implementation class LoginCtrl
 */
//@WebServlet(description = "Classe de Controle do caso de uso logar", urlPatterns = { "/LoginCtrl" })
public class LoginController extends HttpServlet {
	
	private Usuario user;
	private Agencia agencia = null;
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Pega uma lista de Agencias para o Tela de Login
		AgenciaDAO dao = new AgenciaDAO();
		ArrayList<Agencia> agencias = dao.getList();
		
		//ArrayList de agencias como parametro para a tela de login
		request.getSession().setAttribute("listaAgencias", agencias);
		//Instalcia Login View
		request.getRequestDispatcher("LoginView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		user = new Usuario();
		user.setLogin(request.getParameter("usuario"));
		user.setSenha(request.getParameter("senha"));
		if(verificaLogin() == true){

			agencia = new Agencia();
			agencia.setCodigo(Integer.parseInt(request.getParameter("cbAgencia")));
			
			request.getSession().setAttribute("agenciaSelecionada",agencia);
			request.getSession().setAttribute("isError",false);
			response.sendRedirect("homePage"); //Passar de um controle para o outro.(chama o get do outro)
		}
		else{
			System.out.println("login invalido");
			response.sendRedirect("LoginView.jsp");
		}
		
	}
		
	public boolean verificaLogin(){
		UsuarioDAO dao = new UsuarioDAO();
	
		boolean isCorrect = false;
		
		Usuario usuario = dao.verificaLogin(user);
		
		if(usuario != null){
			user = usuario;
			isCorrect = true;
		}
		return isCorrect;
	}
}