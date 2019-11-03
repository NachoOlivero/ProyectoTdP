package Logica.Torres;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.ObjetoGraficoT;
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
		AbstractFactoryT k=new fabricaT();
		imagenDisparo=k.disparoFuego();
	}
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new fabricaT();
		grafico=new ObjetoGraficoT(c,aux.Torre3());
		celda=c;
	}

}
