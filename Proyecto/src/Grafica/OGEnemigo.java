package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import GUI.Eliminador;
import Logica.Singleton;

public class OGEnemigo extends OGMovil {
	
	public OGEnemigo(ImageIcon imagen,int fila) {
		grafico=new JLabel(imagen);
		grafico.setBounds(1200,fila,50,50);
	}
	
	public void setImagen(ImageIcon imagen) {
		grafico.setIcon(imagen);
	}
}
