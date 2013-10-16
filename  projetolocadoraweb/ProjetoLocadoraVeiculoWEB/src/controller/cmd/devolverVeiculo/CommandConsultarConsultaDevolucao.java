package controller.cmd.devolverVeiculo;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Locacao;
import controller.cmd.Command;

public class CommandConsultarConsultaDevolucao extends Command{

	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
//		LocacaoDAO dao = new LocacaoDAO();
		String nextPage = null;
		Locacao locacao = new Locacao();
		request.getSession().setAttribute("listaIDsLocacao", 0);
		int idLocacao = (Integer) request.getAttribute("txtIdLocacaoConsulta");
		String szCnpjCpf = (String) request.getAttribute("txtCnpjCpfConsulta");
		
		
		try{
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
//						calculaQtdDias();
//						carregarValoresCampos();
						//ENCAMINHAR PARA A PRÓXIMA TELA
						nextPage = "DevolucaoValoresAdicionais.jsp";
					}
				}
			}
		}catch(NumberFormatException e){
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
				}
			}else{
				nextPage = "DevolucaoConsulta.jsp";
			}
		}
//		consultaView.limparCamposSuperior();
		
		return nextPage;
	}
	
	

}
