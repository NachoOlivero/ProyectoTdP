package Logica;

import GUI.GUI;
import Threads.HiloGui;
import Threads.MovimientoEnemigos;

public class Singleton {
	protected static Mapa mapa;
	protected static GUI gui;
	protected static Jugador ju;
	protected static MovimientoEnemigos ene;
	protected static HiloGui hilo;
	
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
	public synchronized static MovimientoEnemigos getMovEne() {
		if(ene != null)
			return ene;
		else {
			ene = new MovimientoEnemigos();
			return ene;
		}
	}
	public synchronized static HiloGui getHilo() {
		if(hilo != null)
			return hilo;
		else {
			hilo = new HiloGui();
			return hilo;
		}
	}
	
}
