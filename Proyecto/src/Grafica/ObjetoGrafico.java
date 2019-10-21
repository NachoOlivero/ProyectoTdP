package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import GUI.GUI;
import Logica.Singleton;

public abstract class ObjetoGrafico {
	protected JLabel grafico;
	
	public JLabel getGrafico() {
		return grafico;
	}

	public void eliminar() {
		GUI gui=Singleton.getGui();
		grafico.setVisible(false);
		grafico.setIcon(null);
		gui.remove(grafico);

	}
}
