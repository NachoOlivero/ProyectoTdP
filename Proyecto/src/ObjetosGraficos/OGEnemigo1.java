package ObjetosGraficos;

import javax.swing.JLabel;

import Factory.fabricaT;
import Logica.Singleton;

public class OGEnemigo1 extends OGMovil {
	
	public OGEnemigo1() {
		fabricaT f=new fabricaT();
		grafico=new JLabel(f.Enemigo1());
	}
	public void avanzar() {
		grafico.setBounds(grafico.getX()-1, grafico.getY(), 50, 50);
	}

	public JLabel getGrafico() {
		return grafico;
	}
	
	public int ubicacionGrafico() {
		return (grafico.getX()-50)/120;
	}
	
	public void setPosicion(int pos) {
		grafico.setBounds(1220,pos*100, 50, 50);
		Singleton.getGui().add(grafico);
	}
}
