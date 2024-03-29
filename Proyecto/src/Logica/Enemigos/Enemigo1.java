package Logica.Enemigos;

import Grafica.OGEnemigo;
import Logica.Celda;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estado;
import Visitors.VisitorEnemigos;


public class Enemigo1 extends Enemigo {

	public Enemigo1(Celda cel,Estado est) {
		estado=est;
		hp=15 * estado.getAumento();
		dp=5;
		celda=cel;
		vel=2 *estado.getAumento();
		grafico=new OGEnemigo(estado.getFactory().Enemigo1(),celda.getFila());
		visitor=new VisitorEnemigos(this);
		cooldown=0;
		cooldownMax=10;

	}
	
}
