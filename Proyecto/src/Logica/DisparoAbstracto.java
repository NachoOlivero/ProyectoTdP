package Logica;

import Grafica.OGMovil;
import Logica.abstracto.Personaje;

public abstract class DisparoAbstracto extends Personaje {
	protected int recorrido_restante;
	protected float daño;
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
}
