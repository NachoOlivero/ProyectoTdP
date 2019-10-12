package Logica;

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
}
