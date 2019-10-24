package Threads;

import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Estructuras.Charco;
import Estructuras.Obstaculo;
import GUI.GUI;
import GUI.GUIDyV;
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
	protected GUI gui;
	protected int coolDown=0;
	protected static boolean gameOver;
	protected GUIDyV gui2;
	protected boolean gane;
	protected Timer temp;
	
	public MovimientoEnemigos(Mapa map,GUI g) {
		listaEnemigos=new LinkedList<Enemigo>();
		mapa=map;
		gameOver=false;
		gane=false;
		gui=g;
		gui2=null;
		temp= new Timer();
	}
	
	public void run() {
		temp.schedule(new Victoria(), 300000);
		while(!gameOver && !gane) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(coolDown==0) {
				crearEnemigo();
				coolDown=20;
			}
			else coolDown--;
			
			crearObstaculo();
			mapa.mover();
		}
		mapa.inicializarCeldas(10,6);
		gui.setVisible(false);
		if(!gane)
			gui2 = new GUIDyV("./GameOver.png");
		else
			gui2=new GUIDyV("./Victory.png");
		
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
		
		int probabilidad=rand.nextInt(500);
		
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
	public static void Game() {
		gameOver=true;
	}
	


	public void eliminarAll() {
			mapa.KillAll();
			//cant--;
	}

	public void eliminarEnemigo() {
			if(!(listaEnemigos.isEmpty())) {
				Enemigo eliminado=listaEnemigos.removeFirst();
				eliminado.Eliminar();
				Singleton.getGui().repaint();
				//cant--;
			}
	}
	private class Victoria extends TimerTask {
		public void run() {
			gane=true;
		}
	}

	
}


