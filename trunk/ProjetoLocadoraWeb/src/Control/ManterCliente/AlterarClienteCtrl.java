//Classe AlterarClienteCtrl
package Control.ManterCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Dao.ClienteDAO;

import View.*;
import View.Mensagens.Mensagem;

public class AlterarClienteCtrl extends ManterClienteCtrl{
		
	
	public AlterarClienteCtrl(Cliente cliente){
		if(cliente.getClass() == PessoaFisica.class){
			pfView = new ClienteCadastroPFView();
			adicionandoListenersPF();
			this.pf = (PessoaFisica) cliente;
			carregarCamposPF(pfView);
		}
		else{
			pjView = new ClienteCadastroPJView();
			adicionandoListenersPJ();
			this.pj = (PessoaJuridica) cliente;
			carregarCamposPJ(pjView);
		}
	}
	

	private void adicionandoListenersPJ() {
		pjView.addBtCancelar(new CancelarListenerPJ());
		pjView.addBtSalvar(new SalvarListenerPJ());
	}

	private void adicionandoListenersPF() {
		pfView.addBtCancelar(new CancelarListenerPF());
		pfView.addBtSalvar(new SalvarListenerPF());
	}
	
	//===================================================================================
	//CLIENTE PJ
	
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
					Mensagem.impossivelConcluir();
				}
				else{
					int i = Mensagem.desejaAlterarCliente();
					if(i == 0){
						ClienteDAO dao = new ClienteDAO();
						dao.alterar(pf);
						Mensagem.alteracaoSucesso();
//						JOptionPane.showMessageDialog(null, pf.toString());
						pfView.dispose();
						
					}
				}
			}
		}
	}
	
	
	//===================================================================================
	//CLIENTE PJ
	
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
				int i = Mensagem.desejaAlterarCliente();
				if(i == 0){
					ClienteDAO dao = new ClienteDAO();
					dao.alterar(pj);
					Mensagem.alteracaoSucesso();
					pjView.dispose();
				}
			}
		}
	}	
}
