package Threads;

import java.util.LinkedList;
import java.util.Random;

import GUI.GUI;
import Logica.Mapa;
import Logica.Enemigos.Enemigo1;
import Logica.abstracto.Enemigo;

public class MovimientoEnemigos extends Thread {
	protected volatile boolean execute;
	
	protected Mapa mapa;
	protected LinkedList<Enemigo> listaEnemigos;
	protected GUI gui; // por ahora tine la gui
	protected int coolDown=0;
	
	public MovimientoEnemigos(Mapa map,GUI g) {
		listaEnemigos=new LinkedList<Enemigo>();
		mapa=map;
		gui=g;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(coolDown==0) {
				crearEnemigo();
				coolDown=20;
			}
			else coolDown--;
			
			mapa.mover();
			//System.out.println("---------------------");
		}
	}
	
	private Enemigo crearEnemigo() {
		int fila=(int) (Math.random()*6);
		if(fila==6)
			fila=0;
		Enemigo nuevo=new Enemigo1(mapa.getCelda(fila, 9));
		
		mapa.insertarEnemigo(nuevo,fila);
		listaEnemigos.addLast(nuevo);
		nuevo.getGrafico().getGrafico().setBounds(1220,fila*100, 50, 50);
		gui.add(nuevo.getGrafico().getGrafico());
		//cant++;
		
		return nuevo;
	}



	public void eliminarAll() {
			mapa.KillAll();
			//cant--;
	}

	public void eliminarEnemigo() {
			if(!(listaEnemigos.isEmpty())) {
				Enemigo eliminado=listaEnemigos.removeFirst();
				eliminado.Eliminar();
				gui.repaint();
				//cant--;
			}
	}
	
}


