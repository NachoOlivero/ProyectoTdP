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
	
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0) {
			eliminar();
		}
	}

}
