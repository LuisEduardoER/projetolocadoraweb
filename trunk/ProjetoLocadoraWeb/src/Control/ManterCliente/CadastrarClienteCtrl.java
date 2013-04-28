//Classe CadastrarClienteCtrl
package Control.ManterCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.PessoaFisica;
import Model.PessoaJuridica;
import Model.Dao.ClienteDAO;

import View.ClienteCadastroPFView;
import View.ClienteCadastroPJView;
import View.ClienteEscolhaView;
import View.Mensagens.Mensagem;

public class CadastrarClienteCtrl extends ManterClienteCtrl{
	
	
	public CadastrarClienteCtrl(){
		escolhaView = new ClienteEscolhaView();
		adicionandoListener();
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
			escolherCliente(escolhaView.getSelectedItem());
		}
		
	}
	
	public void escolherCliente(String tipo){
		if(tipo.equals("PF")){ //cadastra cliente PF
			pfView = new ClienteCadastroPFView();
			pf = new PessoaFisica();
			adicionandoListenerPF();
		}
		else{ //cadastra cliente PJ
			pjView = new ClienteCadastroPJView();
			pj = new PessoaJuridica();
			adicionandoListenerPJ();
		}
	}
	
	
	private void adicionandoListenerPF() {
		pfView.addBtCancelar(new CancelarListenerPF());
		pfView.addBtSalvar(new SalvarListenerPF());
		
	}
	
	private void adicionandoListenerPJ() {
		pjView.addBtCancelar(new CancelarListenerPJ());
		pjView.addBtSalvar(new SalvarListenerPJ());
		
	}
	
	//Listener para o botão "Cancelar"
	class CancelarListenerPF implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int op = Mensagem.desejaCancelar();
			if(op == 0){
				pfView.dispose();
			}
		}
	}
	
	//Listener para o botão "Salvar"
	class SalvarListenerPF implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(carregarObjetoPF(pfView) == false){
				//retorna mensagem que não é possível incluir
				Mensagem.impossivelConcluir();
			}
			else{
				if(verificarIdade() == false || verificarHabilitacao() == false){ //Idade ou anos de habilitação incorretam
					//retorna mensagem que não é possível incluir
					Mensagem.verificaIdadeHabilitacao();
				}
				else{
					int i = Mensagem.desejaCadastrarCliente();
					if(i == 0){
						ClienteDAO dao = new ClienteDAO();
						dao.cadastrar(pf);
						Mensagem.cadastroSucesso();
						pfView.dispose();	
					}
				}
			}
		}
	}
	
	//===================================================================
	
	//Listener para o botão "Cancelar PJ"
		class CancelarListenerPJ implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				int op = Mensagem.desejaCancelar();
				if(op == 0){
					pjView.dispose();
				}
				
			}
		}
		
		//Listener para o botão "Salvar PJ"
		class SalvarListenerPJ implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(carregarObjetoPJ(pjView) == false){
					//retorna mensagem que não é possível incluir
					Mensagem.impossivelConcluir();
				}
				else{
					int i = Mensagem.desejaCadastrarCliente();
					if(i == 0){
						ClienteDAO dao = new ClienteDAO();
						dao.cadastrar(pj);
						Mensagem.cadastroSucesso();
						pjView.dispose();
					}
				}
			}
		}	
}
