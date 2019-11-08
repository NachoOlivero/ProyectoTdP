package Logica.Torres;

import Factory.AbstractFactoryT;
import Grafica.OGTorre;
import Factory.FabricaImagenes;
import Logica.Celda;
import Logica.abstracto.Torre;
import Visitors.VisitorCeldaTorre;

public class Torre3 extends Torre{
	
	public Torre3() {
		this.hp=50;
		this.dp=0.5f;
		this.rango=4;
		cooldownOriginal=0;
		cooldownActual=cooldownOriginal;
		cooldown=0;
		grafico=null;
		visitor=new VisitorCeldaTorre(this);
		AbstractFactoryT k=new FabricaImagenes();
		imagenDisparo=k.disparoFuego();
		costo=200;
	}
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new FabricaImagenes();
		grafico=new OGTorre(c,aux.Torre3());
		celda=c;
	}

}
