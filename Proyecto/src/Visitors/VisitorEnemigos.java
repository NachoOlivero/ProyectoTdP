package Visitors;

import Logica.Disparo;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class VisitorEnemigos extends Visitor  {

	public VisitorEnemigos(Enemigo e) {
		miEntidad=e;
	}
	
	@Override
	public void visitAliado(Disparo a) {
		a.atacar(miEntidad);
	}

	@Override
	public void visitEnemigo(Enemigo e) {
	}

	@Override
	public void DetectorTorre(Torre e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisparoEnemigo() {
		// TODO Auto-generated method stub
		
	}

	
}
