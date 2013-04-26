//Classe Botao
package View.Botoes;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton; 
import javax.swing.SwingConstants;

 
public class Botao extends JButton 
{
//	Bot�o simples sem �cone
//	@rotulo - Nome que ir� aparecer no Bot�o
//	@toolTipText - Dica de texto que ir� aparecer quando o usu�rio passar o mouse em cima do bot�o
   public Botao(String rotulo , String toolTipText) 
   { 
      super(rotulo);
      setToolTipText(toolTipText);
   }
   
//   Bot�o com �cone
//	@rotulo - Nome que ir� aparecer no Bot�o
//	@toolTipText - Dica de texto que ir� aparecer quando o usu�rio passar o mouse em cima do bot�o
//  @pathImage - Caminho onde est� a Imagem
//  @isBackground - deseja deixar o fundo do bot�o (true) ou n�o (false)
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
   
   // Bot�o sem o R�tulo por�m com �cone
   //	@toolTipText - Dica de texto que ir� aparecer quando o usu�rio passar o mouse em cima do bot�o
   //	@pathImage - Caminho onde est� a Imagem
   //	@isBackground - deseja deixar o fundo do bot�o (true) ou n�o (false)
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