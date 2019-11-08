package Logica.Enemigos;

import Grafica.OGEnemigo;
import Logica.Celda;
import Visitors.VisitorEnemigos;
import Logica.abstracto.Enemigo;
import Logica.abstracto.EnemigoComun;
import Threads.MovimientoEnemigos;


public class EnemigoJefe extends Enemigo {
	MovimientoEnemigos movEne;
	
	public EnemigoJefe(Celda cel,MovimientoEnemigos mov) {
		movEne=mov;
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
		movEne.victoria();
	}
}