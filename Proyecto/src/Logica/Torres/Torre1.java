package Logica.Torres;

import Logica.Celda;
import Logica.Disparo;
import Logica.Singleton;
import Logica.abstracto.Torre;
import ObjetosGraficos.ObjetoGraficoT1;

public class Torre1 extends Torre {
	
	public Torre1() {
		this.hp=5000;
		this.dp=500;
		this.rango=5;
		cooldownOriginal=20;
		cooldownActual=cooldownOriginal;
		cooldown=0;
		grafico=null;
	}
	public void setCelda(Celda c) {
		grafico=new ObjetoGraficoT1(c);
		celda=c;
	}

	public void atacar() {
		if(cooldown==0) {
			Disparo disp=new Disparo(rango,dp,celda);
			celda.añadirDisparo(disp);
			cooldown=cooldownActual;
		}
		else cooldown--;
	}
	
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0) {
			Singleton.getMapa().eliminarTorre(this,celda.getX(),celda.getY());
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
