package Juego;

import GUI.GUI;
import Logica.Mapa;
import Logica.Singleton;
import Threads.HiloGui;
import Threads.MovimientoEnemigos;

public class Juego {
	private static MovimientoEnemigos movEnemigos;
	private static HiloGui contador;
	
	public static void main(String args[]) {
		GUI gui=Singleton.getGui();
		gui.setVisible(true);
		Mapa mapa=Singleton.getMapa();
		
		movEnemigos= new MovimientoEnemigos(mapa,gui);
		contador=new HiloGui(gui,movEnemigos);
	
		movEnemigos.run();
		contador.run();
	}
	
	public void gameOver(){
		//movEnemigos.destroy();
		//HiloGui.setFondo(new JPanel("Game Over"));
	}
}
