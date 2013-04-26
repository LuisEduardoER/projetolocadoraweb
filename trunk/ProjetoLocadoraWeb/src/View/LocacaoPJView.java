//Classe LocacaoPJView
package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import Util.Conversao;
import Util.Idioma;
import Util.MyTableModel;
import View.Botoes.BotaoAddMotorista;
import View.Botoes.BotaoConcluir;
import View.Botoes.BotaoVoltar;
import View.Frames.JFrameDefault;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;

public class LocacaoPJView extends JFrameDefault{
	
	private Rotulo lbTotal;
	
	private JTextField txtTotal;
	private double total;
	
	private BotaoAddMotorista btAddMotorista;
	private BotaoVoltar btVoltar;
	private BotaoConcluir btConcluir;
	
	private JTable tblResultado;
	private JScrollPane jscResultado;
	
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JPanel panelInferior;
	
	public LocacaoPJView(){
		montaGUI();
		total = 0.0;
	}
	
	
	@Override
	public void montaGUI() {
		initComponents();
		montaFramePrincipal();
		
		add(panelPrincipal);
		montaJFrame(Idioma.bn.getString("locacaoPJView.title"));
	}

	private void montaFramePrincipal() {
		montaPanelSuperior();
		montaPanelInferior();
		
		panelPrincipal = new JPanel(new GridBagLayout());
		panelPrincipal.setBorder(new EmptyBorder(20, 30, 20, 30));
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(0, 0, 20, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; // uma célula na linha
	    panelPrincipal.add(panelSuperior , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panelPrincipal.add(panelInferior , gbc);
				
	}


	private void montaPanelSuperior() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panel.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 4; // quatro células na linha
	    panel.add(jscResultado , gbc);
	    
	    gbc.gridwidth = 1; // uma célula na linha
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbTotal , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(txtTotal , gbc);
		
	    gbc.anchor = GridBagConstraints.EAST;
	    gbc.gridy = 1; // linha
	    gbc.gridx = 3; // coluna
	    panel.add(btAddMotorista , gbc);
	    
	    panelSuperior = new JPanel();
	    panelSuperior.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.darkGray , 1 , true) ,
	    		Idioma.bn.getString("locacaoPJView.addMotorista")));
	    panelSuperior.add(panel);
	    
	}
	
	private void montaPanelInferior() {
		panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		panelInferior.add(btVoltar);
		panelInferior.add(btConcluir);
	}


	@Override
	public void initComponents() {
		lbTotal = new Rotulo(RotuloNomes.getTOTAL());
		txtTotal = new JTextField(10);
		btAddMotorista = new BotaoAddMotorista();
		btVoltar = new BotaoVoltar();
		btConcluir = new BotaoConcluir();
		
		montaJTable();
	}


	private void montaJTable() {
		tblResultado = new JTable();

		
		TableModel model = new MyTableModel(new String[] {Idioma.bn.getString("locacaoPJView.clientes"),
															   Idioma.bn.getString("locacaoPJView.veiculos") , 
															   Idioma.bn.getString("locacaoPJView.total")} , 0){
		
			//Método sobreposto da Classe MyTableModel
			public boolean isCellEditable(int row, int col) {  
				if (col == 0 || col ==1 || col ==2) { // Quais colunas eu não quero deixar editar  
					return false;  
				} else {  
					return true;  
				}
			}
		};
		
		tblResultado.setModel(model);
		jscResultado = new JScrollPane();
		jscResultado.setViewportView(tblResultado);
		jscResultado.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.darkGray , 1 , true) ,
				  ""));
		
			
	}
	
	public JTable getTabela(){
		return tblResultado;
	}
	
	public void addBtAdicionarMotoristaListener(ActionListener a){
		btAddMotorista.addActionListener(a);
	}
	
	public void addBtVoltarListener(ActionListener a){
		btVoltar.addActionListener(a);
	}
	
	public void addBtConcluirListener(ActionListener a){
		btConcluir.addActionListener(a);
	}


	public double getTxtTotal() {
		return getTotal();
	}

	public void setTxtTotal(double total) {
		setTotal(total);
		this.txtTotal.setText("R$" + Conversao.formatDouble(total));
	}


	private double getTotal() {
		return total;
	}


	private void setTotal(double total) {
		this.total = total;
	}

}
