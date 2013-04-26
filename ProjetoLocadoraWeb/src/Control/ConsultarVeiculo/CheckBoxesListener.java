//Classe CheckBoxesListener
package Control.ConsultarVeiculo;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import View.Panels.PainelAcessorio;

public class CheckBoxesListener implements ItemListener {
	
	private double NAVEGADOR_PRECO = 0.00;
	private double CADEIRA_PRECO = 0.00;
	private double MOTORISTA_PRECO = 0.00;
	private double total;
	private PainelAcessorio panelAcessorio;
	
	public CheckBoxesListener(PainelAcessorio panel){
		this.panelAcessorio = panel;
	}
	
	@Override
	public void itemStateChanged(ItemEvent ev) {
		if(ev.getSource() == panelAcessorio.getCheckCadeira()){
			if(panelAcessorio.getCheckCadeira().isSelected())
				CADEIRA_PRECO = 45.00;
			else
				CADEIRA_PRECO = 0.00;
		}
		if(ev.getSource() == panelAcessorio.getCheckMotorista()){
			if(panelAcessorio.getCheckMotorista().isSelected())
				MOTORISTA_PRECO = 30.00;
			else
				MOTORISTA_PRECO = 0.00;
		}
		if(ev.getSource() == panelAcessorio.getCheckNavegador()){
			if(panelAcessorio.getCheckNavegador().isSelected())
				NAVEGADOR_PRECO = 30.00;
			else
				NAVEGADOR_PRECO = 0.00;
		}
		total = NAVEGADOR_PRECO + CADEIRA_PRECO + MOTORISTA_PRECO;
		panelAcessorio.setTxtTotal(total);
	}
	
}
