package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factory.FabricaImagenes;
import GUI.GUI;
import Logica.Celda;
import Logica.Singleton;

public class ObjetoGraficoT extends OGTorre {
	
	public ObjetoGraficoT(Celda c,ImageIcon imagen) {
		grafico=new JLabel(imagen);
		GUI gui=Singleton.getGui();
		grafico.setBounds((c.getColumna()*120)+20, (c.getFila()*100)-15 , 80, 90);
		gui.add(grafico);
		grafico.setVisible(true);
		gui.repaint();
		//System.out.println("creado el grafico: "+grafico);
		
	}
	
	public ObjetoGraficoT(Celda c,ImageIcon imagen,int correccion) {
		grafico=new JLabel(imagen);
		GUI gui=Singleton.getGui();
		grafico.setBounds((c.getColumna()*120)+20+correccion, (c.getFila()*100)-15 , 80, 90);
		gui.add(grafico);
		grafico.setVisible(true);
		gui.repaint();
		//System.out.println("creado el grafico: "+grafico);
	}
}
