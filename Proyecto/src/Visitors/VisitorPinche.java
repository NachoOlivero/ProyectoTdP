package Visitors;

import Logica.Disparo;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;

public class VisitorPinche extends Visitor{
	
	public VisitorPinche(Personaje p) {
		miEntidad=p;
	}

	@Override
	public void visitAliado(Disparo a) {
		
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
	public void DisparoEnemigo() {
		// TODO Auto-generated method stub
		
	}

}
