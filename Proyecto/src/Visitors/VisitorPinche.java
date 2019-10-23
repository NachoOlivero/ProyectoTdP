package Visitors;

import Logica.Disparo;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Personaje;

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

}
