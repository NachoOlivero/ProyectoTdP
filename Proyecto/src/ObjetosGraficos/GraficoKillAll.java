package ObjetosGraficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Logica.PowerUp;
import Logica.Singleton;

public class GraficoKillAll extends ObjetoGrafico {
	protected PowerUp miPowerUp;
	
	public GraficoKillAll(int x,int y,MouseListener oyente,PowerUp pu) {
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
