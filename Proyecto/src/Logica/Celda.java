package Logica;

import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;
import Logica.abstracto.Torre;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Celda {
	protected Estructura estructura;
	protected int fila;
	protected int columna;
	protected Mapa mapa;
	protected List<Enemigo> listaEnem;
	protected List<Disparo> listaDisparos;
	protected boolean barrera;
	
	public Celda(int f,int c,Mapa map) {
		estructura=null;
		listaEnem=new LinkedList<Enemigo>();
		listaDisparos=new LinkedList<Disparo>();
		fila=f;
		columna=c;
		mapa=map;
		barrera=false;
	}
	
	
	
	public Estructura getEstructura() {
		return estructura;
	}
	
	public void dañarEstructura(float daño) {
		if(estructura!=null)
			estructura.recibirDaño(daño);
	}
	
	public boolean insertarEstructura(Estructura t) {
		boolean aux=(estructura==null);
		if(aux)
			estructura=t;
		return aux;
		//System.out.println("Torre "+t+" insertada");
	}
	
	public boolean hayEnemigo() { // retorna el enemigo con menor valor de posicion
		return !listaEnem.isEmpty();
	}

	
	public void addEnemigo(Enemigo ene) {
		if(!barrera)
			listaEnem.add(ene);
		else {ene.Eliminar();System.out.println("Hola");}
	}
	
	public void eliminarTorre() {  //avisar al mapa
		estructura.Eliminar();
		estructura=null;
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
				it.next().turno();
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
			e.turno();
	}
	
	public void dispararTorre() {
		if(estructura!=null) 
			estructura.turno();
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

	private Disparo getDisparo(int pos) {
		Disparo ret=null;
		Iterator<Disparo> it=listaDisparos.iterator();
		while(it.hasNext() && ret==null) {
			Disparo disp=it.next();
			if(disp.estaEnPosicion(pos))
				ret=disp;
		}
		return ret;
	}

	
	public void setBarrera(boolean valor) {
			barrera=valor;
	}

	private Enemigo getEnemigo(int posicion) { 
		Enemigo ret=null;
		Iterator<Enemigo> it=listaEnem.iterator();
		while(it.hasNext() && ret==null) {
			Enemigo enm=it.next();
			if(enm.estaEnPosicion(posicion))
				ret=enm;
		}
		
		return ret;
	}

	public void recibirEnemigo(Enemigo enemigo2) {
		
		if(listaDisparos.size()>0) {
			Disparo aux= getDisparo(enemigo2.PosActual());
			if(aux!=null) {
				//System.out.println("::::::ENTRO1::::::");
				aux.AceptarEnemigo(enemigo2);
			}
		}
		if(enemigo2!=null) {
		if(estructura!=null) {
			estructura.AceptarEnemigo(enemigo2);
		}else {
			enemigo2.avanzar();
			}
		}
		
		
	}
	
		public void recibirDisparo(Disparo p) {
			if(estructura!=null) {
				estructura.aceptarAliado(p);
				}
			if(p!=null) {
				Enemigo e=null;
				if(listaEnem.size()>0) {
					e=getEnemigo(p.pos());
				}
				if(e==null)
					p.avanzar();
				else
					e.aceptarAliado(p);
			}
		}
	
	
	public List<Enemigo> getEnemigos() {
		return listaEnem;
	}
}

