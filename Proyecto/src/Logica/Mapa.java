package Logica;

import java.util.LinkedList;
import java.util.List;

import Logica.abstracto.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;
import Logica.abstracto.Torre;
import PowerUp.Bomba;
import PowerUp.PowerUp;
import Threads.MovimientoEnemigos;

public class Mapa {
	private Celda celdas[][];
	private int maxColumnas;
	private int maxFilas;
	private List<Torre> listaTorres;
	private List<PowerUp> listaPowerUps;
	
	public Mapa() {
		listaTorres=new LinkedList<Torre>();
		listaPowerUps=new LinkedList<PowerUp>();
		new LinkedList<Bomba>();
	}
	
	public void limpiar() {
		for(int i=0;i<6;i++)
			for(int j=0;j<10;j++)
				celdas[i][j].limpiar();
		
		List<PowerUp>listaPuAux=new LinkedList<PowerUp>();
		
		for(PowerUp pu:listaPowerUps)
			listaPuAux.add(pu);
		
		for(PowerUp pu:listaPuAux)
			pu.eliminar();
		
		Singleton.getJugador().vaciar();
			
	}
	
	public void inicializarCeldas(int x,int y) {
		maxColumnas=y;
		maxFilas=x;
		celdas= new Celda[x][y];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				celdas[i][j]=new Celda(i,j,this);
	}
	
	public void mover() {
		
		for(int i=0;i<celdas.length;i++) {
			for(int j=0;j<celdas[0].length;j++) {
				celdas[i][j].dispararTorre();
				celdas[i][j].avanzarEnemigo();
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
	

	
	public void insertarEnemigo(Enemigo ene,int fila) {			
			celdas[fila][maxColumnas-1].addEnemigo(ene);
	}
	
	public void insertarEnemigo(Enemigo ene,int fila,int columna) {
		if(columna>=0)
			celdas[fila][columna].addEnemigo(ene);
		else {
			ene.Eliminar();
			MovimientoEnemigos.GameOver();
		}
	}
	
	
	public boolean insertarEstructura(Estructura t,int fila,int columna) {
		boolean aux=false;
		if(fila<6 && columna<10) {
		 aux =celdas[fila][columna].insertarEstructura(t);
		}
		return aux;
	}
	
	public boolean insertarTorre(Torre t,int fila,int columna) {  
		boolean aux =celdas[fila][columna].insertarEstructura(t);
		if(aux) listaTorres.add(t); 
		Singleton.getGui().setClickable(true,10);  //abilita el boton de venta de torres
		return aux;
	}
	
	public void eliminarTorre(Torre t,int fila,int columna) {  
		celdas[fila][columna].eliminarEstructura();
		listaTorres.remove(t);
		if(listaTorres.isEmpty())
			Singleton.getGui().setClickable(false,10);  //desabilita el boton de venta de torres
	}
	
	public void insertarDisparo(DisparoAbstracto disp, int fila,int columna) {
		if(columna<maxColumnas) {
			celdas[fila][columna].aņadirDisparo(disp);
			disp.setCelda(celdas[fila][columna]);
		}
		else disp.eliminar();
	}
	
	public Celda getCelda(int x,int y) {
		if(x>=0 && x<maxFilas && y>=0 && y<maxColumnas)
			return celdas[x][y];
		else return null;
	}
	
	public Celda getCelda(int x) {
		if(x>=0 && x<maxFilas)
			return celdas[x][maxColumnas-1];
		else return null;
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

