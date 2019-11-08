package PowerUp;

import java.util.Timer;
import java.util.TimerTask;

import Grafica.GraficoBarrera;
import Logica.Celda;
import Logica.Singleton;

public class Barrera extends PowerUp {

	protected Timer timer;
	protected Celda celda;
	
	public Barrera(int x,int y) {  //en este caso es dropeada por un enemigo
		grafico=new GraficoBarrera(x,y,this,true);
		ubicar(y/100,(x-40)/120);
	}
	
	public Barrera() {}  //para cuando la compra el cliente
	
	public void ubicar(int f,int c) {
		boolean comprado=grafico==null;
		
		timer=new Timer();
		if(comprado)
			grafico=new GraficoBarrera(c,f,this,false);
		celda=Singleton.getMapa().getCelda(f,c);
		
		if(comprado)
			comenzar();
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
	public static int getCosto() {
		return 300;
	}
}
