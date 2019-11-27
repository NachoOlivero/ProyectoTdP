package Visitors;

import Logica.Disparo;
import Logica.abstracto.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;

public class VisitorPinche extends Visitor{
	
	public VisitorPinche(Personaje p) {
		miEntidad=p;
	}

	@Override
	public void visitAliado(DisparoAbstracto a) {
		
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		e.recibirDaño(2);
		e.avanzar();
	}

	@Override
	public void DetectorTorre(Torre e) {
		// TODO Auto-generated method stub
		
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
