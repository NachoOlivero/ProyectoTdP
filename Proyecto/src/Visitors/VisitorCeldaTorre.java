package Visitors;

import Logica.Disparo;
import Logica.abstracto.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;
import Logica.abstracto.Torre;

public class VisitorCeldaTorre extends Visitor {

	public VisitorCeldaTorre(Torre torre) {
		miEntidad=torre;
	}
	
	@Override
	public void visitAliado(DisparoAbstracto a) {
		
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		System.out.println("si");
		e.atacar(miEntidad);
	}

	@Override
	public void DetectorTorre(Torre e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisparoEnemigo(DisparoAbstracto a) {
		a.atacar(miEntidad);
		
	}


	@Override
	public boolean venta(Estructura est) {
		return false;
		
	}

	@Override
	public boolean venta(Torre t) {
		return false;
		// TODO Auto-generated method stub
		
	}


	public void DetectarEnemigo(Enemigo e) {
		miEntidad.atacar(e);
	}
	

}
