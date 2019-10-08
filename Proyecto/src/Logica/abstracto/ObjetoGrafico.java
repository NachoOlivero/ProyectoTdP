package Logica.abstracto;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public abstract class ObjetoGrafico {
	protected JLabel grafico;
	
	public JLabel getGrafico() {
		return grafico;
	}

	public void eliminar() {
		
		grafico.setVisible(false);
		grafico.setIcon(null);

	}
}
