package Visitors;

import Estructuras.charco;
import Logica.Disparo;
import Logica.abstracto.Enemigo;

public class VisitorEstructurac extends Visitor {
	
	int contador;
	
	public VisitorEstructurac(charco h){
		miEntidad=h;
		contador=0;
	}


	public void visitAliado(Disparo a) {
		
		
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		if (contador==0) {
			e.avanzar();
			contador++;
		}
		else contador--;
		
	}

}
