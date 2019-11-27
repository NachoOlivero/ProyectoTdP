package Logica.Torres;

import Factory.AbstractFactoryT;
import Grafica.OGTorre;
import Factory.FabricaImagenes;
import Logica.Celda;
import Logica.abstracto.Torre;
import Visitors.VisitorCeldaTorre;

public class Torre1 extends Torre {
	protected static int costoS=100;
	
	public Torre1() {
		this.hp=50;
		this.maxHp=50;
		this.costo=100;
		this.dp=5;
		this.rango=5;
		cooldownOriginal=20;
		cooldownActual=cooldownOriginal;
		cooldown=0;
		grafico=null;
		visitor=new VisitorCeldaTorre(this);
		AbstractFactoryT k=new FabricaImagenes();
		imagenDisparo=k.disparo();
	}
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new FabricaImagenes();
		grafico=new OGTorre(c,aux.Torre1());
		celda=c;
	}
	
	public static int costo() {
		return costoS;
	}
}
