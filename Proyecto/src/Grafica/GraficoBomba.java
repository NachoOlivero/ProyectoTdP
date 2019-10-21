package Grafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Factory.fabricaT;
import Logica.Singleton;
import PowerUp.Bomba;

public class GraficoBomba extends ObjetoGrafico{
	Bomba miPowerUp;
	
	public GraficoBomba(int x,int y,Bomba bomba) {
		fabricaT f=new fabricaT();
		grafico=new JLabel(f.Torre1());
		grafico.setVisible(true);
		miPowerUp=bomba;
		grafico.setBounds(x,y,30,30);
		grafico.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		         Singleton.getJugador().insertarBomba(miPowerUp);
		         eliminar();
		        }
		      });
		Singleton.getGui().add(grafico);
	}

}
