package Visitors;

import Logica.Disparo;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;

public class VisitorCeldaEstructura extends Visitor {

	public VisitorCeldaEstructura(Personaje p) {
		miEntidad=p;
	}
	
	public void visitAliado(Disparo a) {
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
	public void DisparoEnemigo(Disparo a) {
		a.atacar(miEntidad);
		
	}

}
