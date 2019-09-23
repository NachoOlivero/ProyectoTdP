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
	int aux=0;

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
				crearEnemigo();
				aux++;
				mapa.mover();
				System.out.println(aux);
		}
	}
	
	private Enemigo crearEnemigo() {
		int numero=(int) (Math.random()*6);
		Enemigo nuevo=new Enemigo1(mapa.getCelda(5, numero));
		mapa.insertarEnemigo(nuevo,numero);
		//System.out.println(nuevo.getGrafico());
		ObjetoGrafico aux=nuevo.getGrafico();
		//gui.agregarEnemigo(grafico);
		nuevo.getGrafico().getGrafico().setBounds(1200, 500-100*numero, 50, 50);
		gui.add(nuevo.getGrafico().getGrafico());
		
		return nuevo;
	}
}
