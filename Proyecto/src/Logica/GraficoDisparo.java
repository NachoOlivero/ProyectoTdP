package Logica;

import javax.swing.JLabel;

import GUI.fabricaT;
import Logica.abstracto.ObjetoGrafico;

public class GraficoDisparo extends ObjetoGrafico {
	public GraficoDisparo() {
		fabricaT f=new fabricaT();
		grafico=new JLabel(f.Enemigo1());
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
