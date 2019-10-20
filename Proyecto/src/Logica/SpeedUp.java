package Logica;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Logica.abstracto.Torre;
import ObjetosGraficos.GraficoSpeedUp;

public class SpeedUp extends PowerUp {
	protected Timer timer;
	
	public 	SpeedUp(int x,int y) {
		grafico=new GraficoSpeedUp(x,y,this);
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
	
	
	public void eliminar() {
		grafico.eliminar();
		Singleton.getMapa().eliminarPowerUp(this);
	}
	
	private class SpeedUpAction extends TimerTask {

		public void run() {
			List<Torre> listaTorres=Singleton.getMapa().getListaTorres();
			for(Torre t:listaTorres)
				t.resetCooldown();
			
		}
	
	
	}
		
	
}

