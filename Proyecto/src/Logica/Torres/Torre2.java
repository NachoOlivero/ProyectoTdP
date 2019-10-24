package Logica.Torres;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.ObjetoGraficoT;
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
	}
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new fabricaT();
		grafico=new ObjetoGraficoT(c,aux.Torre2());
		celda=c;
	}

}
