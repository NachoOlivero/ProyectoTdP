package Logica;

import java.util.Random;

import GUI.GUI;

public class Singleton {
	protected static Mapa mapa;
	protected static GUI gui;
	protected static Jugador ju;
	
	public synchronized static Mapa getMapa() {
		if(mapa != null)
			return mapa;
		else {
			mapa = new Mapa();
			mapa.inicializarCeldas(6, 10);
			return mapa;
		}
	}
	
	public synchronized static GUI getGui() {
		if(gui!=null)
			return gui;
		else {
			gui=new GUI();
			return gui;
		}
	}
	public synchronized static Jugador getJugador() {
		if(ju != null)
			return ju;
		else {
			ju = new Jugador();
			return ju;
		}
	}
	
	public static PowerUp powerUp(int x,int y) {
		Random rand=new Random();
		PowerUp pu=null;
		
		int caso=rand.nextInt(10);
		
		switch (caso) {
		case 0:
				pu=new SpeedUp(x,y);
				break;
		case 1:
				pu=new KillAll(x,y);
				break;
		
		}
		
		return pu;
	}
	
}
