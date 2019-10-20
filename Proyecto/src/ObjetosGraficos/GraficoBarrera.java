package ObjetosGraficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Logica.PowerUp;
import Logica.Singleton;

public class GraficoBarrera extends ObjetoGrafico {
	PowerUp miPowerUp;
	boolean activado;
	
	public GraficoBarrera(int x,int y,PowerUp pu) {
		miPowerUp=pu;
		activado=false;
		AbstractFactoryT fabrica=new fabricaT();
		grafico=new JLabel(fabrica.barrera());
		grafico.setVisible(true);
		grafico.setBounds(x+((x-40) % 120), y, 5, 50);  //asi queda bien pegado al borde derecho de la celda
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
