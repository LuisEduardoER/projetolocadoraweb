//Classe Botao
package View.Botoes;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton; 
import javax.swing.SwingConstants;

 
public class Botao extends JButton 
{
//	Botão simples sem Ícone
//	@rotulo - Nome que irá aparecer no Botão
//	@toolTipText - Dica de texto que irá aparecer quando o usuário passar o mouse em cima do botão
   public Botao(String rotulo , String toolTipText) 
   { 
      super(rotulo);
      setToolTipText(toolTipText);
   }
   
//   Botão com Ícone
//	@rotulo - Nome que irá aparecer no Botão
//	@toolTipText - Dica de texto que irá aparecer quando o usuário passar o mouse em cima do botão
//  @pathImage - Caminho onde está a Imagem
//  @isBackground - deseja deixar o fundo do botão (true) ou não (false)
   public Botao(String rotulo , String toolTipText , String pathImage , boolean isBackground) 
   { 
      super(rotulo);
      setToolTipText(toolTipText);
      ImageIcon icon = new ImageIcon(pathImage);
      setIcon(icon);
      setVerticalTextPosition(SwingConstants.BOTTOM);
	  setHorizontalTextPosition(SwingConstants.CENTER);
	  if(isBackground == true){
		  setBackground(new Color(0, 0, 0, 0));
		  setUI(new MinhaButtonUI());
		  setContentAreaFilled(false);
		  setBorder(BorderFactory.createBevelBorder(Color.BITMASK));
	  }
   }
   
   // Botão sem o Rótulo porém com Ícone
   //	@toolTipText - Dica de texto que irá aparecer quando o usuário passar o mouse em cima do botão
   //	@pathImage - Caminho onde está a Imagem
   //	@isBackground - deseja deixar o fundo do botão (true) ou não (false)
   public Botao(String toolTipText , String pathImage , boolean isBackground) 
   { 
      
      setToolTipText(toolTipText);
      ImageIcon icon = new ImageIcon(pathImage);
      setIcon(icon);
      setVerticalTextPosition(SwingConstants.BOTTOM);
	  setHorizontalTextPosition(SwingConstants.CENTER);
	  if(isBackground == true){
		  setBackground(new Color(0, 0, 0, 0));
		  setUI(new MinhaButtonUI());
		  setContentAreaFilled(false);
		  setBorder(BorderFactory.createBevelBorder(Color.BITMASK));
	  }
   }
   
   
   
   
}