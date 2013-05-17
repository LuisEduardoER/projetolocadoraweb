package controller.manterVeiculo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.postgresql.util.PSQLException;

import java.util.ArrayList;
import model.Agencia;
import model.Grupo;
import model.Veiculo;
import model.dao.VeiculoDAO;

//import br.usjt.arqdesis.tutorial.model.Aluno;

/**
 * Servlet implementation class ManterVeiculoController
 */

public class ManterVeiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Agencia agencia;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterVeiculoController() {
        super();
//        agencia = new Agencia(1);
//        agencia.setCodigo(1);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//apenas para teste
		System.out.println("entrou do get");
//		request.getSession().setAttribute("agenciaSelecionada",agencia);
		//
		atualizarConsulta(request , response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//
		// Verifica a acao do usuario.
		//
		System.out.println("entrou do post");
		String operacao = request.getParameter("operacao");
	
		
		System.out.println(operacao);
				
		try{
			
			if("consultar".equals(operacao)){
				atualizarConsulta(request, response);
			}
			else if("voltar".equals(operacao)){
				response.sendRedirect("HomePageView.jsp");
			}
			else if("incluir".equals(operacao)){
				
				ArrayList<Grupo> grupos = new ArrayList<Grupo>();
				VeiculoDAO dao = new VeiculoDAO();
				grupos = dao.getListGrupo();
								
				request.getSession().setAttribute("listaGrupos",grupos);
				request.getRequestDispatcher("VeiculoIncluir.jsp").forward(request, response);
				
			}
			else if ("salvarInclusao".equals(operacao)) {
//				request.getSession().setAttribute("isError", false);
				Veiculo veiculo = new Veiculo();
				carregarObjeto(request , response , veiculo);
				
				Agencia ag = (Agencia) request.getSession().getAttribute("agenciaSelecionada");
				
				VeiculoDAO dao = new VeiculoDAO();
				dao.inserir(veiculo , ag.getCodigo());
				atualizarConsulta(request, response);
				
//				try{
//					dao.inserir(veiculo , ag.getCodigo());
////					request.getSession().setAttribute("isError", false);
//					System.out.println("entrou no try");
//					atualizarConsulta(request, response);
//				}catch(PSQLException e){
//					System.out.println("entrou no catch");
////					request.getSession().setAttribute("isError", true);
//					System.out.println(e.getStackTrace());
//				}
//				System.out.println("passou pelo try/catch");
						
				
			}
			else if("voltarIncluir".equals(operacao)){
				request.getRequestDispatcher("VeiculoConsulta.jsp").forward(request, response);
			}
			else if("detalhes".equals(operacao)){
				
				selecionarVeiculo(request , response);
				Veiculo veiculo = (Veiculo) request.getSession().getAttribute("veiculoSelecionado");
				System.out.println(veiculo.getId());
				request.getRequestDispatcher("VeiculoEdicao.jsp").forward(request, response);
			}
			
			else if("voltarEdicao".equals(operacao)){
				request.getRequestDispatcher("VeiculoConsulta.jsp").forward(request, response);
			}
			
			else if("alterar".equals(operacao)){
				request.getRequestDispatcher("VeiculoAlteracao.jsp").forward(request, response);
			}
			
			else if("excluir".equals(operacao)){
				
				Veiculo veiculo = (Veiculo) request.getSession().getAttribute("veiculoSelecionado");
				VeiculoDAO dao = new VeiculoDAO();
								
				dao.excluir(veiculo);
				
				atualizarConsulta(request, response);
				
			}
			
			else if("salvarAlteracao".equals(operacao)){
				
				Veiculo veiculo = (Veiculo) request.getSession().getAttribute("veiculoSelecionado");
				
				carregarObjeto(request , response , veiculo);
				
				VeiculoDAO dao = new VeiculoDAO();
				dao.alterar(veiculo);
				
				atualizarConsulta(request, response);
				
			}
			
			else if("voltarAlteracao".equals(operacao)){
				request.getRequestDispatcher("VeiculoEdicao.jsp").forward(request, response);
			}
					
			
		}catch (Exception e) {
			trataErro(request, response, e);
		}
				
	}

	private Veiculo selecionarVeiculo(HttpServletRequest request,
			HttpServletResponse response) {

		Veiculo veiculoSelecionado = null;

		//
		// Verificacao para garantir que usuario selecionou
		// um item na lista de veículos
		//
		if (request.getParameter("item") != null) {
			
			ArrayList<Grupo> grupos = (ArrayList) request.getSession().getAttribute("listaGruposByAgencia");
		  	Grupo grupo = new Grupo();
		  	boolean achou = false;
			int i = 0;
		  	int idVeiculo = Integer.parseInt(request.getParameter("item"));
		  	System.out.println("metodo selecionarVeiculo  + id: " + idVeiculo);
		  	
		  	while(i < grupos.size() || achou != true){
		  		grupo = grupos.get(i);
		  		for (int j = 0; j < grupo.getListaDeVeiculos().size() ; j++) { 
					Veiculo v = grupo.getVeiculo(j);
					if(v.getId() == idVeiculo){
						achou = true;
						veiculoSelecionado = v;
						break;
					}
				}
		  		i++;
		  	}
		  	
			request.getSession().setAttribute("veiculoSelecionado", veiculoSelecionado);
		}

		return veiculoSelecionado;
		
	}

	public void atualizarConsulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		VeiculoDAO dao = new VeiculoDAO();
		Agencia ag = (Agencia) request.getSession().getAttribute("agenciaSelecionada");
		grupos = dao.getListGrupoByAgencia(ag.getCodigo());
		
			
		request.getSession().setAttribute("listaGruposByAgencia",grupos);
		request.getRequestDispatcher("VeiculoConsulta.jsp").forward(request, response);
	}
	
	
	private void carregarObjeto(HttpServletRequest request,
			HttpServletResponse response, Veiculo veiculo) {
		
		veiculo.setChassi(request.getParameter("txtChassi"));
		veiculo.setCidade(request.getParameter("txtCidade"));
		veiculo.setEstado(request.getParameter("txtEstado"));
		veiculo.setFabricante(request.getParameter("txtFabricante"));
		veiculo.setKm(request.getParameter("txtKM"));
		veiculo.setModelo(request.getParameter("txtModelo"));
		veiculo.setPlaca(request.getParameter("txtPlaca"));
		
		Grupo gp = new Grupo();
		
		try{
			gp.setId(Integer.parseInt(request.getParameter("cbGrupo")));
		}catch(Exception e){
			gp.setId(0);
		}
		
		veiculo.setGrupo(gp);
	}
	
		
	private void trataErro(HttpServletRequest request,
			HttpServletResponse response, Exception e) throws ServletException,
			IOException {
		// envia para pagina de erro
		//
		request.getSession().setAttribute("erro", e.toString());
		request.getRequestDispatcher("ManterVeiculoErro.jsp").forward(request, response);
	}
	
}
