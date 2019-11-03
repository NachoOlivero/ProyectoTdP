package Logica.Enemigos;

import Logica.abstracto.EnemigoDistancia;
import Grafica.OGEnemigo3;
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
		grafico=new OGEnemigo3();
		cooldownMax=30;
	}
	
}
