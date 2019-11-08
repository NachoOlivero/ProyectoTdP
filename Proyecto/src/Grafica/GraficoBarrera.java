package Grafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
import Logica.Singleton;
import PowerUp.PowerUp;

public class GraficoBarrera extends ObjetoGrafico {
	PowerUp miPowerUp;
	boolean activado;
	
	public GraficoBarrera(int x,int y,PowerUp pu,boolean clickable) {
		miPowerUp=pu;
		activado=false;
		AbstractFactoryT fabrica=new FabricaImagenes();
		grafico=new JLabel(fabrica.barrera());
		grafico.setVisible(true);
		grafico.setBounds(x+(120-((x-40) % 120)), y, 20, 50);  //asi queda bien pegado al borde derecho de la celda
		if(clickable)
			grafico.addMouseListener((new MouseAdapter() {
			      public void mouseClicked(MouseEvent me) {
			          if(!activado) {
			        	  miPowerUp.comenzar();
			        	  activado=true;
			          }
			         
			        }
			      }));
		Singleton.getGui().add(grafico);
	}
	public GraficoBarrera(int x, int y) {
		AbstractFactoryT fabrica=new FabricaImagenes();
		grafico=new JLabel(fabrica.barrera());
		grafico.setVisible(true);
		grafico.setBounds(x*120+50,y*100,20,50);
		Singleton.getGui().add(grafico);
		Singleton.getGui().repaint();
	}

}
