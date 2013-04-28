//Classe ConcluirDevolucaoCtrl
package Control.DevolverVeiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Devolucao;
import Model.Dao.DevolucaoDAO;

import View.DevolucaoConfirmarView;
import View.Mensagens.Mensagem;

public class ConcluirDevolucaoCtrl {
	
	private Devolucao devolucao;
	private DevolucaoConfirmarView confirmarView;
	
	public ConcluirDevolucaoCtrl(Devolucao devolucao) {
		
		confirmarView = new DevolucaoConfirmarView();
		adicionarListener();
		DevolucaoDAO dao = new DevolucaoDAO();
		dao.inserir(devolucao);
		devolucao.setId(dao.obterUltimoRegistro());
		this.devolucao = devolucao;
		carregarCamposView();
				
		
	}

	private void adicionarListener() {
		confirmarView.addBtImprimirListener(new ImprimirListener());
	}
	
		
	class ImprimirListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean isOk = ComprovanteDevolucao.imprimiComprovante(devolucao);
			if(isOk == true){
				Mensagem.impressaoEfetuadaSucesso();
				confirmarView.dispose();
			}else{
				Mensagem.impressaoNaoEfetuada();
			}
			
		}
		
	}
	
	
	
	private void carregarCamposView() {
		confirmarView.setTxtIdLocacao(this.devolucao.getId());
		System.out.println(this.devolucao.getId());
		confirmarView.setTxtAgenciaDevolucao(devolucao.getAgenciaDevolucao().getNome());
		confirmarView.setTxtAgenciaRetirada(devolucao.getLocacao().getAgenciaRetirada().getNome());
		confirmarView.setTxtCliente(devolucao.getLocacao().getClienteEscolhido().getNome());
		confirmarView.setTxtCnpj(devolucao.getLocacao().getClienteEscolhido().getRegistro());
		confirmarView.setTxtDtaDevolucao(devolucao.getDtaDevolucao());
		confirmarView.setTxtDtaRetirada(devolucao.getLocacao().getDtaRetirada());
		confirmarView.setTxtQtdDias(devolucao.getQtdDias()); 
		confirmarView.setTxtTipoTarifa(devolucao.getLocacao().getTipoTarifa());
		confirmarView.setTxtTotal(devolucao.getTotal());
	}

}
