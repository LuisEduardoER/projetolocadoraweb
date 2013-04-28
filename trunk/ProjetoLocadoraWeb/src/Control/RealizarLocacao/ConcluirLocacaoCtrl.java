//Classe ConcluirLocacaoCtrl
package Control.RealizarLocacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Locacao;
import Model.Dao.LocacaoDAO;
import View.LocacaoComprovanteView;
import View.Mensagens.Mensagem;

public class ConcluirLocacaoCtrl {
	
	private Locacao locacao;
	private LocacaoComprovanteView comprovanteView;
	
	public ConcluirLocacaoCtrl(Locacao locacao) {
		comprovanteView = new LocacaoComprovanteView();
		adicionarListener();
		LocacaoDAO dao = new LocacaoDAO();
		dao.inserir(locacao);
		locacao.setId(dao.obterUltimoRegistro());
		this.locacao = locacao;
		carregarCampos();
	}
	
	
	public void adicionarListener(){
		comprovanteView.addBtImprimirComprovanteListener(new ImprimirComprovante());
	}
	
	class ImprimirComprovante implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(locacao.getClienteEscolhido().getTipo().equals("PF")){
				boolean isOk = ComprovanteLocacaoPF.imprimiComprovante(locacao);
				if(isOk == true){
					Mensagem.impressaoEfetuadaSucesso();
					comprovanteView.dispose();
				}else{
					Mensagem.impressaoNaoEfetuada();
				}
			}else{
				boolean isOk = ComprovanteLocacaoPJ.imprimiComprovante(locacao);
				if(isOk == true){
					Mensagem.impressaoEfetuadaSucesso();
					comprovanteView.dispose();
				}else{
					Mensagem.impressaoNaoEfetuada();
				}
			}
		}
		
	}
	
	private void carregarCampos() {
		
		comprovanteView.setTxtCliente(locacao.getClienteEscolhido().getNome());
		comprovanteView.setTxtCnpjCpf(locacao.getClienteEscolhido().getRegistro());
		comprovanteView.setTxtDataDevolucao(locacao.getDtaPrevDevolucao());
		comprovanteView.setTxtDataRetirada(locacao.getDtaRetirada());
		comprovanteView.setTxtNumero(locacao.getId());
		comprovanteView.setTxtQtdDias(locacao.getQtdDias());
		comprovanteView.setTxtTipoTarifa(locacao.getTipoTarifa());
		comprovanteView.setTxtTotal(locacao.getTotal());
		comprovanteView.setTxtAgenciaDevolucao(locacao.getAgenciaDevolucao().getNome());
		comprovanteView.setTxtAgenciaRetirada(locacao.getAgenciaRetirada().getNome());
		
		try{
			comprovanteView.setTxtAcessorio(locacao.getVeiculoEscolhido().getTotalAcessorios());
			comprovanteView.setTxtGrupo(locacao.getVeiculoEscolhido().getGrupo().getNome());
			comprovanteView.setTxtVeiculo(locacao.getVeiculoEscolhido().getModelo());
		}catch(Exception e){
			comprovanteView.setTxtAcessorio(locacao.getCondutor(0).getVeiculo().getTotalAcessorios());
			comprovanteView.setTxtGrupo(locacao.getCondutor(0).getVeiculo().getGrupo().getNome());
			comprovanteView.setTxtVeiculo(locacao.getCondutor(0).getVeiculo().getModelo());
		}	
	}
}
