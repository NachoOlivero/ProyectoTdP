package Logica.abstracto;

import Grafica.OGMovil;
import Logica.Celda;

public abstract class DisparoAbstracto extends Personaje {
	protected int recorrido_restante;
	protected float daño;
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
	
	public float getDaño() {
		return daño;
	}
	public void atacar(Personaje e) {
		e.recibirDaño(daño);
		eliminar();
	}
	public int pos() {
		return posRelativa;
	}
	
	public abstract void avanzar();
	
	public void recibirDaño(float daño) {
	}
	
}
