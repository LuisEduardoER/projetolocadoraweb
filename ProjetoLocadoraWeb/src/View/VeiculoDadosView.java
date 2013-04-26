//Classe VeiculoDadosView
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import Util.AbtToolTipHeader;
import Util.Idioma;
import Util.JTableFormtacaoLetras;
import Util.MyTableModel;
import View.Botoes.BotaoDetalhes;
import View.Botoes.BotaoVoltar;
import View.Frames.JFrameDefault;
import View.Panels.PainelAcessorio;

public abstract class VeiculoDadosView extends JFrameDefault{
	
	 protected String[] columnToolTips = {null,
             null,
             Idioma.bn.getString("veiculoDadosView.diariaKM"),
             Idioma.bn.getString("veiculoDadosView.diariaKMLivre"),
             Idioma.bn.getString("veiculoDadosView.semana")};
	
	
	private JTable tblResultado;
	protected JScrollPane jscResultado;
	
	protected JPanel panelPrincipal;
	protected PainelAcessorio panelAcessorio;
	
	protected BotaoVoltar btVoltar;
	protected BotaoDetalhes btDetalhes;
	
		
	protected void montaJTable() {
		tblResultado = new JTable();
		TableModel model = new MyTableModel(new String[] {Idioma.bn.getString("veiculoConsultaView.grupo") , 
																Idioma.bn.getString("veiculoConsultaView.modelos") , 
																Idioma.bn.getString("veiculoConsultaView.kmControlado") ,
																Idioma.bn.getString("veiculoConsultaView.diaria") , 
																Idioma.bn.getString("veiculoConsultaView.kmLivre")}, 0);
		
		
		tblResultado.setModel(model);
		
		//MODIFICA O TAMANHO DA COLUNA
		modificaTamanhoColuna();
		modificaColuna();
		
		//ADICIONA O TOOLTIP DAS COLUNAS
		adicionaToolTipText();
		
		tblResultado.setMinimumSize(new Dimension(1000, 600));
		
		jscResultado = new JScrollPane();
		jscResultado.setViewportView(tblResultado);
		jscResultado.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.darkGray , 1 , true) ,
				  ""));
		
	}
	
	
	private void modificaTamanhoColuna(){
		TableColumn coluna = null;
		
		for(int i = 0; i < 5; i++){
			coluna = getTabela().getColumnModel().getColumn(i);
			if(i == 1){
				coluna.setPreferredWidth(100); //segunda coluna é a maior
				coluna.setMinWidth(20);
			}
			else{
				coluna.setPreferredWidth(50);
				coluna.setMinWidth(20);
			}
		}
	}
	
	private void modificaColuna(){
		TableColumn coluna = getTabela().getColumnModel().getColumn(0);
		coluna.setCellRenderer(new JTableFormtacaoLetras());
	}
	
	private void adicionaToolTipText() {
		AbtToolTipHeader tooltipHeader = new AbtToolTipHeader(getTabela().getColumnModel());          
		// Seta a table header de tooltips
		getTabela().setTableHeader(tooltipHeader);
		
		for(int i = 0; i < 5 ; i++){
			tooltipHeader.addToolTipToColumn(i, columnToolTips[i]);
		}
	}
	
	
	public JTable getTabela(){
		return tblResultado;
	}
	
	public PainelAcessorio getPanelAcessorio(){
		return panelAcessorio;
	}
	
	public void addBtVoltarListener(ActionListener a){
		btVoltar.addActionListener(a);
	}
	
	public void addBtDetalhes(ActionListener a){
		btDetalhes.addActionListener(a);
	}
	
}
