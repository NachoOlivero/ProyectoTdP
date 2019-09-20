package Logica;

import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class Celda {
	protected Torre torre;
	protected Enemigo enemigo; //o bien una coleccion de enemigos
	protected int fila;
	protected int columna;
	protected Mapa mapa;
	
	public Celda(int f,int c,Mapa map) {
		torre=null;
		enemigo=null; //o bien inicializar la coleccion
		fila=f;
		columna=c;
		mapa=map;
	}
	
	public boolean hayTorre() {
		return torre!=null;
	}
	
	public Torre getTorre() {
		return torre;
	}
	
	public Enemigo getEnemigo() {
		return enemigo;
	}
	
	public void setEnemigo(Enemigo ene) {
		enemigo=ene;
	}
	
	public void eliminarTorre() {  //avisar al mapa
		torre=null;
	}
	
	public void añadirDisparo(Disparo disp) {
		//añadirlo a la coleccion de disparos
	}
	
	public void avanzarEnemigo() {
		if(enemigo!=null)
			enemigo.avanzar();
	}
	
	public void dispararTorre() {
		if(torre!=null) {
			Enemigo ene=mapa.enemigoEnRango(torre.getRango(),fila,columna);
			if(ene!=null)
				torre.atacar(ene);
		}
	}
}
