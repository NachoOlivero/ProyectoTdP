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
		celda.añadirDisparo(disp);
	}
	
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0)
			celda.eliminarTorre();
		}
}
