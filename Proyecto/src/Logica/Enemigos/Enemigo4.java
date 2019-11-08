package Logica.Enemigos;

import Grafica.OGEnemigo;
import Logica.Celda;
import Visitors.VisitorEnemigos;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estado;
import Logica.abstracto.Personaje;


public class Enemigo4 extends Enemigo {
	
	public Enemigo4(Celda cel,Estado est) {//enemigo lento que pega mucho (carga el ataque)
		hp=120;
		dp=60;
		vel=1;
		celda=cel;
		estado=est;
		grafico=new OGEnemigo(estado.getFactory().Enemigo4(),celda.getFila());
		visitor=new VisitorEnemigos(this);
		cooldown=40;
		cooldownMax=40;
	}
	public void turno() {
		MovD=vel;
		celda.recibirEnemigo(this);
	}
	public void atacar(Personaje p) {
	if(cooldown==0) {
		p.recibirDaño(dp);
		cooldown=cooldownMax;
	}else cooldown--;
	}
}
