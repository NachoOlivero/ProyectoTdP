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
		return torre!=null;
	}
	
	public Torre getTorre() {
		return torre;
	}
	
	public Enemigo getEnemigo() {
		Enemigo aux=null;
		if (listaEnem.size()!=0)
			 aux=listaEnem.get(0);
		 return aux;
	}
	
	public void setEnemigo(Enemigo ene) {
		listaEnem.add(ene);
	}
	
	public void eliminarTorre() {  //avisar al mapa
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
		//mapa.insertarDisparo(disp,fila,columna+1);
		listaDisparos.remove(disp);
	}
	
	public void avanzarEnemigo() {
		LinkedList<Enemigo> listaAux=new LinkedList<Enemigo>();
		for(Enemigo e:listaEnem)
			listaAux.add(e);
		Iterator<Enemigo> it=listaAux.iterator();
		while(it.hasNext())
				it.next().avanzar();
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
		for(Enemigo e: listaEnem) {
			aux.add(e);
	}
		for(Enemigo e:aux) {
			e.Eliminar();
			listaEnem.remove(e);
		}
	}
	
	public void moverEnemigoCelda(Enemigo e,int pos) {
		if(pos>columna) {
			listaEnem.remove(e);
			mapa.insertarEnemigo(e, fila,columna-1);
		}
	}
}
