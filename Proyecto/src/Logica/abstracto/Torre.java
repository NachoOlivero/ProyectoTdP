package Logica.abstracto;

import javax.swing.ImageIcon;

import Logica.Celda;
import Logica.Disparo;
import Logica.Singleton;

public abstract class Torre extends Estructura{
	protected int rango;
	protected int cooldown;
	protected int cooldownActual;
	protected int cooldownOriginal;
	protected int costo;
	protected ImageIcon imagenDisparo;
	
	
	public int getRango() {
		return rango;
	}

	public abstract void setCelda(Celda c);
	
	public void turno() {
		avisarEnemigos();
	}
	
	protected void avisarEnemigos() {
		
		int aux=celda.getColumna()+1;
		while(aux<10) {
			Celda a =Singleton.getMapa().getCelda(celda.getFila(), aux);
			
			for(Enemigo e:a.getEnemigos()) {
				e.aceptarTorre(this);
			}
			aux++;
		}
	}
	
	public void atacar(Personaje e) {
		
		if(cooldown==0 && (e.getCelda().getColumna()-celda.getColumna())<=rango) {
			Disparo disp=new Disparo(rango,dp,celda,imagenDisparo);
			celda.a�adirDisparo(disp);
			cooldown=cooldownActual;
		}
		else cooldown--;
	}
	
	public void eliminar() {
		Singleton.getMapa().eliminarTorre(this,celda.getFila(),celda.getColumna());
		grafico.eliminar();
	}
	
	public void recibirDa�o(float da�o) {
		hp-=da�o;
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
