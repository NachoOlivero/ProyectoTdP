package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Singleton;

public class OGEnemigo extends OGMovil {
	
	public OGEnemigo(ImageIcon imagen,int fila) {
		grafico=new JLabel(imagen);
		grafico.setBounds(1200,fila*100,90,90);
		Singleton.getGui().add(grafico);
	}
	
	public void setImagen(ImageIcon imagen) {
		grafico.setIcon(imagen);
	}
}
