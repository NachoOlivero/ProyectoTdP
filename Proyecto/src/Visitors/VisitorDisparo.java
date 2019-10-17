package Visitors;

import Logica.Disparo;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class VisitorDisparo extends Visitor {

public void visitAliado(Disparo a) {
	
}


public void visitEnemigo(Enemigo e) {
	miEntidad.atacar(e);
}



}
