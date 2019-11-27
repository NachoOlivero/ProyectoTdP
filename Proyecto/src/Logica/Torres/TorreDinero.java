package Logica.Torres;

import Factory.AbstractFactoryT;
import Grafica.OGTorre;
import Factory.FabricaImagenes;
import Logica.Celda;
import Logica.Singleton;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;
import Visitors.VisitorCeldaTorre;


public class TorreDinero extends Torre{
	protected static int costoS=50;

	public TorreDinero() {
		this.hp=20;
		this.maxHp=20;
		this.costo=50;
		this.dp=0;
		this.rango=0;
		cooldownOriginal=30;
		cooldownActual=cooldownOriginal;
		cooldown=15;
		grafico=null;
		visitor=new VisitorCeldaTorre(this);
	}
	
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new FabricaImagenes();
		grafico=new OGTorre(c,aux.TorreD(),10);
		celda=c;
	}

	public void atacar(Personaje e) {}
	
	public void turno() {
		int aux;
		if (cooldown==0) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux+20);
			cooldown=cooldownActual;
		}
		else cooldown--;
		
		this.avisarEnemigos();
	}
	
	
	public static int costo() {
		return costoS;
	}
	
}
