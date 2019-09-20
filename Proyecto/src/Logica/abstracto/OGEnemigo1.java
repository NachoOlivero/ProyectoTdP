package Logica.abstracto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.fabricaT;

public class OGEnemigo1 extends OGEnemigo {
	
	public OGEnemigo1() {
		fabricaT f=new fabricaT();
		ImageIcon imagen=f.Torre1();
		grafico=new JLabel(imagen);
	}
	
	public void avanzar() {
		grafico.setBounds(grafico.getX()-10, grafico.getY(), 50, 50);
	}

}
