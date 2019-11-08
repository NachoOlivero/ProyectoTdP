package Juego;

import GUI.GUI;
import GUI.GUIFinal;
import GUI.Inicio;
import Logica.Mapa;
import Logica.Singleton;
import Threads.HiloGui;
import Threads.MovimientoEnemigos;

public class Juego {
	private static MovimientoEnemigos movEnemigos;
	private static HiloGui contador;
	
	public static void main(String args[]) {
		GUIFinal gui= new GUIFinal();
		gui.setVisible(true);
		//Start();
	}
	
	public static void Start() {
		GUI gui=Singleton.getGui();
		//gui.setVisible(true);
		Mapa mapa=Singleton.getMapa();
		
		movEnemigos= new MovimientoEnemigos(mapa,gui);
		contador=new HiloGui(gui,movEnemigos);
	
		movEnemigos.run();
		contador.run();
		
	}
	
	public static void reStart() {
		GUI gui=Singleton.getGui();
		Mapa mapa=Singleton.getMapa();
		
		gui.setVisible(true);
		mapa.inicializarCeldas(6, 10);
		
		movEnemigos= new MovimientoEnemigos(mapa,gui);
	
		movEnemigos.run();
		contador.run();
		
		//gui.repaint();
		
	}
}
