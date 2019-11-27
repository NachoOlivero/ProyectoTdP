package Logica;

import Logica.abstracto.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Celda {
	protected Estructura estructura;
	protected int fila;
	protected int columna;
	protected Mapa mapa;
	protected List<Enemigo> listaEnem;
	protected List<DisparoAbstracto> listaDisparos;
	protected boolean barrera;

	
	public Celda(int f,int c,Mapa map) {
		estructura=null;
		listaEnem=new LinkedList<Enemigo>();
		listaDisparos=new LinkedList<DisparoAbstracto>();
		fila=f;
		columna=c;
		mapa=map;
		barrera=false;
	}
	
	public void limpiar() {
		
		if(estructura!=null)
			estructura.eliminar();
		
		eliminarTodos();
		
		List<DisparoAbstracto> aux =new LinkedList<DisparoAbstracto>();
		for(DisparoAbstracto d: listaDisparos) {
			aux.add(d);
	}
		for(DisparoAbstracto d:aux) {
			d.eliminar();
			listaDisparos.remove(d);
		}
		
	}
	
	public boolean hayEstructura() {
		return estructura!=null;
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
	}
	
	public boolean hayEnemigo() { // retorna el enemigo con menor valor de posicion
		return !listaEnem.isEmpty();
	}

	
	public void addEnemigo(Enemigo ene) {
		if(!barrera) {
			listaEnem.add(ene);
		}
		else ene.Eliminar();
	}
	
	public void eliminarEstructura() {  //avisar al mapa
		estructura=null;
	}
	
	public void añadirDisparo(DisparoAbstracto disp) {
		listaDisparos.add(disp);
	}
	
	public void eliminarDisparo(DisparoAbstracto disparoAbstracto) {
		listaDisparos.remove(disparoAbstracto);
	}
	
	public void avanzarDisparos() {
		LinkedList<DisparoAbstracto> listaAux=new LinkedList<DisparoAbstracto>();
		for(DisparoAbstracto d:listaDisparos)
			listaAux.add(d);
		Iterator<DisparoAbstracto> it=listaAux.iterator();
		while(it.hasNext())
				it.next().turno();
	}
	
	public void moverCeldaDisparo(DisparoAbstracto disp,int a) {
		mapa.insertarDisparo(disp,fila,columna+a);
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
	}
	
	public void eliminarEnemigo(Enemigo ene) {
			listaEnem.remove(ene);
	}
	
	public int getColumna() {
		return columna;
	}
	
	public int getFila() {
		return fila;
	}
	public int cantD() {
		return listaDisparos.size();
	}

	private DisparoAbstracto getDisparo(int pos) {
		DisparoAbstracto ret=null;
		Iterator<DisparoAbstracto> it=listaDisparos.iterator();
		while(it.hasNext() && ret==null) {
			DisparoAbstracto disp=it.next();
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
			DisparoAbstracto aux= getDisparo(enemigo2.PosActual());
			if(aux!=null) {
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
	
		public void recibirDisparo(DisparoAbstracto p) {
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



	public void recibirDisparoEnemigo(DisparoAbstracto p) {
		if(estructura!=null) {
			estructura.AceptarDisparoEnemigo(p);
			}
		if(p!=null) {
			Enemigo e=null;
			if(listaEnem.size()>0) {
				e=getEnemigo(p.pos());
			}
			if(e==null)
				p.avanzar();
			else
				e.AceptarDisparoEnemigo(p);
		
		}
	}

	public void detectarEnemigo(Enemigo enemigo) {
		if(estructura!=null)
			estructura.aceptarDeteccion(enemigo);
		
	}
}

