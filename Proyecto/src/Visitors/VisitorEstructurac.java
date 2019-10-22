package Visitors;

import Estructuras.Charco;
import Logica.Disparo;
import Logica.abstracto.Enemigo;

public class VisitorEstructurac extends Visitor {
	
	
	public VisitorEstructurac(Charco h){
		miEntidad=h;	
	}


	public void visitAliado(Disparo a) {
		
		
	}

	public void visitEnemigo(Enemigo e) {
			e.avanzar();
		
	}

}
