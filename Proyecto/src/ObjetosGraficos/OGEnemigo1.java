package ObjetosGraficos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factory.fabricaT;
import Logica.Singleton;

public class OGEnemigo1 extends OGMovil {
	
	public OGEnemigo1() {
		fabricaT f=new fabricaT();
		grafico=new JLabel(f.Enemigo1());
	}
	public void avanzar() {
		grafico.setBounds(grafico.getX()-10, grafico.getY(), 50, 50);
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
		return (grafico.getX()-50)/120;
	}
}
