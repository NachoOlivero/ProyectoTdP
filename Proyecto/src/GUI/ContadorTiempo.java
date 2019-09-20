package GUI;

import java.util.Random;

import Logica.Mapa;
import Logica.Enemigos.Enemigo1;
import Logica.abstracto.Enemigo;

public class ContadorTiempo extends Thread {

	private GUI gui;
	private Mapa mapa;

	public ContadorTiempo(GUI gui,Mapa mapa) {
		this.gui = gui;
		this.mapa=mapa;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			crearEnemigo();
			mapa.mover();
			//gui.moverImagen();
			
		}
	}
	
	private Enemigo crearEnemigo() {
		Enemigo nuevo=new Enemigo1();
		Random r=new Random();
		int fila=r.nextInt(5);
		mapa.insertarEnemigo(nuevo,fila);
		System.out.println(nuevo.getGrafico());
		gui.add(nuevo.getGrafico().getGrafico());
		
		return nuevo;
	}
}
