package Logica.Enemigos;

import Logica.abstracto.EnemigoDistancia;
import Grafica.OGEnemigo1;
import Logica.Celda;
import Logica.abstracto.Enemigo;
import Visitors.VisitorEneDistancia;
import Visitors.VisitorEnemigos;

public class Enemigo3 extends EnemigoDistancia {
	public Enemigo3(Celda cel) {
		hp=5;
		dp=5;
		celda=cel;
		vel=1;
		rango=2;
		visitor= new VisitorEneDistancia(this);
	}
	
}
