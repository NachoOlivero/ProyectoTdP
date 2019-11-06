package Logica.abstracto;

public abstract class Estructura extends Personaje {

	public void eliminar() {
		celda.eliminarEstructura();
		grafico.eliminar();
	}

}
