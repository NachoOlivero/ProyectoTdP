package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factory.FabricaImagenes;
import Logica.Celda;
import Logica.Disparo;
import Logica.Singleton;

public class GraficoDisparoEne extends OGMovil {
	

	public GraficoDisparoEne(int x,int y,int posRelativa,ImageIcon l) {
		grafico=new JLabel(l);
		grafico.setBounds((x*120)+posRelativa,y*100,30,30);
		grafico.setVisible(true);
		Singleton.getGui().add(grafico);
	}

	@Override
	public void avanzar() {
		grafico.setBounds(grafico.getX()-1, grafico.getY(), 110, 60);
		
	}

	@Override
	public int ubicacionGrafico() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosicion(int pos) {
		// TODO Auto-generated method stub
		
	}

	

}
