package controller.cmd.devolverVeiculo;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Verificacao;
import model.Locacao;
import controller.cmd.Command;

public class CommandConsultarConsultaDevolucao extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println( "entrou no consultar devolucao");
//		LocacaoDAO dao = new LocacaoDAO();
		String nextPage = null;
		Locacao locacao = new Locacao();
		request.getSession().setAttribute("listaIDsLocacao", 0);
				
		try{
			int idLocacao = Integer.parseInt(request.getParameter("txtIdLocacaoConsulta"));
			if(idLocacao > 0){
				if(locacao.isDevolvido(idLocacao)){
//					Mensagem.impossivelEncontrarLocacaoFinalizada();
					System.out.println( "Não foi possível encontrar locação pois a mesma está finalizada");
					nextPage = "DevolucaoConsulta.jsp";
				}else{
					locacao = locacao.consultar(idLocacao);
					if(locacao == null){
//						Mensagem.impossivelEncontrarLocacao();
						System.out.println( "Não foi possível encontrar locação");
						nextPage = "DevolucaoConsulta.jsp";
					}else{
						calculaQtdDias(locacao);
						request.getSession().setAttribute("locacao", locacao);
//						carregarValoresCampos();
						//ENCAMINHAR PARA A MESMA TELA COM OS DADOS DA CONSULTA
						nextPage = "DevolucaoConsulta.jsp";
					}
				}
			}
		}catch(NumberFormatException e){
			System.out.println( e.getMessage());
			String szCnpjCpf = request.getParameter("txtCnpjCpfConsulta");
			if(szCnpjCpf != ""){
				ArrayList<Integer> nroLocacoes = locacao.consultaLocacao(szCnpjCpf);
				
				if(nroLocacoes.isEmpty()){ //caso não for possível encontrar locação 
//					Mensagem.impossivelEncontrarLocacaoCPF();
					System.out.println( "Não foi possível encontrar Locação com o CPF informado");
					nextPage = "DevolucaoConsulta.jsp";
				}else{
					int i = 0;
					String resultado = "";
					while(i < nroLocacoes.size()){
						resultado = resultado + "ID: " + nroLocacoes.get(i) + "\n";
						i++;
					}
//					JOptionPane.showMessageDialog(null, resultado); //mostra todos os IDs das locações do cliente
					request.getSession().setAttribute("listaIDsLocacao", resultado);
					System.out.println(resultado);
					nextPage = "DevolucaoConsulta.jsp";
				}
			}else{
				nextPage = "DevolucaoConsulta.jsp";
			}
		}
//		consultaView.limparCamposSuperior();
		
		return nextPage;
	}
	
	private void calculaQtdDias(Locacao locacao) {
		locacao.setQtdDias(Verificacao.getDiferencaDias(locacao.getDtaRetirada(), locacao.getDtaPrevDevolucao()));
	}

}
