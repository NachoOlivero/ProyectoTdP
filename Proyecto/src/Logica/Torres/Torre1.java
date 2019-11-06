package Logica.Torres;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.OGTorre;
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
		AbstractFactoryT k=new fabricaT();
		imagenDisparo=k.disparo();
	}
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new fabricaT();
		grafico=new OGTorre(c,aux.Torre1());
		celda=c;
	}
	
}
