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
import Logica.Enemigos.Enemigo2;
import Logica.Enemigos.Enemigo3;
import Logica.Enemigos.Enemigo4;
import Logica.Enemigos.EnemigoJefe;
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
	protected int contador;
	
	public MovimientoEnemigos(Mapa map,GUI g) {
		listaEnemigos=new LinkedList<Enemigo>();
		mapa=map;
		gameOver=false;
		gane=false;
		gui=g;
		gui2=null;
		temp= new Timer();
		contador=0;
	}
	
	public void run() {
		temp.schedule(new Victoria(), 300000);
		while(!gameOver && !gane) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			contador++;
			if(coolDown==0) {
				crearEnemigo(contador);
				coolDown=20;
			}
			else coolDown--;
			
			crearObstaculo();
			mapa.mover();
		}
		mapa.inicializarCeldas(6,10);
		gui.setVisible(false);
		if(!gane)
			gui2 = new GUIDyV("./GameOver.png");
		else
			gui2=new GUIDyV("./Victory.png");
		
	}
	
	private void crearEnemigo(int contador) {
		int fila=(int) (Math.random()*6);
		if(fila==6)
			fila=0;
		
		Enemigo nuevo=enemigoRandom(contador,mapa.getCelda(fila));//new Enemigo1(mapa.getCelda(fila));
		
		if(nuevo!=null) {
			nuevo.setGrafico(fila);
			mapa.insertarEnemigo(nuevo,fila);
			listaEnemigos.addLast(nuevo);
		}
		
	}

	private void  crearObstaculo() {
		Random rand=new Random();
		Mapa mapa=Singleton.getMapa();
		
		int probabilidad=rand.nextInt(500);
		
		if(probabilidad==1 || probabilidad==2) {
			boolean sePuedeInsertar=false;
			int cont=0;
			Estructura est=null;
			
			while(!sePuedeInsertar && cont<10) {
				int fila=rand.nextInt(6); //cambiar por metodo en el mapa de ultima
			
				int columna=rand.nextInt(10);
				
				Celda celda=mapa.getCelda(fila,columna);
				
				sePuedeInsertar=!celda.hayEstructura();
				
				if(sePuedeInsertar) {
					if(probabilidad==1)
						est=new Charco(celda);
					else est=new Obstaculo(celda);
					
					mapa.insertarEstructura(est, fila, columna);
				}
				
				cont++;
			}
			
		}
			
		
		

	}
	public static void GameOver() {
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
	
	public Enemigo enemigoRandom(int contador,Celda celda) {
		int caso=-1;
		Enemigo eneRet=null;
		
		if(contador<2000)
			if(contador<1500)
				if(contador<1000)
					if(contador<500)
						if(contador<200)
							if(contador>100)
								caso=0;
							else caso=-100;
						else caso=1;
				else caso=2;
			else caso=3;
		else caso=4;
			
		int rand=-1;
		//System.out.print("Contador: "+contador);
		if(caso>=0)	
			rand=(int) (Math.random() * caso) ;
		
		switch (rand) {
			case 0:	
				eneRet=new Enemigo1(celda);
					break;
			case 1:	
				eneRet=new Enemigo2(celda);
				break;
			case 2:	
				eneRet=new Enemigo3(celda);
				break;
			case 3:	
				eneRet=new Enemigo4(celda);
				break;
			case 4:	
				eneRet=new EnemigoJefe(celda);
				break;
		}
		
		return eneRet;
	
	}
	
	private class Victoria extends TimerTask {
		public void run() {
			gane=true;
		}
	}

	
}


