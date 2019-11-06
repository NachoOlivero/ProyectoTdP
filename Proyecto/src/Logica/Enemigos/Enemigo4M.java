package Logica.Enemigos;

import Logica.Celda;

public class Enemigo4M extends Enemigo4 {
	protected boolean recibeDaño;

	public Enemigo4M(Celda cel) {
		super(cel);
		recibeDaño=false;
		//grafico.setImagen();
	}
	
	public void recibirDaño(float daño) {
		if(recibeDaño) {
			recibeDaño=false;
			super.recibirDaño(daño);
		}
		else recibeDaño=true;
	}

}
