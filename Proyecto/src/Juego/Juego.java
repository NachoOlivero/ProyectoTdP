package Juego;

import GUI.GUI;
import Logica.Mapa;
import Logica.SingletonMapa;
import Threads.HiloGui;
import Threads.MovimientoEnemigos;

public class Juego {
	public static void main(String args[]) {
		GUI gui=new GUI();
		gui.setVisible(true);
		Mapa mapa=SingletonMapa.getMapa();
		
		MovimientoEnemigos movEnemigos= new MovimientoEnemigos(mapa,gui);
		HiloGui contador=new HiloGui(gui,movEnemigos);
	
		movEnemigos.run();
		contador.run();
	}
}
