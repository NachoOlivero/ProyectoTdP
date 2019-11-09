package Logica.abstracto;

import Grafica.OGMovil;
import Logica.Celda;

public abstract class DisparoAbstracto extends Personaje {
	protected int recorrido_restante;
	protected float da�o;
	protected int posRelativa;
	protected Celda celda;
	
	
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
	
	public void recibirDa�o(float da�o) {
	}
	
}
