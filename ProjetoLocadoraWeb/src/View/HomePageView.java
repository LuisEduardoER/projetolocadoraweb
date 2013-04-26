//Classe HomePageView
package View;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import Util.Idioma;
import View.Botoes.*;
import View.Rotulos.*;


public class HomePageView extends JFrame{

	//	Criação dos Botões
	private Botao btConsultarVeiculos;
	private Botao btConsultarClientes;
	private Botao btConsultarLocacao;
	private Botao btCadastrarClientes;
	private Botao btAlterarClientes;
	private Botao btExcluirClientes;
	private Botao btRealizarLocacao;
	private Botao btDevolverVeiculos;
	
//	Criação do Painel
	private JPanel jpPaginaInicial; //Painel irá armazenar os botões
	private JPanel jpSuperior; //Painel irá armazenar as informações do nome do atendente e a Agência
	
//	Criação das Labels
	private Rotulo lbAgencia;
	private Rotulo lbAtendente;
	
//	Criação dos txtFields
	private JTextField txtAgencia;
	private JTextField txtAtendente;
	
//	Criação do Container que irá armazenar o JFrame
	private Container container;
	
//	Criação dos JMenus
	private JMenu menuArquivo;
	private JMenu menuConsultas;
	private JMenu menuAjuda;
	
//	Criação dos JMenuItems
	private JMenuItem itemSair;
	private JMenuItem itemConsultaVeiculos;
	private JMenuItem itemConsultaClientes;
	private JMenuItem itemConsultaLocacao;
	private JMenuItem itemSobre;
	
	public HomePageView(){
		container = getContentPane();
		montaFrame();
		adicionarIconesItemMenu();
	}

	// Método irá criar/montar o Frame Principal
	private void montaFrame() {
		setTitle(Idioma.bn.getString("homePageView.title"));  
		initComponent();
		montaMenu();
		montaPanelSuperior();
		montaPanelPagInicial();
				
		setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
		
		con.gridx = 3; //3
		con.gridy = 0; //0
		con.gridwidth = 3;
		con.gridheight = 1;
		con.anchor = GridBagConstraints.NORTHEAST;
		con.insets = new Insets(-70 , 0 , 0 , -190);
//		con.insets = new Insets(-170 , 0 , 0 , -190); //---OLD---
		
		add(jpSuperior , con);
		
		con.insets = new Insets(0, 0, 0, 0);
		con.gridx = 3; //3
		con.gridy = 4; //4
		con.gridwidth = 2;
		con.anchor = GridBagConstraints.CENTER;
		
		add(jpPaginaInicial , con);
		
		setMinimumSize(new Dimension(800 , 600));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	private void montaMenu() {
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
//		Adiciona os JMenuItems nos seus respectivos JMenus
		menuArquivo.add(itemSair);
		menuConsultas.add(itemConsultaClientes);
		menuConsultas.add(itemConsultaLocacao);
		menuConsultas.add(itemConsultaVeiculos);
		menuAjuda.add(itemSobre);
				
//		Adiciona os JMenus na barra
		bar.add(menuArquivo);
		bar.add(menuConsultas);
		bar.add(menuAjuda);
	
	}

	// Método irá criar/montar o Painel da Página Inicial
	private void montaPanelPagInicial() {
			
		JPanel jpItems = new JPanel(new GridLayout(4 , 2 , 100 , 30)); //Painel dos Items ou Botões
//		JPanel jpItems = new JPanel(new GridLayout(4 , 2 , 20 , 20)); //Painel dos Items ou Botões ---OLD---
		
		jpItems.add(btConsultarVeiculos);
		jpItems.add(btConsultarClientes);
		jpItems.add(btRealizarLocacao);
		jpItems.add(btCadastrarClientes);
		jpItems.add(btConsultarLocacao);
		jpItems.add(btAlterarClientes);
		jpItems.add(btDevolverVeiculos);
		jpItems.add(btExcluirClientes);
		
		jpItems.setBorder(new EmptyBorder(60, 120, 60, 120));
		
		jpPaginaInicial.setLayout(new GridBagLayout());
		jpPaginaInicial.add(jpItems , new GridBagConstraints());
		
		
		jpPaginaInicial.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.darkGray , 1 , true) ,
																	Idioma.bn.getString("homePageView.pagInicial")));
		
		
	    jpPaginaInicial.setPreferredSize(jpPaginaInicial.getMinimumSize());
	
	}

	// Método irá criar/montar o Painel Superior
	private void montaPanelSuperior() {

		jpSuperior.setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
		
		jpSuperior.setBorder(new EmptyBorder(5, 8, 8, 8));
		
		con.insets = new Insets(4, 0, 4, 0);
		
		con.gridy = 0; // linha
	    con.gridx = 0; // coluna
	    con.gridwidth = 1; // uma célula na linha
		
		jpSuperior.add(lbAgencia , con);
		
		con.gridy = 0; // linha
	    con.gridx = 1; // coluna
	    con.gridwidth = 1; // uma célula na linha
		
	    jpSuperior.add(txtAgencia , con);
		
	    con.gridy = 1; // linha
	    con.gridx = 0; // coluna
	    con.gridwidth = 1; // uma célula na linha
	    con.anchor = GridBagConstraints.EAST;
		
		jpSuperior.add(lbAtendente , con);
		
		con.gridy = 1; // linha
	    con.gridx = 1; // coluna
	    con.gridwidth = 1; // uma célula na linha
		
		jpSuperior.add(txtAtendente , con);
		
	}

	//	Método irá inicializar todos os componentes do Frame 
	private void initComponent() {
//		Instanciando os botões
		btConsultarVeiculos = new BotaoConsultarVeiculos();
		btConsultarClientes = new BotaoConsultarClientes();
		btConsultarLocacao = new BotaoConsultarLocacao();
		btCadastrarClientes = new BotaoCadastrarClientes();
		btAlterarClientes = new BotaoAlterarClientes();
		btExcluirClientes = new BotaoExcluirClientes();
		btRealizarLocacao = new BotaoRealizarLocacao();
		btDevolverVeiculos = new BotaoDevolverVeiculos();
		
		
//		Instanciando as Labels
		lbAgencia = new Rotulo(RotuloNomes.getAGENCIA());
		lbAtendente = new Rotulo(RotuloNomes.getNOME());
		
//		Instanciando os TextFields
		txtAgencia = new JTextField(20);
		txtAtendente = new JTextField(20);
		
//		Não permite que os TextFields sejam editáveis
		txtAgencia.setEditable(false);
		txtAtendente.setEditable(false);
		
//		Instancinado os JPanels
		jpPaginaInicial = new JPanel();
		jpSuperior = new JPanel();
		
//		Instanciando os JMenus
		menuArquivo = new JMenu(Idioma.bn.getString("homePageView.menuArquivo"));
		menuConsultas = new JMenu(Idioma.bn.getString("homePageView.menuConsultas"));
		menuAjuda = new JMenu(Idioma.bn.getString("homePageView.menuAjuda"));
		
//		Instanciando os JMenuItems
		itemSair = new JMenuItem(Idioma.bn.getString("homePageView.itemSair"));
		itemConsultaClientes = new JMenuItem(Idioma.bn.getString("homePageView.itemConsultarClientes"));
		itemConsultaLocacao = new JMenuItem(Idioma.bn.getString("homePageView.itemConsultaLocacao"));
		itemConsultaVeiculos = new JMenuItem(Idioma.bn.getString("homePageView.itemConsultaVeiculos"));
		itemSobre = new JMenuItem(Idioma.bn.getString("homePageView.itemSobre"));
	}
	
	
	public String getTxtAgencia() {
		return txtAgencia.getText();
	}

	public void setTxtAgencia(String agenciaNome) {
		this.txtAgencia.setText(agenciaNome);
	}

	public String getTxtAtendente() {
		return txtAtendente.getText();
	}

	public void setTxtAtendente(String atendenteNome) {
		this.txtAtendente.setText(atendenteNome);
	}
	
	
	//MÉTODOS DOS LISTENERS
	//ITENS DO MENU
	
	public void addItemSairListener(ActionListener a){
		itemSair.addActionListener(a);
	}
//	
	public void addItemSobreListener(ActionListener a){
		itemSobre.addActionListener(a);
	}
	
	public void addItemConsultaCliListener(ActionListener a){
		itemConsultaClientes.addActionListener(a);
	}
	
	public void addItemConsultaLocListener(ActionListener a){
		itemConsultaLocacao.addActionListener(a);
	}
	
	public void addItemConsultaVeiListener(ActionListener a){
		itemConsultaVeiculos.addActionListener(a);
	}
	
	//BOTÕES
	public void addBtConVeiculo(ActionListener a){
		btConsultarVeiculos.addActionListener(a);
	}
	
	public void addBtConClientes(ActionListener a){
		btConsultarClientes.addActionListener(a);
	}
	
	public void addBtConLocacao(ActionListener a){
		btConsultarLocacao.addActionListener(a);
	}
	
	public void addBtCadClientes(ActionListener a){
		btCadastrarClientes.addActionListener(a);
	}
	
	public void addBtAltClientes(ActionListener a){
		btAlterarClientes.addActionListener(a);
	}
	
	public void addBtExcClientes(ActionListener a){
		btExcluirClientes.addActionListener(a);
	}
	
	public void addBtReaLocacao(ActionListener a){
		btRealizarLocacao.addActionListener(a);
	}
	
	public void addBtDevVeiculo(ActionListener a){
		btDevolverVeiculos.addActionListener(a);
	}
	
	private void adicionarIconesItemMenu(){
		ImageIcon icon;
		
		icon = new ImageIcon("images/png-16/Exit_16x16x32.png");
		itemSair.setIcon(icon);
		
		icon = new ImageIcon("images/png-16/search_user_16x16x32.png");
		itemConsultaClientes.setIcon(icon);
		
		icon = new ImageIcon("images/png-16/search_page_16x16x32.png");		
		itemConsultaLocacao.setIcon(icon);
		
		icon = new ImageIcon("images/png-16/search_16x16x32.png");		
		itemConsultaVeiculos.setIcon(icon);	
		
		icon = new ImageIcon("images/png-16/support_16x16x32.png");
		itemSobre.setIcon(icon);
	}
	
}
