package Logica.abstracto;

import Logica.Mapa;

public abstract class Torre extends Personaje{
	protected Mapa mapa;
	protected int rango;
	protected int cooldown;
	
	public int getRango() {
		return rango;
	}
	
	public abstract void atacar();
}
