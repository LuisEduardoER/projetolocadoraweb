//Classe TarifaControladaView
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import Util.Idioma;
import Util.MyTableModel;
import View.Botoes.BotaoConcluir;
import View.Botoes.BotaoVoltar;
import View.Frames.JFrameDefault;

public class TarifaControladaView extends JFrameDefault{
	
	private BotaoVoltar btVoltar;
	private BotaoConcluir btConcluir;
	
	private JTable tblResultado;
	private JScrollPane jscResultado;
	
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JPanel panelInferior;
	
	public TarifaControladaView(){
		montaGUI();
	}
	
	
	@Override
	public void montaGUI() {
		initComponents();
		montaFramePrincipal();
		
		add(panelPrincipal);
		montaJFrame(Idioma.bn.getString("tarifaControlada.title"));
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
		
//		gbc.insets = new Insets(4, 0, 4, 4);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 4; // quatro células na linha
	    panel.add(jscResultado , gbc);
	    
	    
	    panelSuperior = new JPanel();
	    panelSuperior.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.darkGray , 1 , true) ,
	    		Idioma.bn.getString("tarifaControlada.addTarifa")));
	    panelSuperior.add(panel);
	    
	}
	
	private void montaPanelInferior() {
		panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		panelInferior.add(btVoltar);
		panelInferior.add(btConcluir);
	}


	@Override
	public void initComponents() {

		btVoltar = new BotaoVoltar();
		btConcluir = new BotaoConcluir();
		
		montaJTable();
	}


	private void montaJTable() {
		tblResultado = new JTable();
		TableModel model = new MyTableModel(new String[] {Idioma.bn.getString("tarifaControlada.cliente"),
														  Idioma.bn.getString("tarifaControlada.veiculo"),
														  Idioma.bn.getString("tarifaControlada.kmInicial"),
														  Idioma.bn.getString("tarifaControlada.kmFinal")}, 0){
			//Método sobreposto da Classe MyTableModel
			public boolean isCellEditable(int row, int col) {  
				if (col == 0 || col ==1) { // Quais colunas eu não quero deixar editar  
					return false;  
			    } else {  
			    	return true;  
			    }
			}
		};
		tblResultado.setModel(model);
		
		modificaTamanhoColuna();
		
		jscResultado = new JScrollPane();
		jscResultado.setViewportView(tblResultado);
		jscResultado.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.darkGray , 1 , true) ,
				  ""));
					
	}
	
	private void modificaTamanhoColuna(){
		TableColumn coluna = null;
		
		for(int i = 0; i < 4; i++){
			coluna = getTabela().getColumnModel().getColumn(i);
			if(i == 0 || i == 1){
				coluna.setPreferredWidth(150); //primeira e segunda coluna é a maior
				coluna.setMinWidth(20);
//				coluna.setMaxWidth(50);
			}
			else{
				coluna.setPreferredWidth(50);
				coluna.setMinWidth(20);
			}
		}
	}
	
	public JTable getTabela(){
		return tblResultado;
	}
	
	public void addBtVoltarListener(ActionListener a){
		btVoltar.addActionListener(a);
	}
	
	public void addBtConcluirListener(ActionListener a){
		btConcluir.addActionListener(a);
	}
	
}
