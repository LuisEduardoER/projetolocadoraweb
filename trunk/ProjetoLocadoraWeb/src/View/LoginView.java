//Classe LoginView
package View;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Util.Idioma;
import View.Botoes.BotaoLogin;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;


public class LoginView extends JDialog{
	//LABELS
	private Rotulo lbLogin;
	private Rotulo lbSenha;
	private Rotulo lbAgencia;
	private Rotulo lbIdioma;
	
	//TEXT FIELD
	private JTextField txtLogin;
	
	//JPASSWORD FIELD
	private JPasswordField pfSenha;
	
	//COMBO BOXES
	private JComboBox cbAgencia;
	private JComboBox cbIdioma;
	
	//BOTÕES
	private BotaoLogin btLogin;
	
	public LoginView(JFrame frame){
		super(frame , Idioma.bn.getString("loginView.title") , true);
		montaDialog();
	}
	
	public LoginView(){
		setTitle(Idioma.bn.getString("loginView.title"));
		montaDialog();
	}

	private void montaDialog() {
		initComponents();
		setLayout(new GridBagLayout());
		
		GridBagConstraints con = new GridBagConstraints();
		
		/* define uma borda para aumentar o espaço
	       entre as bordas da janela e o gerenciador
	       de layout
	     */
		
		((JComponent)getContentPane()).setBorder(
			       new EmptyBorder(15, 20, 15, 20));
		
		
		//Armazena a lbLogin no Layout
		// lados de cima, esquerda, inferior e direita
		con.insets = new Insets(2, 2, 2, 2);
		con.gridx = 0; //linha
		con.gridy = 0; //coluna
		add(lbLogin , con);
		
		//Armazena o txtLogin no Layout
		con.gridx = 1;
		con.gridy = 0;
		add(txtLogin , con);
		
		//Armazena a lbSenha no Layout
		con.gridx = 0; 
		con.gridy = 1; 
		add(lbSenha , con);
		
		//Armazena o pfSenha no Layout
		con.gridx = 1;
		con.gridy = 1;
		add(pfSenha , con);
		
		//Armazena a lbAgencia no Layout
		con.gridx = 0;
		con.gridy = 2;
		add(lbAgencia , con);
		
		//Armazena o cbAgencia no Layout
		con.gridx = 1;
		con.gridy = 2;
		add(cbAgencia , con);
		
		//Armazena a lbIdioma no Layout
		con.gridx = 0;
		con.gridy = 3;
		add(lbIdioma , con);
		
		//Armazena o cbIdioma no Layout
		con.gridx = 1;
		con.gridy = 3;
		add(cbIdioma , con);
		
		//Armazena o btLogin no Layout
		con.insets = new Insets(8, 0, 2, 2);
		con.gridx = 0; //1
		con.gridy = 4;
		con.gridwidth = 3;
		con.anchor = GridBagConstraints.CENTER;
		add(btLogin , con);
		
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
	}

	private void initComponents() {
		//INICIALIZANDO AS LABELS
		lbLogin = new Rotulo(RotuloNomes.getLOGIN());
		lbSenha = new Rotulo(RotuloNomes.getSENHA());
		lbAgencia = new Rotulo(RotuloNomes.getCOD_AGENCIA());
		lbIdioma = new Rotulo(RotuloNomes.getIDIOMA());
		
		//INICIALIZANDO TEXT FIELD
		txtLogin = new JTextField(15);
		
		//INICIALIZANDO JPASSWORD FIELD
		pfSenha = new JPasswordField(15);
		
		//INCIALIZANDO COMBO BOXES
		initComboBoxes();
		
		
		//INCIALIZANDO BOTÕES
		btLogin = new BotaoLogin();
		
	}
	
	
	private void initComboBoxes() {
		
		//INICIALIZANDO O COMBO BOX IDIOMA
		cbAgencia = new JComboBox();
				
		
		//INICIALIZANDO O COMBO BOX IDIOMA
		String nomes[] = {  Idioma.bn.getString("loginView.seleciona"),
							Idioma.bn.getString("loginView.portugues") , 
							Idioma.bn.getString("loginView.ingles") , 
							Idioma.bn.getString("loginView.espanhol")}; //Tipos de Idioma
		
		cbIdioma = new JComboBox(nomes); 
		cbIdioma.setSelectedIndex(0); //Inicializa com a String "Seleciona"
		cbIdioma.setEditable(false); //Não pode editar
	}
	
	public void preencheComboAgencia(ArrayList objects){
		for(int i = 0; i < objects.size() ; i++){
			cbAgencia.addItem(objects.get(i));
		}
	}
	
	public void addLoginListener(ActionListener a){
		btLogin.addActionListener(a);
	}
	
	public Object getComboBoxAgencia(){
		
		return cbAgencia.getSelectedItem();
	}
	
	public int getComboBoxIdioma(){
		
		return cbIdioma.getSelectedIndex();
	}

	public String getTxtLogin() {
		return txtLogin.getText();
	}

	public void setTxtLogin(String login) {
		this.txtLogin.setText(login);
	}

	public String getPfSenha() {
		return pfSenha.getText();
	}

	public void setPfSenha(String senha) {
		this.pfSenha.setText(senha);
	}

	public void limparCampos() {
		setTxtLogin("");
		setPfSenha("");
	}
}
