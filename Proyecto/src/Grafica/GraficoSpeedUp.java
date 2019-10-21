package Grafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Logica.Singleton;
import PowerUp.PowerUp;

public class GraficoSpeedUp extends ObjetoGrafico {
	protected PowerUp miPowerUp;
	
	public GraficoSpeedUp(int x,int y,PowerUp pu) {
		miPowerUp=pu;
		AbstractFactoryT f=new fabricaT();
		grafico=new JLabel(f.killAll());
		grafico.setBounds(x,y, 50, 50);
		grafico.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		          miPowerUp.comenzar();
		        }
		      });
		Singleton.getGui().add(grafico);
	}
}

