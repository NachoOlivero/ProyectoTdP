package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factory.fabricaT;
import Logica.Celda;
import Logica.Disparo;
import Logica.Singleton;

public class GraficoDisparoEne extends OGMovil {
	

	public GraficoDisparoEne(int x,int y,int posRelativa,ImageIcon l) {
		grafico=new JLabel(l);
		grafico.setBounds(x*posRelativa,y*100,30,30);
		Singleton.getGui().add(grafico);
	}

	@Override
	public void avanzar() {
		// TODO Auto-generated method stub
		
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
