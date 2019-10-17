package Logica;

import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Celda {
	protected Torre torre;
	protected Enemigo enemigo; //o bien una coleccion de enemigos
	protected int fila;
	protected int columna;
	protected Mapa mapa;
	protected List<Enemigo> listaEnem;
	protected List<Disparo> listaDisparos;
	
	public Celda(int f,int c,Mapa map) {
		torre=null;
		listaEnem=new LinkedList<Enemigo>();
		listaDisparos=new LinkedList<Disparo>();
		enemigo=null; //o bien inicializar la coleccion
		fila=f;
		columna=c;
		mapa=map;
	}
	
	public boolean hayTorre() {
		return torre != null;
	}
	
	public Torre getTorre() {
		return torre;
	}
	
	public void insertarTorre(Torre t) {
		torre=t;
		//System.out.println("Torre "+t+" insertada");
	}
	
	public boolean hayEnemigo() { // retorna el enemigo con menor valor de posicion
		return !listaEnem.isEmpty();
	}
	
	public Enemigo getEnemigo(int posicion) { 
		Enemigo ret=null;
		Iterator<Enemigo> it=listaEnem.iterator();
		while(it.hasNext() && ret==null) {
			Enemigo enm=it.next();
			if(enm.estaEnPosicion(posicion))
				ret=enm;
		}
		
		return ret;
	}
	
	public void addEnemigo(Enemigo ene) {
		listaEnem.add(ene);
	}
	
	public void eliminarTorre() {  //avisar al mapa
		torre.Eliminar();
		torre=null;
	}
	
	public void añadirDisparo(Disparo disp) {
		listaDisparos.add(disp);
	}
	
	public void eliminarDisparo(Disparo disp) {
		listaDisparos.remove(disp);
	}
	
	public void avanzarDisparos() {
		LinkedList<Disparo> listaAux=new LinkedList<Disparo>();
		for(Disparo d:listaDisparos)
			listaAux.add(d);
		Iterator<Disparo> it=listaAux.iterator();
		while(it.hasNext())
				it.next().avanzar();
	}
	
	public void moverCeldaDisparo(Disparo disp) {
		mapa.insertarDisparo(disp,fila,columna+1);
		listaDisparos.remove(disp);
	}
	
	public void avanzarEnemigo() {
		LinkedList<Enemigo> listaAux=new LinkedList<Enemigo>();
		for(Enemigo e:listaEnem)
			listaAux.add(e);
		for(Enemigo e:listaAux) 
			e.avanzar();
	}
	
	public void dispararTorre() {
		if(torre!=null) 
			if(Singleton.getMapa().hayEnemigoEnRango(torre.getRango(), fila, columna)) 
				torre.atacar();
				
	}
	
	public void eliminarTodos() {
		List<Enemigo> aux =new LinkedList<Enemigo>();
		for(Enemigo e: listaEnem) {
			aux.add(e);
	}
		for(Enemigo e:aux) {
			e.Eliminar();
			listaEnem.remove(e);
		}
	}
	
	public void moverEnemigoCelda(Enemigo e) {
			listaEnem.remove(e);
			mapa.insertarEnemigo(e, fila,columna-1);
			e.actualizarCelda(mapa.getCelda(fila, columna-1));
			//System.out.println("movimiento");
	}
	
	public void eliminarEnemigo(Enemigo ene) {
			listaEnem.remove(ene);
	}
	
	public int getX() {
		return columna;
	}
	
	public int getY() {
		return fila;
	}
	public int cantD() {
		return listaDisparos.size();
	}

	public Disparo getDisparo(int pos) {
		Disparo ret=null;
		Iterator<Disparo> it=listaDisparos.iterator();
		while(it.hasNext() && ret==null) {
			Disparo disp=it.next();
			if(disp.estaEnPosicion(pos))
				ret=disp;
		}
		return ret;
	}
}
