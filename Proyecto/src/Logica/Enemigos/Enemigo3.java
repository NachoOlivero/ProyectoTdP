package Logica.Enemigos;

import Logica.abstracto.EnemigoDistancia;
import Logica.abstracto.Estado;
import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
import Grafica.OGEnemigo;
import Logica.Celda;
import Visitors.VisitorEneDistancia;

public class Enemigo3 extends EnemigoDistancia {
	public Enemigo3(Celda cel,Estado est) {
		hp=5;
		dp=5;
		celda=cel;
		vel=1;
		rango=5;
		visitor= new VisitorEneDistancia(this);
		estado=est;
		grafico=new OGEnemigo(estado.getFactory().Enemigo3(),celda.getFila());
		cooldownMax=30;
		cooldown=0;
	}
	
}
