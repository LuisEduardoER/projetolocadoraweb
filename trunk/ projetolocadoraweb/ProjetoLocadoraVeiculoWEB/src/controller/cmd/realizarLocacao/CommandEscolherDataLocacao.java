package controller.cmd.realizarLocacao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DataFormatada;
import util.Verificacao;

import model.Agencia;
import model.Locacao;

import controller.cmd.Command;

public class CommandEscolherDataLocacao extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Locacao locacao = (Locacao) request.getSession().getAttribute("locacao");
		String nextPage = null;
		
		carregarObjeto(request , response , locacao);
		
		if(verificaDataHora(locacao)){
			System.out.println("data ok");
			locacao.calcularTotal();			
			request.getSession().setAttribute("locacao", locacao);
			
			if(locacao.getTipoTarifa().equals("kmLivre")){
//				Tarifa Livre
//				request.getRequestDispatcher("LocacaoDados.jsp").forward(request, response);
				nextPage = "LocacaoDados.jsp";
			}else{
//				Tarifa Controlada
//				request.getRequestDispatcher("LocacaoDados.jsp").forward(request, response);
				nextPage = "LocacaoDados.jsp";
			}
			
		}else{
			System.out.println("Data Inv�lida");
//			request.getRequestDispatcher("LocacaoEscolheData.jsp").forward(request, response);
			nextPage = "LocacaoEscolheData.jsp";
		}
		
		return nextPage;
	}
	
	private void carregarObjeto(HttpServletRequest request,
			HttpServletResponse response, Locacao locacao) {
				
//		Pega a Ag�ncia Devolu��o escolhida
		
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
		
//		request.getSession().setAttribute("locacao", locacao);
		
		System.out.println(locacao.getDtaRetirada().toString());
		System.out.println(locacao.getDtaPrevDevolucao().toString());
		System.out.println(locacao.getTipoTarifa());

	}
	
//	Pegar Data/Hora dos Panels
	
	private Date getData(ServletRequest request, String tipo){
		Calendar c = GregorianCalendar.getInstance();
		try{
			
			
//			Date dt = new Date( request.getParameter("txtData" + tipo) );
			
//			É necessário efetuar este parse, pois a data chega no formato yyyy-MM-dd (2013-10-14) e precisa ser formatdo 
//			para a data dd/MM/yyyy 14/10/2013
						
			Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("txtData" + tipo));
			String data = new SimpleDateFormat("dd/MM/yyyy").format(dt);
			dt = DataFormatada.parseDataSimples(data);
			
//			Date dt = DataFormatada.parseDataSimples(request.getParameter("txtData" + tipo));
			
			
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
	
//	M�todo para verificar se a DataHora est� correta
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
