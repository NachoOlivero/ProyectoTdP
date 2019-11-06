package Logica.Enemigos;

import Logica.abstracto.EnemigoDistancia;
import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.OGEnemigo;
import Logica.Celda;
import Visitors.VisitorEneDistancia;

public class Enemigo3 extends EnemigoDistancia {
	public Enemigo3(Celda cel) {
		hp=5;
		dp=5;
		celda=cel;
		vel=1;
		rango=5;
		visitor= new VisitorEneDistancia(this);
		AbstractFactoryT ab=new fabricaT();
		grafico=new OGEnemigo(ab.Enemigo3(),celda.getFila());
		cooldownMax=30;
	}
	
}
