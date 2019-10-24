package Logica.Enemigos;

import Grafica.OGEnemigo2;
import Logica.Celda;
import Logica.abstracto.Enemigo;
import Visitors.VisitorEnemigos;

public class Enemigo2 extends Enemigo{

	public Enemigo2(Celda cel) {
		hp=5;
		dp=10;
		celda=cel;
		vel=3;
		grafico=new OGEnemigo2();
		visitor=new VisitorEnemigos(this);
	}
}
