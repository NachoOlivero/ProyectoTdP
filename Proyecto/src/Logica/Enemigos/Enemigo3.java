package Logica.Enemigos;

import Logica.abstracto.EnemigoDistancia;
import Logica.abstracto.Estado;
import Grafica.OGEnemigo;
import Logica.Celda;
import Visitors.VisitorEneDistancia;

public class Enemigo3 extends EnemigoDistancia {
	public Enemigo3(Celda cel,Estado est) {
		estado=est;
		hp=5 *estado.getAumento();
		dp=5;
		celda=cel;
		vel=1* estado.getAumento();
		rango=5/ estado.getAumento();
		visitor= new VisitorEneDistancia(this);
		grafico=new OGEnemigo(estado.getFactory().Enemigo3(),celda.getFila());
		cooldownMax=30;
		cooldown=0;
	}
	
}
