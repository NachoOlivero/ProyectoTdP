package Logica.Torres;

import Logica.Celda;
import Logica.Disparo;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;

public class Torre1 extends Torre {
	
	public Torre1(Celda cel) {
		this.hp=500;
		this.dp=500;
		this.celda=cel;
	}

	public void atacar(Personaje p) {
		Disparo disp=new Disparo(rango,dp);
		SingletonGui.getGui().add(grafico);
		celda.a�adirDisparo(disp);
	}
	
	public void recibirDa�o(float da�o) {
		hp-=da�o;
		if(hp<=0)
			celda.eliminarTorre();
		}
}
