package PowerUp;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Grafica.GraficoSpeedUp;
import Logica.Singleton;
import Logica.abstracto.Torre;

public class SpeedUp extends PowerUp {
	protected Timer timer;
	
	public 	SpeedUp(int x,int y) {
		grafico=new GraficoSpeedUp(x,y,this);
		timer=new Timer();
	}
	
	public SpeedUp() {		//para cuando lo compra el jugador
		timer=new Timer();
	}


	public void comenzar() {
		List<Torre> listaTorres=Singleton.getMapa().getListaTorres();
		for(Torre t:listaTorres) {
			int vel=t.getCooldown();
			t.setCooldown(vel/2);
		}
		eliminar();
		timer.schedule(new SpeedUpAction(), 5000);
	}
	
	public void ubicar(int x,int y) {}
	
	private class SpeedUpAction extends TimerTask {

		public void run() {
			List<Torre> listaTorres=Singleton.getMapa().getListaTorres();
			for(Torre t:listaTorres)
				t.resetCooldown();
			
		}
	
	
	}
	public static int getCosto() {
		return 500;
	}
		
	
}

