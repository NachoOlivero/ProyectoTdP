package Grafica;

import javax.swing.ImageIcon;

import Logica.Celda;

public class GraficoDoble extends ObjetoGraficoT{
	
	public GraficoDoble(Celda c,ImageIcon imagen) {
		super(c,imagen);
		grafico.setBounds(grafico.getX()-60,grafico.getY(),220,90);
	}

}
