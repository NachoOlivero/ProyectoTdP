package Logica.Enemigos;

import Grafica.OGEnemigo;
import Logica.Celda;
import Visitors.VisitorEnemigos;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estado;


public class Enemigo4 extends Enemigo {
	
	public Enemigo4(Celda cel,Estado est) {
		hp=50;
		dp=2;
		vel=1;
		celda=cel;
		estado=est;
		grafico=new OGEnemigo(estado.getFactory().Enemigo4(),celda.getFila());
		visitor=new VisitorEnemigos(this);
	}
}
