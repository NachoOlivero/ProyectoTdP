package Logica.Enemigos;

import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
import Grafica.OGEnemigo;
import Logica.Celda;
import Visitors.VisitorEnemigos;
import Logica.abstracto.Enemigo;


public class EnemigoJefe extends Enemigo {
	
	public EnemigoJefe(Celda cel) {
		hp=150;
		dp=10;
		celda=cel;
		vel=1;
		AbstractFactoryT ab=new FabricaImagenes();
		grafico=new OGEnemigo(ab.Enemigo5(),celda.getFila());
		visitor=new VisitorEnemigos(this);
	}
}