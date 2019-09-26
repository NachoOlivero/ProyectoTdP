package Logica;

import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;
import java.util.LinkedList;
import java.util.List;

public class Celda {
	protected Torre torre;
	protected Enemigo enemigo; //o bien una coleccion de enemigos
	protected int fila;
	protected int columna;
	protected Mapa mapa;
	protected List<Enemigo> listaEnemigos;
	
	
	public Celda(int f,int c,Mapa map) {
		torre=null;
		listaEnemigos=new LinkedList<Enemigo>();
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
		Enemigo aux=null;
		if (listaEnemigos.size()!=0)
			 aux=listaEnemigos.get(0);
		 return aux;
	}
	
	public void setEnemigo(Enemigo ene) {
		listaEnemigos.add(ene);
	}
	
	public void eliminarTorre() {  //avisar al mapa
		torre=null;
	}
	
	public void añadirDisparo(Disparo disp) {
		//añadirlo a la coleccion de disparos
	}
	
	public void avanzarEnemigo() {
		for(Enemigo e: listaEnemigos) {
				e.avanzar();
		}
	}
	
	public void dispararTorre() {
		if(torre!=null) {
			Enemigo ene=mapa.enemigoEnRango(torre.getRango(),fila,columna);
			if(ene!=null)
				torre.atacar(ene);
		}
	}
	public void eliminarTodos() {
		List<Enemigo> aux =new LinkedList<Enemigo>();
		for(Enemigo e: listaEnemigos) {
			aux.add(e);
	}
		for(Enemigo e:aux) {
			e.Eliminar();
			listaEnemigos.remove(e);
		}
	}
}
