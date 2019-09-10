package Logica.abstracto;

import Logica.Mapa;

public abstract class Torre extends Personaje{
	protected Mapa mapa;
	protected int rango;
	
	public int getRango() {
		return rango;
	}
}
