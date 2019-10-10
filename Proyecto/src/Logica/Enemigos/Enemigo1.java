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
		if (celda.hayTorre())
			atacar(celda.getTorre());
		else {
			grafico.avanzar();
			if(pos>max) {
				celda.moverEnemigoCelda(this);
				pos=1;
			}
			pos+=vel;
			
		}
	}

	public void atacar(Personaje p) {
		p.recibirDa�o(dp);
		
	}

	public void recibirDa�o(float da�o) {
		hp-=da�o;
		if(hp<=0) 
			Eliminar();
	}
	
	public ObjetoGrafico getGrafico() {
		return grafico;
	}
	
	public void Eliminar() {
		celda.eliminarEnemigo(this);
		grafico.eliminar();
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

}
