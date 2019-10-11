package Logica.abstracto;

import Logica.Celda;
import ObjetosGraficos.OGEnemigo;

public abstract class Enemigo extends Personaje{
	protected int vel;
	protected OGEnemigo grafico;
	protected final int max=12;
	protected int pos=1;
	
	public abstract void avanzar();
	
	public abstract void actualizarCelda(Celda c);
	
	public abstract boolean estaEnPosicion(int pos);
	
	public abstract boolean tieneMenorPosicion(int pos);
	
	public int PosActual() {
		return pos;
	}
	
}
