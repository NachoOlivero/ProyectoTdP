package ObjetosGraficos;

import javax.swing.JLabel;

import Factory.fabricaT;
import Logica.Singleton;

public class GraficoDisparo extends OGMovil {
	public GraficoDisparo(int x,int y) {
		fabricaT f=new fabricaT();
		grafico=new JLabel(f.disparo());
		grafico.setBounds(x*120-60,y*100,110,60);
		Singleton.getGui().add(grafico);
	}
	
	public void avanzar() {
		grafico.setBounds(grafico.getX()+10, grafico.getY(), 110, 60);
	}

	public JLabel getGrafico() {
		return grafico;
	}
	
	public void eliminar() {
		grafico.setVisible(false);
		grafico.setIcon(null);
	}

	@Override
	public int ubicacionGrafico() {
		return 0;
	}

}
