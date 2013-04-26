//Classe JFrameDefault
package View.Frames;

import javax.swing.JFrame;

public abstract class JFrameDefault extends JFrame{

		
	public void montaJFrame(String titulo) {
		setTitle(titulo);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	}
	
	//M�TODO ABSTRATO PARA MONTAR/CRIAR UMA GUI DO JFRAME
	public abstract void montaGUI();
	
	//M�TODO ABSTRATO PARA INICIALIZAR TODOS OS COMPONENTES DE UM JFRAME
	public abstract void initComponents();
	
}
