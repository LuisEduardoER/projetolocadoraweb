package controller.cmd.manterCliente;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DataFormatada;

import model.PessoaFisica;

public class CommandSalvarInclusaoCliente extends CommandManterCliente{
	
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PessoaFisica pf = new PessoaFisica();
		
		pf.setNome(request.getParameter("textNome"));
		pf.setRg(request.getParameter("textRg"));
		pf.setRegistro(request.getParameter("textCpf"));
		pf.setDtaNascimento((DataFormatada.parseDataSimples(request.getParameter("textDataNascimento"))));
		pf.setEmail(request.getParameter("textEmail"));
		pf.setTelefone(request.getParameter("textTelefone"));
		pf.setSexo(request.getParameter("textSexo"));
		
		try{
			pf.incluir(); //OBS: TEM QUE COLOCAR O INCLUIR*******************************************************
		}catch (Exception e){
			
		}
			
		return "HomePageView.jsp"; 
	}
}
