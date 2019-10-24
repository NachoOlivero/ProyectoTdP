package Logica.abstracto;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Logica.Celda;
import Logica.Disparo;
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
	
	public void turno() {
		if(Singleton.getMapa().hayEnemigoEnRango(rango, celda.getY(), celda.getX()))
				atacar(null);
		avisarEnemigos();
	}
	
	protected void avisarEnemigos() {
		//System.out.println(celda);
		int aux=celda.getX()+1;
		while(aux<10) {
			Celda a =Singleton.getMapa().getCelda(celda.getY(), aux);
			//System.out.println(a);
			for(Enemigo e:a.getEnemigos()) {
				e.aceptarTorre(this);
			}
			aux++;
		}
	}
	
	public void atacar(Personaje e) {
		if(cooldown==0) {
			AbstractFactoryT k=new fabricaT();
			Disparo disp=new Disparo(rango,dp,celda,k.disparo());
			celda.añadirDisparo(disp);
			cooldown=cooldownActual;
		}
		else cooldown--;
	}
	
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0) {
			Singleton.getMapa().eliminarTorre(this,celda.getY(),celda.getX());
			grafico.eliminar();
		}
	}
	
	public int getCooldown() {
		return cooldownActual;
	}
	
	public void setCooldown(int cd) {
		cooldownActual=cd;
		cooldown=0;
	}
	
	public void resetCooldown() {
		cooldownActual=cooldownOriginal;
	}
}
