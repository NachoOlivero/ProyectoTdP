package Juego;

import GUI.GUI;
import Logica.Mapa;
import Threads.HiloGui;
import Threads.MovimientoEnemigos;

public class Juego {
	public static void main(String args[]) {
		GUI gui=new GUI();
		gui.setVisible(true);
		Mapa mapa=new Mapa(6,10);
		
		MovimientoEnemigos movEnemigos= new MovimientoEnemigos(mapa,gui);
		HiloGui contador=new HiloGui(gui,movEnemigos);
	
		movEnemigos.run();
		contador.run();
	}
}
