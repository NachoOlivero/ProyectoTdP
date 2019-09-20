package Juego;

import GUI.ContadorTiempo;
import GUI.GUI;
import Logica.Mapa;

public class Juego {
	public static void main(String args[]) {
		GUI gui=new GUI();
		gui.setVisible(true);
		Mapa mapa=new Mapa(6,10);
		
		ContadorTiempo contador=new ContadorTiempo(gui,mapa);
		contador.run();
		
		
	}
}
