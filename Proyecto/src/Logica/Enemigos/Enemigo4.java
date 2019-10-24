package Logica.Enemigos;

import Grafica.OGEnemigo4;
import Logica.Celda;
import Visitors.VisitorEnemigos;
import Logica.abstracto.Enemigo;


public class Enemigo4 extends Enemigo {
	
	public Enemigo4(Celda cel) {
		hp=50;
		dp=2;
		celda=cel;
		vel=1;
		grafico=new OGEnemigo4();
		visitor=new VisitorEnemigos(this);
	}
}
