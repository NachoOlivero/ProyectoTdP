package Visitors;

import Logica.Disparo;
import Logica.abstracto.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;
import Logica.abstracto.Torre;

public class VisitorEnemigos extends Visitor  {

	public VisitorEnemigos(Enemigo e) {
		miEntidad=e;
	}
	
	@Override
	public void visitAliado(DisparoAbstracto a) {
		a.atacar(miEntidad);
	}

	@Override
	public void visitEnemigo(Enemigo e) {
	}

	@Override
	public void DetectorTorre(Torre e) {
		
	}

	@Override
	public void DisparoEnemigo(DisparoAbstracto a) {
		a.avanzar();
		
	}

	@Override
	public boolean venta(Estructura est) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean venta(Torre t) {
		return false;
		// TODO Auto-generated method stub
		
	}

	
}
