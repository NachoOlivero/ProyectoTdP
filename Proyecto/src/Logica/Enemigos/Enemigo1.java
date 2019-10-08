package Logica.Enemigos;

import Logica.abstracto.OGEnemigo1;
import Logica.abstracto.ObjetoGrafico;
import Logica.Celda;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Personaje;

public class Enemigo1 extends Enemigo{

	public Enemigo1(Celda cel) {
		hp=100;
		dp=100;
		celda=cel;
		vel=1;
		grafico=new OGEnemigo1();
	}
	
	public void avanzar() {
		//if (celda.hayTorre())
			//atacar(celda.getTorre());
		//else {
			grafico.avanzar();
			if(pos>max) {
				celda.moverEnemigoCelda(this);
				pos=1;
			}
			pos+=vel;
			
		//}
	}

	public void atacar(Personaje p) {
		p.recibirDaño(dp);
		
	}

	public void recibirDaño(float daño) {
		hp-=daño;
		//if(hp<=0)
			//retirar de la celda
	}
	
	public ObjetoGrafico getGrafico() {
		return grafico;
	}
	
	public void Eliminar() {
		grafico.eliminar();
	}
	
	public void actualizarCelda(Celda c) {
		celda=c;
	}

}
