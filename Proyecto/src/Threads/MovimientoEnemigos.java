package Threads;

import java.util.LinkedList;
import java.util.Random;

import Estructuras.Charco;
import Estructuras.Obstaculo;
import GUI.GUI;
import Logica.Celda;
import Logica.Mapa;
import Logica.Singleton;
import Logica.Enemigos.Enemigo1;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;

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
			
			crearObstaculo();
			mapa.mover();
			//System.out.println("---------------------");
		}
	}
	
	private Enemigo crearEnemigo() {
		int fila=(int) (Math.random()*6);
		if(fila==6)
			fila=0;
		
		Enemigo nuevo=new Enemigo1(mapa.getCelda(fila));
		nuevo.setGrafico(fila);
		
		mapa.insertarEnemigo(nuevo,fila);
		listaEnemigos.addLast(nuevo);
		
		return nuevo;
	}

	private void  crearObstaculo() {
		Random rand=new Random();
		Mapa mapa=Singleton.getMapa();
		
		int probabilidad=rand.nextInt(5);
		
		if(probabilidad==1 || probabilidad==2) {
			boolean insercion=false;
			int cont=0;
			Estructura est=null;
			
			while(!insercion && cont<10) {
				int fila=rand.nextInt(6); //cambiar por metodo en el mapa de ultima
			
				int columna=rand.nextInt(10);
				
				Celda celda=mapa.getCelda(fila,columna);
				
				if(probabilidad==1)
					est=new Charco(celda);
				else est=new Obstaculo(celda);
				
				insercion=mapa.insertarEstructura(est, fila, columna);
				cont++;
				
				if(!insercion)
					est.Eliminar();
			}
			
		}
			
		
		

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


