package Logica.Enemigos;

import Logica.Celda;

public class Enemigo4M extends Enemigo4 {
	protected boolean recibeDa�o;

	public Enemigo4M(Celda cel) {
		super(cel);
		recibeDa�o=false;
		//grafico.setImagen();
	}
	
	public void recibirDa�o(float da�o) {
		if(recibeDa�o) {
			recibeDa�o=false;
			super.recibirDa�o(da�o);
		}
		else recibeDa�o=true;
	}

}
