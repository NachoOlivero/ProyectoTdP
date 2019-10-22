package Logica.Enemigos;

import Grafica.OGEnemigo1;
import Logica.Celda;
import Logica.abstracto.Enemigo;
import Visitors.VisitorEnemigos;

public class Enemigo1 extends Enemigo{

	public Enemigo1(Celda cel) {
		hp=1000;
		dp=1000;
		celda=cel;
		vel=1;
		grafico=new OGEnemigo1();
		visitor=new VisitorEnemigos(this);
	}
}
