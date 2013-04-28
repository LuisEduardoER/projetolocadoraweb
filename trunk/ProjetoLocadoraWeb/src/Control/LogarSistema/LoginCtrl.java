//Classe LoginCtrl
package Control.LogarSistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

import Model.Agencia;
import Model.Usuario;
import Model.Dao.AgenciaDAO;
import Model.Dao.UsuarioDAO;
import Control.HomePageCtrl;
import Util.Idioma;
import View.LoginView;
import View.Mensagens.Mensagem;


public class LoginCtrl {
	private LoginView loginView;
	private Usuario user;
	private Agencia agencia = null;
	private HomePageCtrl homePage;
	
	public LoginCtrl(HomePageCtrl homePageCtrl){
		loginView = new LoginView();
		user = new Usuario();
		preencheComboBoxes();
		loginView.setVisible(true);
		adicionandoListeners();
		homePage = homePageCtrl;		
	}
	
	public LoginCtrl(JFrame homePage){
		user = new Usuario();
		adicionandoListeners();
		loginView = new LoginView(homePage);
	}
	
	public LoginCtrl() {
		
	}

	private void preencheComboBoxes() {
		AgenciaDAO dao = new AgenciaDAO();
		ArrayList<Agencia> agencias = dao.getList();
		loginView.preencheComboAgencia(agencias);
		
	}
	
	private void adicionandoListeners() {
		loginView.addLoginListener(new LoginListener());
	}
	
	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			user.setLogin(loginView.getTxtLogin());
			user.setSenha(loginView.getPfSenha());
			if(verificaLogin() == true){
				//Passa para o atributo 'agencia' a Agência selecionada pelo Atendente
				agencia = (Agencia) loginView.getComboBoxAgencia();
				Idioma.selecionaIdioma(loginView.getComboBoxIdioma()); //seleciona o Idioma
				Mensagem.inicializaUIManager(); //inicializa o UIManager de acordo com o Idioma escolhido
				Mensagem.loginValido();
				loginView.dispose();
				homePage.inicializaHomePage(agencia , user);
			}
			else{
				Mensagem.loginInvalido();
				loginView.limparCampos();
			}
		}

	}
	
	public boolean verificaLogin(){
		UsuarioDAO dao = new UsuarioDAO();
		boolean isCorrect = false;
		
		Usuario usuario = dao.verificaLogin(user);
		
		if(usuario != null){
			user = usuario;
			isCorrect = true;
		}
		return isCorrect;
	}	
}
