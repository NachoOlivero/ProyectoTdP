package Logica.Torres;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.ObjetoGraficoT;
import Logica.Celda;
import Logica.Singleton;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;
import Visitors.VisitorCeldaTorre;


public class TorreDinero extends Torre{

	public TorreDinero() {
		this.hp=20;
		this.dp=0;
		this.rango=0;
		cooldownOriginal=20;
		cooldownActual=cooldownOriginal;
		cooldown=15;
		grafico=null;
		visitor=new VisitorCeldaTorre(this);
	
	}
	
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new fabricaT();
		grafico=new ObjetoGraficoT(c,aux.TorreD(),10);
		celda=c;
		
	}

	
	public void setCooldown(int cd) {
		cooldownActual=cd;
		cooldown=0;
		
	}

	
	public void resetCooldown() {
		cooldownActual=cooldownOriginal;
		
	}

	
	public int getCooldown() {
		return cooldown;
	}

	
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0) {
			Singleton.getMapa().eliminarTorre(this,celda.getY(),celda.getX());
			grafico.eliminar();
		}
		
	}

	@Override
	public void atacar(Personaje e) {
		// TODO Auto-generated method stub
		
	}
	
	public void turno() {
		if (cooldown==0) {
			Singleton.getJugador().aumentarDinero(30);
			cooldown=cooldownActual;
		}else cooldown--;
		this.avisarEnemigos();
	}
	
	
}
