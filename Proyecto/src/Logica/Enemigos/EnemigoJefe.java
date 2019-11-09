package Logica.Enemigos;

import Grafica.OGEnemigo;
import Logica.Celda;
import Logica.Singleton;
import Visitors.VisitorEnemigos;
import Logica.abstracto.Enemigo;
import Logica.abstracto.EnemigoComun;
import Threads.MovimientoEnemigos;


public class EnemigoJefe extends Enemigo {
	
	public EnemigoJefe(Celda cel) {
		hp=150;
		dp=10;
		celda=cel;
		vel=1;
		estado=new EnemigoComun();
		grafico=new OGEnemigo(estado.getFactory().Enemigo6(),celda.getFila());
		visitor=new VisitorEnemigos(this);
	}

	public void Eliminar() {
		super.Eliminar();
		Singleton.getMovEne().victoria();
	}
}