package Logica.Torres;

import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
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
		AbstractFactoryT k=new FabricaImagenes();
		imagenDisparo=k.disparo();
	}
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new FabricaImagenes();
		grafico=new ObjetoGraficoT(c,aux.Torre1());
		celda=c;
	}
	
}
