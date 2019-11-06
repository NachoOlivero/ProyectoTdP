package Logica.Torres;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.GraficoDoble;
import Grafica.OGTorre;
import Logica.Celda;
import Logica.Singleton;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;
import Visitors.VisitorCeldaTorre;

public class Barricada extends Torre {
	protected Celda celdaExtra;

	public Barricada() {
		this.hp=1000;
		this.dp=0;
		this.rango=0;
		cooldownOriginal=0;
		cooldownActual=cooldownOriginal;
		cooldown=0;
		grafico=null;
		visitor=new VisitorCeldaTorre(this);
	}
	
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new fabricaT();
		grafico=new GraficoDoble(c,aux.barricada());
		celda=c;
		celdaExtra=Singleton.getMapa().getCelda(celda.getFila(), celda.getColumna()-1);
	}
	
	public void eliminar() {
		grafico.eliminar();
		celdaExtra.eliminarEstructura();
		celda.eliminarEstructura();
	}

	public void setCooldown(int cd) {}


	public void resetCooldown() {}

	public int getCooldown() {
		return 0;
	}

	public void atacar(Personaje e) {}

	public void turno() {}
	
}
