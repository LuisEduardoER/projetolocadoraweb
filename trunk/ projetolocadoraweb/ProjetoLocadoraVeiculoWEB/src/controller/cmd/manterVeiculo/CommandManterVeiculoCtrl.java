package controller.cmd.manterVeiculo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agencia;
import model.Grupo;
import model.Veiculo;
import controller.cmd.Command;

public abstract class CommandManterVeiculoCtrl extends Command{
	
	
//	M�todo respons�vel por selecionar um Ve�culo na tabela na tela "consultar"
	protected Veiculo selecionarVeiculo(HttpServletRequest request,
			HttpServletResponse response) {

		Veiculo veiculoSelecionado = null;

		//
		// Verificacao para garantir que usuario selecionou
		// um item na lista de ve�culos
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
	}//fim m�todo selecionarVeiculo()

//	M�todo respons�vel por atualizar a tela "Consulta" com os ve�culos atuais no BD
	protected String atualizarConsulta(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		Veiculo veiculo = new Veiculo();
		Agencia ag = (Agencia) request.getSession().getAttribute("agenciaSelecionada");
		grupos = veiculo.getListGrupoByAgencia(ag.getCodigo());
		request.getSession().setAttribute("listaGruposByAgencia",grupos);
		return "VeiculoConsulta.jsp";
		
	}
	
//	M�todo respons�vel por carregar um objeto Ve�culo do .jsp
	protected void carregarObjeto(HttpServletRequest request,
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
	}//fim do m�todo carregarObjeto()
	
}
