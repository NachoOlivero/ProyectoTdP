package Visitors;

import Logica.abstracto.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;

public class VisitorDisparoEnemigo extends Visitor {
	
	public VisitorDisparoEnemigo(Personaje e) {
		miEntidad=e;
	}

	@Override
	public void visitAliado(DisparoAbstracto a) {
		
	}

	@Override
	public void visitEnemigo(Enemigo e) {

		
	}

	@Override
	public void DetectorTorre(Torre e) {
		
	}

	@Override
	public void DisparoEnemigo(DisparoAbstracto a) {
	    
		
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
