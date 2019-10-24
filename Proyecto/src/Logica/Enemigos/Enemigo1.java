package Logica.Enemigos;

import Grafica.OGEnemigo1;
import Logica.Celda;
import Logica.abstracto.Enemigo;
import Logica.abstracto.EnemigoDistancia;
import Visitors.VisitorEnemigos;


public class Enemigo1 extends Enemigo{

	public Enemigo1(Celda cel) {
		hp=15;
		dp=5;
		celda=cel;
		vel=2;
		grafico=new OGEnemigo1();
		visitor=new VisitorEnemigos(this);
	}
	
}
