package PowerUp;

import java.util.Timer;
import java.util.TimerTask;

import Grafica.GraficoBarrera;
import Logica.Celda;
import Logica.Singleton;

public class Barrera extends PowerUp {

	protected Timer timer;
	protected Celda celda;
	
	public Barrera(int x,int y) {
		grafico=new GraficoBarrera(x,y,this);
		timer=new Timer();
		celda=Singleton.getMapa().getCelda(y/100,(x-40)/120);
		System.out.println("Celda del powerup: "+celda);
		System.out.println("Fila del powerup: "+celda.getY()+"Coumna del powerup: "+celda.getX());
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
