package Logica.abstracto;

public abstract class EnemigoDistancia extends Enemigo {
	protected boolean TorreDetectada;
	protected int rango;
	
	public void setTD(boolean l) {
		TorreDetectada=l;
	}
	
	public int Rango() {
		return rango;
	}
}
