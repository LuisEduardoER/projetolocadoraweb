package controller.cmd.manterVeiculo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agencia;
import model.Cliente;
import model.Locacao;
import model.Veiculo;

public class CommandEscolherVeiculo extends CommandManterVeiculoCtrl{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
//		Recupera o Veiculo, Cliente e Agencia de Retirada da Sessão
		Veiculo veiculoSelecionado = selecionarVeiculo(request , response);
		Agencia agencia = (Agencia) request.getSession().getAttribute("agenciaSelecionada");
		Cliente cliente = (Cliente) request.getSession().getAttribute("clienteSelecionadoLocacao");
		
//		Instância uma Locação e atribui os objs Veiculo, Cliente e Agencia de Retirada
		Locacao locacao = new Locacao();
		locacao.setAgenciaRetirada(agencia);
		locacao.setVeiculoEscolhido(veiculoSelecionado);
		locacao.setClienteEscolhido(cliente);
		
		request.getSession().setAttribute("locacao", locacao);
		return "LocacaoEscolheData.jsp";
		
	}

}
