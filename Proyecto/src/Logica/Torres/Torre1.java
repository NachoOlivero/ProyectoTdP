package Logica.Torres;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.ObjetoGraficoT;
import Logica.Celda;
import Logica.Disparo;
import Logica.Singleton;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;
import Visitors.VisitorCeldaTorre;

public class Torre1 extends Torre {
	
	public Torre1() {
		this.hp=50;
		this.dp=5;
		this.rango=5;
		cooldownOriginal=20;
		cooldownActual=cooldownOriginal;
		cooldown=0;
		grafico=null;
		visitor=new VisitorCeldaTorre(this);
	}
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new fabricaT();
		grafico=new ObjetoGraficoT(c,aux.Torre1());
		celda=c;
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
