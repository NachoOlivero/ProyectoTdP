package Logica.Enemigos;

import Grafica.OGEnemigoJefe;
import Logica.Celda;
import Visitors.VisitorEnemigos;
import Logica.abstracto.Enemigo;


public class EnemigoJefe extends Enemigo {
	
	public EnemigoJefe(Celda cel) {
		hp=150;
		dp=10;
		celda=cel;
		vel=1;
		grafico=new OGEnemigoJefe();
		visitor=new VisitorEnemigos(this);
	}
}