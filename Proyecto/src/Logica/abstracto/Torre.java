package Logica.abstracto;

import Logica.Celda;
import Logica.Mapa;

public abstract class Torre extends Estructura{
	protected int rango;
	protected int cooldown;
	
	public int getRango() {
		return rango;
	}
	
	public abstract void atacar();

	public abstract void setCelda(Celda c);
}
