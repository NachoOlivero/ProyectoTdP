package Logica;

public class Disparo {
	protected int alcance_maximo;
	protected float da�o;
	
	public Disparo(int alcance, float d�) {
		alcance_maximo=alcance;
		da�o=d�;
	}
	
	public void decrementarAlcance() {
		alcance_maximo--;
	}
}
