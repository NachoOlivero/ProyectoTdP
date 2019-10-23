package Logica.abstracto;

import Logica.Celda;
import Logica.Mapa;
import Logica.Singleton;

public abstract class Torre extends Estructura{
	protected int rango;
	protected int cooldown;
	protected int cooldownActual;
	protected int cooldownOriginal;
	
	public int getRango() {
		return rango;
	}
	
	//public abstract void atacar();

	public abstract void setCelda(Celda c);
	
	public abstract void setCooldown(int cd);
	
	public abstract void resetCooldown();
	
	public abstract int getCooldown();
	
	public void turno() {
		if(Singleton.getMapa().hayEnemigoEnRango(rango, celda.getY(), celda.getX()))
				atacar(null);
		avisarEnemigos();
	}
	
	private void avisarEnemigos() {
		int aux=celda.getX()+1;
		int distancia=1;
		while(aux<10) {
			Singleton.getMapa().getCelda(aux, celda.getY());
			for(Enemigo e:celda.getEnemigos())
				e.aceptarTorre(this,distancia);
			distancia++;
			aux++;
		}
	}
}
