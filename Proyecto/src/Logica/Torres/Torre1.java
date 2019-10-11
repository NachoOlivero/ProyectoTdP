package Logica.Torres;

import Logica.Celda;
import Logica.Disparo;
import Logica.abstracto.Torre;
import ObjetosGraficos.ObjetoGraficoT1;

public class Torre1 extends Torre {
	
	public Torre1(Celda cel) {
		this.hp=500;
		this.dp=500;
		this.celda=cel;
		this.rango=5;
		grafico=new ObjetoGraficoT1(cel);
	}

	public void atacar() {
		Disparo disp=new Disparo(rango,dp,celda);
		celda.añadirDisparo(disp);
	}
	
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0) {
			celda.eliminarTorre();
			grafico.eliminar();
		}
	}
}
