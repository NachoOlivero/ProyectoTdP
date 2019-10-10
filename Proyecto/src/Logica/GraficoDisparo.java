package Logica;

import javax.swing.JLabel;

import GUI.fabricaT;
import Logica.abstracto.ObjetoGrafico;

public class GraficoDisparo extends ObjetoGrafico {
	public GraficoDisparo(int x,int y) {
		fabricaT f=new fabricaT();
		grafico=new JLabel(f.Enemigo1());
		grafico.setBounds(x*120,y*100,50,50);
		Singleton.getGui().add(grafico);
	}
	
	public void avanzar() {
		grafico.setBounds(grafico.getX()+10, grafico.getY(), 50, 50);
	}

	public JLabel getGrafico() {
		return grafico;
	}
	
	public void eliminar() {
		grafico.setVisible(false);
		grafico.setIcon(null);
	}

}
