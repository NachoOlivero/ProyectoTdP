package Visitors;

import Logica.Disparo;
import Logica.abstracto.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;

public class VisitorCeldaEstructura extends Visitor {

	public VisitorCeldaEstructura(Personaje p) {
		miEntidad=p;
	}
	
	public void visitAliado(DisparoAbstracto a) {
		a.atacar(miEntidad);
	}

	@Override
	public void visitEnemigo(Enemigo e) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean venta(Torre t) {
		// TODO Auto-generated method stub
		return false;
	}

}
