package controller.manterVeiculo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Agencia;
import model.Grupo;
import model.Veiculo;
import model.dao.VeiculoDAO;

/**
 * Servlet implementation class ManterVeiculoController
 */

public class ManterVeiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterVeiculoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		atualizarConsulta(request , response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//
		// Verifica a acao do usuario.
		//
		String operacao = request.getParameter("operacao");
				
		try{
			
			if("consultar".equals(operacao)){
				atualizarConsulta(request, response);
			}
			else if("voltar".equals(operacao)){
				response.sendRedirect("HomePageView.jsp");
			}
			else if("incluir".equals(operacao))
			{
				
				ArrayList<Grupo> grupos = new ArrayList<Grupo>();
				VeiculoDAO dao = new VeiculoDAO();
				grupos = dao.getListGrupo();
				request.getSession().setAttribute("listaGrupos",grupos);
				request.getRequestDispatcher("VeiculoIncluir.jsp").forward(request, response);
				
			}
			else if ("salvarInclusao".equals(operacao)) 
			{
				Veiculo veiculo = new Veiculo();
				carregarObjeto(request , response , veiculo);
				
				Agencia ag = (Agencia) request.getSession().getAttribute("agenciaSelecionada");
				
				VeiculoDAO dao = new VeiculoDAO();
				//tenta inserir o veículo no banco
				try{
					dao.inserir(veiculo , ag.getCodigo());
					
					request.getSession().setAttribute("goToServlet", "manterVeiculo");
					request.getSession().setAttribute("messageTitle", "Mensagem - Inclusão Veículo");
					request.getSession().setAttribute("messageBody", "Veículo Incluido com sucesso!!!");
					
				}catch(Exception e){
					System.out.println(e.getMessage());
					
					request.getSession().setAttribute("goToServlet", "manterVeiculo");
					request.getSession().setAttribute("messageTitle", "Mensagem - Inclusão Veículo");
					request.getSession().setAttribute("messageBody", "Não foi possível incluir o veículo");						
				
				}
//				Manda para página de Mensagem
				request.getRequestDispatcher("Mensagem.jsp").forward(request, response);
				
			}
			else if("voltarIncluir".equals(operacao))
			{
				request.getRequestDispatcher("VeiculoConsulta.jsp").forward(request, response);
			}
			else if("detalhes".equals(operacao))
			{
				selecionarVeiculo(request , response);
				Veiculo veiculo = (Veiculo) request.getSession().getAttribute("veiculoSelecionado");
				request.getRequestDispatcher("VeiculoEdicao.jsp").forward(request, response);
			}
			else if("voltarEdicao".equals(operacao))
			{
				request.getRequestDispatcher("VeiculoConsulta.jsp").forward(request, response);
			}
			
			else if("alterar".equals(operacao)){
				request.getRequestDispatcher("VeiculoAlteracao.jsp").forward(request, response);
			}
			else if("excluir".equals(operacao))
			{				
				Veiculo veiculo = (Veiculo) request.getSession().getAttribute("veiculoSelecionado");
				VeiculoDAO dao = new VeiculoDAO();
				//tenta excluir o veículo no banco
				try{
					dao.excluir(veiculo);
					
					request.getSession().setAttribute("goToServlet", "manterVeiculo");
					request.getSession().setAttribute("messageTitle", "Mensagem - Exclusão Veículo");
					request.getSession().setAttribute("messageBody", "Veículo Excluído com sucesso!!!");
										
				}catch(Exception e){
					System.out.println(e.getMessage());
					
					request.getSession().setAttribute("goToServlet", "manterVeiculo");
					request.getSession().setAttribute("messageTitle", "Mensagem - Exclusão Veículo");
					request.getSession().setAttribute("messageBody", "Não foi possível excluir o veículo");
				}
//				Manda para página de Mensagem
				request.getRequestDispatcher("Mensagem.jsp").forward(request, response);				
			}
			else if("salvarAlteracao".equals(operacao))
			{
				Veiculo veiculo = (Veiculo) request.getSession().getAttribute("veiculoSelecionado");
				
				carregarObjeto(request , response , veiculo);
				
				VeiculoDAO dao = new VeiculoDAO();
				
				//tenta alterar o veículo no banco
				try{
					dao.alterar(veiculo);
					
					request.getSession().setAttribute("goToServlet", "manterVeiculo");
					request.getSession().setAttribute("messageTitle", "Mensagem - Alteração Veículo");
					request.getSession().setAttribute("messageBody", "Veículo Alterado com sucesso!!!");
										
				}catch(Exception e){
					System.out.println(e.getMessage());
					
					request.getSession().setAttribute("goToServlet", "manterVeiculo");
					request.getSession().setAttribute("messageTitle", "Mensagem - Alteração Veículo");
					request.getSession().setAttribute("messageBody", "Não foi possível alterar o veículo");
				}
				
//				Manda para página de Mensagem
				request.getRequestDispatcher("Mensagem.jsp").forward(request, response);
							
			}
			else if("voltarAlteracao".equals(operacao))
			{
				request.getRequestDispatcher("VeiculoEdicao.jsp").forward(request, response);
			}			
		}catch (Exception e) {
			trataErro(request, response, e);
		}
	}// fim método doPost()

//	Método responsável por selecionar um Veículo na tabela na tela "consultar"
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
					} //fim if
				}// fim for
		  		i++;
		  	}//fim while
		  	
			request.getSession().setAttribute("veiculoSelecionado", veiculoSelecionado);
		}//fim if

		return veiculoSelecionado;
	}//fim método selecionarVeiculo()

//	Método responsável por atualizar a tela "Consulta" com os veículos atuais no BD
	public void atualizarConsulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		VeiculoDAO dao = new VeiculoDAO();
		Agencia ag = (Agencia) request.getSession().getAttribute("agenciaSelecionada");
		grupos = dao.getListGrupoByAgencia(ag.getCodigo());
		
			
		request.getSession().setAttribute("listaGruposByAgencia",grupos);
		request.getRequestDispatcher("VeiculoConsulta.jsp").forward(request, response);
	}
	
//	Método responsável por carregar um objeto Veículo do .jsp
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
	}//fim do método carregarObjeto()
	
//	Método responsável por redirecionar para a página de erro
	private void trataErro(HttpServletRequest request,
			HttpServletResponse response, Exception e) throws ServletException,
			IOException {
		// envia para pagina de erro
		//
		request.getSession().setAttribute("erro", e.toString());
		request.getRequestDispatcher("ManterVeiculoErro.jsp").forward(request, response);
	}
	
}//fim Classe ManterVeiculoController.java