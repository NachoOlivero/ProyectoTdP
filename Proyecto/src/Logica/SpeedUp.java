package Logica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Logica.abstracto.Torre;
import ObjetosGraficos.GraficoSpeedUp;
import ObjetosGraficos.ObjetoGrafico;

public class SpeedUp implements PowerUp{
	protected ObjetoGrafico grafico;
	protected MouseListener oyente;
	protected Timer timer;
	
	public 	SpeedUp(int x,int y) {
		grafico=new GraficoSpeedUp(x,y,oyente,this);
		timer=new Timer();
	}


	public void comenzar() {
		List<Torre> listaTorres=Singleton.getMapa().getListaTorres();
		for(Torre t:listaTorres) {
			int vel=t.getCooldown();
			t.setCooldown(vel/2);
		}
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
			eliminar();
			
		}
	
	
	}
		
	
}

