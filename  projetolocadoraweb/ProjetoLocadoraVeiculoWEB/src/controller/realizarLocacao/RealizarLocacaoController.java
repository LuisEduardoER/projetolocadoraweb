package controller.realizarLocacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DataFormatada;
import util.Verificacao;

import model.Agencia;
import model.Grupo;
import model.Locacao;
import model.PessoaFisica;
import model.Veiculo;

/**
 * Servlet implementation class RealizarLocacaoController
 */
@WebServlet("/RealizarLocacaoController")
public class RealizarLocacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizarLocacaoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		APENAS PARA TESTE
//		CLIENTE (PF) ESCOLHIDO LOCAÇÃO
//		VEÍCULO ESCOLHIDO LOCAÇÃO
		
		PessoaFisica pf = new PessoaFisica();
		pf.setId(2);
		pf.setNome("Diego");
		
		Veiculo veiculo = new Veiculo();
		veiculo.setId(1);
		veiculo.setCidade("guarulhos");
		veiculo.setEstado("são paulo");
		veiculo.setModelo("hey hey het");
		veiculo.setIdVeiculoAg(2);
		Grupo grupo = new Grupo("A", 12.2, 34.2);
		veiculo.setGrupo(grupo);
		
			
//		Agência Retirada
		
		Agencia ag = (Agencia) request.getSession().getAttribute("agenciaSelecionada");
				
		Locacao locacao = new Locacao();
		locacao.setAgenciaRetirada(ag);
		locacao.setClienteEscolhido(pf);
		locacao.setVeiculoEscolhido(veiculo);
			
		request.getSession().setAttribute("locacao", locacao);
		
//		TESTE
		System.out.println(locacao.getAgenciaRetirada().getNome());
		System.out.println(locacao.getClienteEscolhido().getNome());
		System.out.println(locacao.getVeiculoEscolhido().getModelo());
//		FIM-TESTE
		
		request.getRequestDispatcher("LocacaoEscolheData.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("operacao");
		
		try{
			
			if("cancelarEscolheData".equals(operacao)){
//				Volta para a página Inicial
				response.sendRedirect("HomePageView.jsp");
			}
			else if("avancarEscolheData".equals(operacao)){
//				response.sendRedirect("HomePageView.jsp");
				System.out.println("clicou no botao avancar");
				
				Locacao locacao = (Locacao) request.getSession().getAttribute("locacao");
				
				carregarObjeto(request , response , locacao);
				
				if(verificaDataHora(locacao)){
					System.out.println("data ok");
					
					
					if(locacao.getTipoTarifa().equals("kmLivre")){
//						Tarifa Livre
						request.getRequestDispatcher("LocacaoDados.jsp").forward(request, response);
					}else{
//						Tarifa Controlada
						request.getRequestDispatcher("LocacaoDados.jsp").forward(request, response);
					}
					
				}else{
					System.out.println("Data Inválida");
					request.getRequestDispatcher("LocacaoEscolheData.jsp").forward(request, response);
				}				
				
			}
			
			
		}catch(Exception e){
			
		}
		
	}

	private void carregarObjeto(HttpServletRequest request,
			HttpServletResponse response, Locacao locacao) {
				
//		Pega a Agência Devolução escolhida
		
		Agencia agencia = new Agencia();
		agencia.setCodigo(Integer.parseInt(request.getParameter("comboAgenciaDevolucao")));
		
		List retorno = (ArrayList) request.getSession().getAttribute("listaAgencias");
		
		for (Iterator<Agencia> it = retorno.iterator(); it.hasNext();) {
			Agencia ag = (Agencia) it.next();
			
			if(ag.getCodigo() == agencia.getCodigo()){
				agencia = ag;
				break;
			}
		}
		
		locacao.setAgenciaDevolucao(agencia);
		locacao.setDtaRetirada(getData(request , "Retirada"));
		locacao.setDtaPrevDevolucao(getData(request , "Devolucao"));
		locacao.setTipoTarifa(request.getParameter("comboTarifa"));
		
		request.getSession().setAttribute("locacao", locacao);
		
		System.out.println(locacao.getDtaRetirada().toString());
		System.out.println(locacao.getDtaPrevDevolucao().toString());
		System.out.println(locacao.getTipoTarifa());

	}
	
	
//	Pegar Data/Hora dos Panels
	
	private Date getData(ServletRequest request, String tipo){
		Calendar c = GregorianCalendar.getInstance();
		try{
			
			
//			Date dt = new Date( request.getParameter("txtData" + tipo) );
			
			Date dt = DataFormatada.parseDataSimples(request.getParameter("txtData" + tipo));
			
			c.setTime(dt);
			c.set(GregorianCalendar.HOUR_OF_DAY, getHoras(request , tipo));
			c.set(GregorianCalendar.MINUTE, getMinutos(request , tipo));
		
			return c.getTime();
		}catch(Exception e){
			return null;
		}
	}
	
	private int getMinutos(ServletRequest request, String tipo){
//		return Integer.parseInt((String) comboMinutos.getSelectedItem());
		return Integer.parseInt(request.getParameter("comboMinutos" + tipo));
	}
	
	private int getHoras(ServletRequest request, String tipo){
		return Integer.parseInt(request.getParameter("comboHoras" + tipo));
	}
	
//	Método para verificar se a DataHora está correta
	private boolean verificaDataHora(Locacao locacao) {
		
		if(Verificacao.isCorrectDate(locacao.getDtaRetirada())){
			calculaQtdDias(locacao);
			if(locacao.getQtdDias() > 0){
				return true;
			}
//			Mensagem.datahoraDevolucaoIncorreta();
			return false;
		}
//		Mensagem.datahoraRetiradaIncorreta();
		return false;
	}
	
	private void calculaQtdDias(Locacao locacao) {
		locacao.setQtdDias(Verificacao.getDiferencaDias(locacao.getDtaRetirada(), locacao.getDtaPrevDevolucao()));
	}	
		
	
}
