package Logica.abstracto;

import Visitors.Visitor;

public abstract class Estructura extends Personaje {

	public void eliminar() {
		celda.eliminarEstructura();
		grafico.eliminar();
	}
	
	public boolean aceptarVenta(Visitor v) {
		return v.venta(this);
	}
	
	public void recibirDa�o(float da�o) {
		hp-=da�o;
		if(hp<=0) {
			eliminar();
		}
	}

}
