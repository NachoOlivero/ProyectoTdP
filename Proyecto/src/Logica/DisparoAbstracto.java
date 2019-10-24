package Logica;

import Grafica.OGMovil;
import Logica.abstracto.Personaje;

public abstract class DisparoAbstracto extends Personaje {
	protected int recorrido_restante;
	protected float da�o;
	protected int posRelativa;
	protected Celda celda;
	protected OGMovil grafico;
	
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
	public int pos() {
		return posRelativa;
	}
	
	public abstract void avanzar();
}
