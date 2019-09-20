package Logica.Enemigos;

import Logica.abstracto.OGEnemigo;
import Logica.abstracto.OGEnemigo1;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Personaje;

public class Enemigo1 extends Enemigo{

	public Enemigo1() {
		hp=100;
		dp=100;
		celda=null;
		grafico=new OGEnemigo1();
	}
	
	public void avanzar() {
		//if (celda.hayTorre())
			//atacar(celda.getTorre());
		 grafico.avanzar();
	}

	public void atacar(Personaje p) {
		p.recibirDa�o(dp);
		
	}

	public void recibirDa�o(float da�o) {
		hp-=da�o;
		//if(hp<=0)
			//retirar de la celda
	}

}
