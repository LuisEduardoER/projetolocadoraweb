//Classe ExcluirClienteCtrl
package Control.ManterCliente;

import javax.swing.JFrame;

import model.Cliente;
import model.Dao.ClienteDAO;

import View.Mensagens.Mensagem;

public class ExcluirClienteCtrl extends ManterClienteCtrl{
	
		
	public ExcluirClienteCtrl(Cliente cliente , JFrame frame){
		excluir(cliente , frame);
	}
	
	public void excluir(Cliente cliente , JFrame frame){
		int op = Mensagem.desejaExcluirCliente();
		if(op == 0){
			ClienteDAO dao = new ClienteDAO();
			dao.excluir(cliente);
			Mensagem.exclusaoSucesso();
			frame.dispose();
		}
	}
	
}
