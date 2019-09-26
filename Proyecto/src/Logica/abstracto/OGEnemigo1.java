package Logica.abstracto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.fabricaT;

public class OGEnemigo1 extends OGEnemigo {
	
	public OGEnemigo1() {
		fabricaT f=new fabricaT();
		grafico=new JLabel(f.Enemigo1());
	}
	public void avanzar() {
		grafico.setBounds(grafico.getX()-10, grafico.getY(), 50, 50);
	}

	public JLabel getGrafico() {
		return grafico;
	}
	public void eliminar() {
		grafico.setVisible(false);
		grafico.setIcon(null);
		grafico.getParent().remove(grafico);
	}
}
