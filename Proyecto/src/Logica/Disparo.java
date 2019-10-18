package Logica;

import Logica.abstracto.Enemigo;
import Logica.abstracto.Personaje;
import ObjetosGraficos.GraficoDisparo;
import ObjetosGraficos.OGMovil;
import Visitors.VisitorDisparo;

public class Disparo extends Personaje{
	protected int recorrido_restante;
	protected float da�o;
	protected int posRelativa;
	protected Celda celda;
	protected OGMovil grafico;
	
	public Disparo(int alcance, float d�,Celda celda) {
		recorrido_restante=alcance;
		da�o=d�;
		posRelativa=1;
		this.celda=celda;
		grafico=new GraficoDisparo(celda.getX(),celda.getY());
		visitor=new VisitorDisparo(this);
	}
	
	public void decrementarAlcance() {
		recorrido_restante--;
	}
	
	public void avanzar() {
			if(++posRelativa>120) {
				if(--recorrido_restante>0) {
					celda.moverCeldaDisparo(this);
					posRelativa=1;
					grafico.avanzar();
				}
				else 
					eliminar();
			}
			else grafico.avanzar();
		//System.out.println("Disparo :"+posRelativa);
	}

	public boolean estaEnPosicion(int vel) {
		
		return vel==posRelativa;
	}
	public void setCelda(Celda c) {
		celda=c;
	}
	
	public void eliminar() {
		celda.eliminarDisparo(this);
		grafico.eliminar();
	}
	
	public float getDa�o() {
		return da�o;
	}
	public void atacar(Personaje e) {
		e.recibirDa�o(da�o);
		eliminar();
	}

	@Override
	public void recibirDa�o(float da�o) {	
	}
	
	public void turno() {
		celda.recibirDisparo(this);
	}
	public int pos() {
		return posRelativa;
	}
}
