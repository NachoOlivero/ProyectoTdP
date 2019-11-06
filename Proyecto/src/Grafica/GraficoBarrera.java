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
	
	public GraficoBarrera(int x,int y,PowerUp pu) {
		miPowerUp=pu;
		activado=false;
		AbstractFactoryT fabrica=new FabricaImagenes();
		grafico=new JLabel(fabrica.barrera());
		grafico.setVisible(true);
		grafico.setBounds(x+(120-((x-40) % 120)), y, 20, 50);  //asi queda bien pegado al borde derecho de la celda
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

}
