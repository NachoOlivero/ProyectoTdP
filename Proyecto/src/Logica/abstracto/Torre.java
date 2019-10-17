package Logica.abstracto;

import Logica.Celda;
import Logica.Mapa;

public abstract class Torre extends Personaje{
	protected Mapa mapa;
	protected int rango;
	protected int cooldown;
	protected int cooldownActual;
	protected int cooldownOriginal;
	
	public int getRango() {
		return rango;
	}
	
	public abstract void atacar();

	public abstract void setCelda(Celda c);
	
	public abstract void setCooldown(int cd);
	
	public abstract void resetCooldown();
	
	public abstract int getCooldown();
}
