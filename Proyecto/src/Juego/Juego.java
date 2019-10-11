package Juego;

import GUI.GUI;
import Logica.Mapa;
import Logica.Singleton;
import Threads.HiloGui;
import Threads.MovimientoEnemigos;

public class Juego {
	public static void main(String args[]) {
		GUI gui=Singleton.getGui();
		gui.setVisible(true);
		Mapa mapa=Singleton.getMapa();
		
		MovimientoEnemigos movEnemigos= new MovimientoEnemigos(mapa,gui);
		HiloGui contador=new HiloGui(gui,movEnemigos);
	
		movEnemigos.run();
		contador.run();
	}
}
