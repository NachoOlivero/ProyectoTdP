package Visitors;

import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class VisitorDisparo extends Visitor {

public void visitAliado(Torre a) {
	
}


public void visitEnemigo(Enemigo e) {
	miEntidad.atacar(e);
}



}
