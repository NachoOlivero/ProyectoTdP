package Juego;

import GUI.GUI;
import Logica.Singleton;
import Threads.HiloGui;
import Threads.MovimientoEnemigos;

public class Juego {
	private static MovimientoEnemigos movEnemigos;
	private static HiloGui contador;
	
	public static void main(String args[]) {
		Start();
	}
	
	public static void Start() {
		GUI gui=Singleton.getGui();
		gui.setVisible(true);
		
		movEnemigos= Singleton.getMovEne();
		contador=Singleton.getHilo();
	
		movEnemigos.run();
		contador.run();
		
	}
	
	public static void reStart() {
		
		movEnemigos= Singleton.getMovEne();
		movEnemigos.resetContador();
		movEnemigos.run();
		
	
		
	}
}
