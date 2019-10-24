package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factory.fabricaT;
import Logica.Singleton;

public class GraficoDisparo extends OGMovil {
	
	public GraficoDisparo(int x,int y,ImageIcon e) {
		
		grafico=new JLabel(e);
		grafico.setBounds(x*120,y*100,30,30);
		Singleton.getGui().add(grafico);
	}
	
	public void avanzar() {
		grafico.setBounds(grafico.getX()+1, grafico.getY(), 110, 60);
	}

	public JLabel getGrafico() {
		return grafico;
	}
	
	public void eliminar() {
		grafico.setVisible(false);
		grafico.setIcon(null);
		Singleton.getGui().remove(grafico);
	}

	public int ubicacionGrafico() {
		return 0;
	}

	public void setPosicion(int pos) {
		
	}

}
