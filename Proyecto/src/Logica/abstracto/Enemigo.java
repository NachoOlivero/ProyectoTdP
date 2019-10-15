package Logica.abstracto;

import Logica.Celda;
import ObjetosGraficos.OGMovil;

public abstract class Enemigo extends Personaje{
	protected int vel;
	protected OGMovil grafico;
	protected final int min=1;
	protected int pos=120;
	
	public abstract void avanzar();
	
	public abstract void actualizarCelda(Celda c);
	
	public abstract boolean estaEnPosicion(int pos);
	
	public abstract boolean tieneMenorPosicion(int pos);
	
	public int PosActual() {
		return pos;
	}
	
}
