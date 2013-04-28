//Classe PainelDataHora
package View.Panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.itextpdf.text.JDateChooser;

import Util.Idioma;
import View.Rotulos.Rotulo;
import View.Rotulos.RotuloNomes;

public class PainelDataHora extends JPanel{
	
	private Rotulo lbData;
	private Rotulo lbHora;
	private Rotulo lbAgencia;
	
	private JDateChooser dtcData;
	
	private JComboBox comboHoras;
	private JComboBox comboMinutos;
	private JComboBox comboAgencia;
	
	private String[] horas;
	private String[] minutos;
	
	public PainelDataHora(String titulo){
		horas = new String[24];
		minutos = new String[61];
		montaPanel(titulo);
	}

	private void montaPanel(String titulo) {
		initComponents();
		setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.darkGray , 1 , true) ,
				  titulo));
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(new EmptyBorder(20, 50, 20, 50));
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(4, 0, 4, 4);
		gbc.gridy = 0; // linha
	    gbc.gridx = 0; // coluna
	    gbc.gridwidth = 1; // uma célula na linha
	    panel.add(lbData , gbc);
	    
	    gbc.gridy = 0; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(lbHora , gbc);
	    
	    gbc.insets = new Insets(4, 0, 4, 20);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(dtcData , gbc);
	    
	    gbc.insets = new Insets(4, 0, 4, 4);
	    gbc.gridy = 1; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(comboHoras , gbc);
	    
	    gbc.gridy = 1; // linha
	    gbc.gridx = 2; // coluna
	    panel.add(comboMinutos , gbc);
	    
	    gbc.gridy = 2; // linha
	    gbc.gridx = 0; // coluna
	    panel.add(lbAgencia , gbc);
		
	    gbc.gridwidth = 2; // duas célula na linha
	    gbc.gridy = 2; // linha
	    gbc.gridx = 1; // coluna
	    panel.add(comboAgencia , gbc);
		
		add(panel);
	}

	private void initComponents() {
		lbData = new Rotulo(RotuloNomes.getDATA());
		lbHora = new Rotulo(RotuloNomes.getHORA());
		lbAgencia = new Rotulo(RotuloNomes.getAGENCIA());
		dtcData = new JDateChooser();
		dtcData.setLocale(Idioma.bn.getLocale());
		initComboBoxes();
		
	}

	private void initComboBoxes() {
		for(int i = 0; i < 24 ; i++){
			if(i < 10){
				horas[i] = "0"+i;
			}
			else{
				horas[i] = ""+i;
			}
		}
		for(int i = 0; i < 60 ; i++){
			if(i < 10){
				minutos[i] = "0"+i;
			}
			else{
				minutos[i] = ""+i;
			}
		}
		
		comboHoras = new JComboBox(horas);
		comboMinutos = new JComboBox(minutos);
		comboAgencia = new JComboBox();
		
	}
	
	public void preencheComboAgencia(ArrayList objects){
		for(int i = 0; i < objects.size() ; i++){
			comboAgencia.addItem(objects.get(i));
		}
	}
	
	public void preencheComboAgencia(Object object) {
		comboAgencia.addItem(object);
	}
	
	public Object getComboBoxAgencia(){
		return comboAgencia.getSelectedItem();
	}
	
	public Date getData(){
		Calendar c = GregorianCalendar.getInstance();
		try{
			c.setTime(dtcData.getDate());
			c.set(GregorianCalendar.HOUR_OF_DAY, getHoras());
			c.set(GregorianCalendar.MINUTE, getMinutos());
		
			return c.getTime();
		}catch(Exception e){
			return null;
		}
	}
	
	private int getMinutos(){
		return Integer.parseInt((String) comboMinutos.getSelectedItem());
	}
	
	private int getHoras(){
		return Integer.parseInt((String) comboHoras.getSelectedItem());
	}

	
	
}
