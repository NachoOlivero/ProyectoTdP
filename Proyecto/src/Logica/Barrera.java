package Logica;

import java.util.Timer;
import java.util.TimerTask;

import ObjetosGraficos.GraficoBarrera;

public class Barrera extends PowerUp {

	protected Timer timer;
	protected Celda celda;
	
	public Barrera(int x,int y) {
		grafico=new GraficoBarrera(x,y,this);
		timer=new Timer();
		celda=Singleton.getMapa().getCelda(y%6,(x-40)%10);
		System.out.println("Celda del powerup: "+celda);
	}

	public void comenzar() {
		celda.setBarrera(true);
		timer.schedule(new EliminarBarrera(), 10000);
		
	}
	
	private class EliminarBarrera extends TimerTask {
		public void run() {
			eliminar();
			celda.setBarrera(false);
		}
	}
}
