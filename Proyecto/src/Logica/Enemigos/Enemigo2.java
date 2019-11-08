package Logica.Enemigos;

import Grafica.OGEnemigo;
import Logica.Celda;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estado;
import Visitors.VisitorEnemigos;

public class Enemigo2 extends Enemigo{

	public Enemigo2(Celda cel,Estado est) {
		estado=est;
		hp=5 *estado.getAumento();
		dp=10;
		celda=cel;
		vel=3* estado.getAumento();
		grafico=new OGEnemigo(estado.getFactory().Enemigo2(),celda.getFila());
		visitor=new VisitorEnemigos(this);
		cooldown=0;
		cooldownMax=5;
	}
	
}
