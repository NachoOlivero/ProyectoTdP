package Logica.Enemigos;

import Logica.abstracto.Enemigo;
import Grafica.OGEnemigo;
import Logica.Celda;
import Logica.abstracto.Estado;
import Visitors.VisitorEnemigos;

public class Enemigo5 extends Enemigo {
	public Enemigo5(Celda cel,Estado est) {
		hp=50;
		dp=50;
		celda=cel;
		vel=3;
		estado=est;
		grafico=new OGEnemigo(estado.getFactory().Enemigo5(),celda.getFila());
		visitor=new VisitorEnemigos(this);

	}

}
