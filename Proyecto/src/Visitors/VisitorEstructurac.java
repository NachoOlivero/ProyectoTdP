package Visitors;

import Estructuras.Charco;
import Logica.Disparo;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class VisitorEstructurac extends Visitor {
	
	
	public VisitorEstructurac(Charco h){
		miEntidad=h;	
	}


	public void visitAliado(Disparo a) {
		
		
	}

	public void visitEnemigo(Enemigo e) {
			e.avanzar();
		
	}


	@Override
	public void DetectorTorre(Torre e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void DisparoEnemigo(Disparo a) {
		// TODO Auto-generated method stub
		
	}

}
