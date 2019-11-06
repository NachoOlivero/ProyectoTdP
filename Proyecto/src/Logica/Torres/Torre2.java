package Logica.Torres;

import Factory.AbstractFactoryT;
import Grafica.OGTorre;
import Factory.FabricaImagenes;
import Logica.Celda;
import Logica.abstracto.Torre;
import Visitors.VisitorCeldaTorre;

public class Torre2 extends Torre {

	public Torre2() {
		this.hp=10;
		this.dp=300;
		this.rango=2;
		cooldownOriginal=200;
		cooldownActual=cooldownOriginal;
		cooldown=0;
		grafico=null;
		visitor=new VisitorCeldaTorre(this);
		AbstractFactoryT k=new FabricaImagenes();
		imagenDisparo=k.disparo();
	}
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new FabricaImagenes();
		grafico=new OGTorre(c,aux.Torre2());
		celda=c;
	}

}
