package Logica.Torres;

import Logica.Celda;
import Logica.Disparo;
import Logica.abstracto.Torre;
import ObjetosGraficos.ObjetoGraficoT1;

public class Torre1 extends Torre {
	
	public Torre1() {
		this.hp=500;
		this.dp=500;
		this.rango=5;
		cooldown=0;
		grafico=null;
	}
	public void setCelda(Celda c) {
		grafico=new ObjetoGraficoT1(c);
		celda=c;
	}

	public void atacar() {
		if(cooldown==0) {
		Disparo disp=new Disparo(rango,dp,celda);
		celda.añadirDisparo(disp);
		cooldown=6;
		}else
			cooldown--;
	}
	
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0) {
			celda.eliminarTorre();
			grafico.eliminar();
		}
	}
}
