package Logica.Enemigos;

import Grafica.OGEnemigo1;
import Grafica.ObjetoGrafico;
import Logica.Celda;
import Logica.Disparo;
import Logica.Singleton;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Personaje;
import PowerUp.PowerUp;
import Visitors.VisitorEnemigos;

public class Enemigo1 extends Enemigo{

	public Enemigo1(Celda cel) {
		hp=15;
		dp=5;
		celda=cel;
		vel=1;
		grafico=new OGEnemigo1();
		visitor=new VisitorEnemigos(this);
	}
	
	public void avanzar() {
				grafico.avanzar();
				pos-=vel;
				if(pos<min) {
					celda.moverEnemigoCelda(this);
					pos=120;
				 }
	}

	public void atacar(Personaje p) {
		p.recibirDaño(dp);
		
	}

	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0) 
			Eliminar();
		//else
		//System.out.println(":::::daño:::::");
	}
	
	public ObjetoGrafico getGrafico() {
		return grafico;
	}
	
	public void Eliminar() {
		celda.eliminarEnemigo(this);
		grafico.eliminar();
		Singleton.getJugador().aumentarPuntaje(20);
		Singleton.getJugador().aumentarDinero(50);
		PowerUp.randonPowerUp(grafico.getGrafico().getX(),grafico.getGrafico().getY());
	}
	
	public void actualizarCelda(Celda c) {
		celda=c;
	}
	
	public boolean estaEnPosicion(int pos) {
		return this.pos==pos;
	}
	
	public boolean tieneMenorPosicion(int pos) {
		return this.pos<pos;
	}
	
	public void setGrafico(int pos) {
		grafico.setPosicion(pos);
	}

}
