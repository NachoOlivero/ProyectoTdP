package ObjetosGraficos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factory.fabricaT;

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
	}
	
	public int ubicacionGrafico() {
		return (grafico.getX()-50)/120;
	}
}
