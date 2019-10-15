package Logica;

import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class Mapa {
	private Celda celdas[][];
	private int maxColumnas;
	//private int maxFilas;
	
	public Mapa() {
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
	
	public void insertarTorre(Torre t,int fila,int columna) {
		celdas[fila][columna].insertarTorre(t);
	}
	
	public void insertarDisparo(Disparo disp, int fila,int columna) {
		if(columna<maxColumnas) {
			celdas[fila][columna].aņadirDisparo(disp);
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
}

