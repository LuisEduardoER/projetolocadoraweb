//Classe ConsultarClienteCtrl
package Control.ManterCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Dao.ClienteDAO;
import Control.RealizarLocacao.LocacaoPJCtrl;
import Control.RealizarLocacao.RealizarLocacaoCtrl;
import View.*;
import View.Mensagens.Mensagem;

public class ConsultarClienteCtrl extends ManterClienteCtrl{
	private ClienteConsultaView consultaView;
	private ClienteConsultaDetPFView consultaPFView;
	private ClienteConsultaDetPJView consultaPJView;
	
//	Controller Realizar Locacao
	private RealizarLocacaoCtrl realizarLocacaoCtrl;
//	Controller Realizar Locacao PJ
	private LocacaoPJCtrl locacaoPJ;
	
	public ConsultarClienteCtrl(){
		escolhaView = new ClienteEscolhaView();
		adicionandoListener();
	}
	
		
	public ConsultarClienteCtrl(RealizarLocacaoCtrl realizarLocacaoCtrl) {
		this.realizarLocacaoCtrl = realizarLocacaoCtrl;
		escolhaView = new ClienteEscolhaView();
		adicionandoListener();
	}
	

	public ConsultarClienteCtrl(LocacaoPJCtrl locacaoPJCtrl) {
		this.locacaoPJ = locacaoPJCtrl;
		consultaView = new ClienteConsultaView();
		escolherCliente("PF");
	}


	public void escolherCliente(String tipo){
		
		if(tipo.equals("PF")){ //consulta cliente PF
//			pf = new PessoaFisica();
			adicionandoListenerPF();
		}
		else{ //consulta cliente PJ
//			pj = new PessoaJuridica();
			adicionandoListenerPJ();
		}
	}
	
	private void adicionandoListener() {
		escolhaView.addBtVoltarListener(new VoltarListener());
		escolhaView.addBtConfirmarListener(new ConfirmarListener());
		
	}
	
	class VoltarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int op = Mensagem.desejaCancelar();
			if(op == 0){
				escolhaView.dispose();
			}
		}
		
	}
	
	class ConfirmarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			escolhaView.dispose();
			consultaView = new ClienteConsultaView();
			escolherCliente(escolhaView.getSelectedItem());
		}	
	}
	

	private void adicionandoListenerPF() {
		consultaView.addBtAlterar(new AlterarListenerPF());
		consultaView.addBtCancelar(new CancelarListener());
		consultaView.addBtDetalhes(new DetalhesListenerPF());
		consultaView.addBtLocar(new LocarListener());
		consultaView.addBtPesquisar(new PesquisarListenerPF());
		
	}

	private void adicionandoListenerPJ() {
		consultaView.addBtAlterar(new AlterarListenerPJ());
		consultaView.addBtCancelar(new CancelarListener());
		consultaView.addBtDetalhes(new DetalhesListenerPJ());
		consultaView.addBtLocar(new LocarListener());
		consultaView.addBtPesquisar(new PesquisarListenerPJ());
	}
	
	class PesquisarListenerPJ implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			ClienteDAO dao = new ClienteDAO();
			pj = dao.consultarPJ(consultaView.getTxtCnpjPesq());
			if(pj == null){
				Mensagem.impossivelEncontrarCnpj();
			}
			else{
				carregarCamposConsultaSimplesPJ();
			}
		}
	}
	
	class PesquisarListenerPF implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			ClienteDAO dao = new ClienteDAO();
			pf = dao.consultarPF(consultaView.getTxtCnpjPesq());
			if(pf == null){
				Mensagem.impossivelEncontrarCpf();
			}
			else{
				carregarCamposConsultaSimplesPF();
			}
		}
	}
	
	
	
	class DetalhesListenerPJ implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if(pj == null){
				Mensagem.efetuarPesquisa();
			}
			else{
				consultaView.dispose();
				consultaPJView = new ClienteConsultaDetPJView();
				consultaPJView.addBtAlterar(new AlterarListenerPJ());
				consultaPJView.addBtExcluir(new ExcluirListenerPJ());
				consultaPJView.addBtLocar(new LocarListener());
				consultaPJView.addBtVoltar(new VoltarListenerPJ());
				carregarCamposPJ(consultaPJView);
			}
		}
	}
		
	class DetalhesListenerPF implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if(pf == null){
				Mensagem.efetuarPesquisa();
			}
			else{
				consultaView.dispose();
				consultaPFView = new ClienteConsultaDetPFView();
				consultaPFView.addBtAlterar(new AlterarListenerPF());
				consultaPFView.addBtExcluir(new ExcluirListenerPF());
				consultaPFView.addBtLocar(new LocarListener());
				consultaPFView.addBtVoltar(new VoltarListenerPF());
				carregarCamposPF(consultaPFView);
				
			}
		}
	}
	
	class AlterarListenerPF implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if(pf != null){
				AlterarClienteCtrl alterar = new AlterarClienteCtrl(pf);
			}
		}
	}
	
	class AlterarListenerPJ implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if(pj != null){
				AlterarClienteCtrl alterar = new AlterarClienteCtrl(pj);
			}
		}
	}
	
	class CancelarListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			consultaView.dispose();
		}
	}
	
	class LocarListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if(realizarLocacaoCtrl == null && locacaoPJ == null){ //Se o usuário clicar no botão locar sem estar realizando a locação
				Mensagem.impossivelEfetuarLocacaoTelaErrada();
			}
			else{
				if(locacaoPJ != null){ //se o usuário estiver efetuando a locação PJ
					if(pf != null){
						locacaoPJ.adicionarPF(pf);
					}
				}
				else{
					if(pf != null){ //se o usuário adicionar o cliente PF
						realizarLocacaoCtrl.adicionarCliente(pf);
					}else{ //senão, o usuário adiciona o cliente PJ
						if(pj != null){
							realizarLocacaoCtrl.adicionarCliente(pj);
						}
					}
				}
				fecharJanelas(); //fecha as janelas
			}
		}
	}
	
	class ExcluirListenerPF implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			ExcluirClienteCtrl excluir = new ExcluirClienteCtrl(pf, consultaPFView);
		}
	}
	
	class ExcluirListenerPJ implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			ExcluirClienteCtrl excluir = new ExcluirClienteCtrl(pj, consultaPJView);
		}
	}
	
	class VoltarListenerPJ implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			consultaPJView.dispose();
			consultaView.show();
		}
	}
	
	class VoltarListenerPF implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			consultaPFView.dispose();
			consultaView.show();
		}
	}
	
	protected void carregarCamposConsultaSimplesPF(){
		consultaView.setTxtNome(pf.getNome());
		consultaView.setTxtCnpjRes(pf.getRegistro());
		consultaView.setTxtTelefone(pf.getTelefone());
		consultaView.setTxtEmail(pf.getEmail());
	}
	
	protected void carregarCamposConsultaSimplesPJ(){
		consultaView.setTxtNome(pj.getRazaoSocial());
		consultaView.setTxtCnpjRes(pj.getRegistro());
		consultaView.setTxtTelefone(pj.getTelefone());
		consultaView.setTxtEmail(pj.getEmail());
	}
	
	private void fecharJanelas(){
		if(consultaPFView != null){
			consultaPFView.dispose();
		}
		if(consultaPJView != null){
			consultaPJView.dispose();
		}
		if(consultaView != null){
			consultaView.dispose();
		}
	}
	
}
