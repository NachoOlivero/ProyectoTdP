package Logica;

import java.util.LinkedList;
import java.util.List;

import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class Mapa {
	private Celda celdas[][];
	private int maxColumnas;
	//private int maxFilas;
	private List<Torre> listaTorres;
	private List<PowerUp> listaPowerUps;
	
	public Mapa() {
		listaTorres=new LinkedList<Torre>();
		listaPowerUps=new LinkedList<PowerUp>();
	}
	
	public void inicializarCeldas(int x,int y) {
		maxColumnas=y;
		//maxFilas=x;
		celdas= new Celda[x][y];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				celdas[i][j]=new Celda(i,j,this);
	}
	
	public void mover() {
		
		for(int i=0;i<celdas.length;i++) {
			for(int j=0;j<celdas[0].length;j++) {
				celdas[i][j].avanzarEnemigo();
				celdas[i][j].dispararTorre();
				for(int m=0;m<10;m++)
					celdas[i][j].avanzarDisparos();
			}
		}
		
	}
		public void KillAll() {
			for(int i=0;i<celdas.length;i++)
				for(int j=0;j<celdas[0].length;j++) {
					celdas[i][j].eliminarTodos();
			
		}
		
	}
	
	public boolean hayEnemigoEnRango(int rango,int fila,int columna) {
		boolean hayEnemigo=false;
		int cont=0;
		while(cont<rango && columna<10 && !hayEnemigo) {
			hayEnemigo=celdas[fila][columna].hayEnemigo();
			columna++;
			cont++;
		}
		return hayEnemigo;
	}
	
	public void insertarEnemigo(Enemigo ene,int fila) {			
			celdas[fila][maxColumnas-1].addEnemigo(ene);
		}
	
	public void insertarEnemigo(Enemigo ene,int fila,int columna) {
		if(columna>=0)
			celdas[fila][columna].addEnemigo(ene);
	}
	
	public boolean insertarTorre(Torre t,int fila,int columna) {  
		boolean aux =celdas[fila][columna].insertarTorre(t);
		if(aux) listaTorres.add(t); 
		return aux;
	}
	
	public void eliminarTorre(Torre t,int fila,int columna) {  
		celdas[fila][columna].eliminarTorre();
		listaTorres.remove(t); 
	}
	
	public void insertarDisparo(Disparo disp, int fila,int columna) {
		if(columna<maxColumnas) {
			celdas[fila][columna].añadirDisparo(disp);
			disp.setCelda(celdas[fila][columna]);
		}
		else disp.eliminar();
	}
	
	public Celda getCelda(int x,int y) {
		return celdas[x][y];
	}
	
	public Celda getCelda(int x) {
		return celdas[x][maxColumnas-1];
	}
	
	public List<Torre> getListaTorres(){
		return listaTorres;
	}
	
	public void insertarPowerUp(PowerUp pu) {
		listaPowerUps.add(pu);
	}
	
	public void eliminarPowerUp(PowerUp pu) {  
		listaPowerUps.remove(pu); 
	}
	
	
}

