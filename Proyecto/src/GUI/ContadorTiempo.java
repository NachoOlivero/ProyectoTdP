package GUI;

import java.util.Random;

import javax.swing.JLabel;

import Logica.Mapa;
import Logica.Enemigos.Enemigo1;
import Logica.abstracto.Enemigo;
import Logica.abstracto.ObjetoGrafico;

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
			
		}
	}
	
	private Enemigo crearEnemigo() {
		JLabel grafico;
		Enemigo nuevo=new Enemigo1();
		Enemigo nuevo=new Enemigo1(null);
		Random r=new Random();
		int fila=r.nextInt(5);
		mapa.insertarEnemigo(nuevo,fila);
		System.out.println(nuevo.getGrafico());
		ObjetoGrafico aux=nuevo.getGrafico();
		grafico=(aux.getGrafico());
		gui.agregarEnemigo(grafico);
		nuevo.getGrafico().getGrafico().setBounds(1100, 500-100*fila, 50, 50);
		gui.add(nuevo.getGrafico().getGrafico());
		
		return nuevo;
	}
}
