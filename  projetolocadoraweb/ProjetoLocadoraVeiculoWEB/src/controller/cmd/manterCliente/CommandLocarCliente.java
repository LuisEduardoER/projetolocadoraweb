package controller.cmd.manterCliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PessoaFisica;

import controller.cmd.Command;

public class CommandLocarCliente extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
//		TESTE LOCAÇÃO PARA CAPTURAR O CLIENTE
//		CLIENTE PF
		
		PessoaFisica pf = new PessoaFisica();
		pf.setNome("Diego");
		pf.setEmail("dto.diego");
		pf.setRegistro("123.123-01");
		pf.setSexo("M");
		
		request.getSession().setAttribute("clienteSelecionadoLocacao", pf);
				
		return "VeiculoConsulta.jsp";
	}

}
