package Logica;

import Logica.abstracto.Enemigo;

public class Mapa {
	Celda celdas[][];
	
	public Mapa(int x,int y) {
		celdas= new Celda[x][y];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				celdas[i][j]=new Celda(i,j,this);
	}
	
	public void mover() {
		//crearEnemigo();
		
		for(int i=0;i<celdas.length;i++)
			for(int j=0;j<celdas[0].length;j++) {
				celdas[i][j].avanzarEnemigo();
				celdas[i][j].dispararTorre();
			}
		
	}
		public void KillAll() {
			for(int i=0;i<celdas.length;i++)
				for(int j=0;j<celdas[0].length;j++) {
					celdas[i][j].eliminarTodos();
			
		}
		
	}
	
	public Enemigo enemigoEnRango(int rango,int fila,int columna) {
		Enemigo ret=null;
		while(ret==null)
			ret=celdas[fila][columna++].getEnemigo();
		return ret;
	}
	
	public void insertarEnemigo(Enemigo ene,int fila) {			
			celdas[fila][celdas[0].length-1].setEnemigo(ene);
		}
	public Celda getCelda(int x,int y) {
		return celdas[x][y];
	}
}

