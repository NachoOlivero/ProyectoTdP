package Logica.abstracto;

import javax.swing.ImageIcon;

import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
import Logica.Celda;
import Logica.Disparo;
import Logica.Mapa;
import Logica.Singleton;

public abstract class Torre extends Estructura{
	protected int rango;
	protected int cooldown;
	protected int cooldownActual;
	protected int cooldownOriginal;
	protected ImageIcon imagenDisparo;
	
	public int getRango() {
		return rango;
	}

	public abstract void setCelda(Celda c);
	
	public void turno() {
		if(Singleton.getMapa().hayEnemigoEnRango(rango, celda.getFila(), celda.getColumna()))
				atacar(null);
		avisarEnemigos();
	}
	
	protected void avisarEnemigos() {
		//System.out.println(celda);
		int aux=celda.getColumna()+1;
		while(aux<10) {
			Celda a =Singleton.getMapa().getCelda(celda.getFila(), aux);
			//System.out.println(a);
			for(Enemigo e:a.getEnemigos()) {
				e.aceptarTorre(this);
			}
			aux++;
		}
	}
	
	public void atacar(Personaje e) {
		if(cooldown==0) {
			Disparo disp=new Disparo(rango,dp,celda,imagenDisparo);
			celda.añadirDisparo(disp);
			cooldown=cooldownActual;
		}
		else cooldown--;
	}
	
	public void eliminar() {
		Singleton.getMapa().eliminarTorre(this,celda.getFila(),celda.getColumna());
		grafico.eliminar();
	}
	
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0) {
			eliminar();
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
