package Logica;

public class Disparo {
	protected int alcance_maximo;
	protected float daño;
	
	public Disparo(int alcance, float dñ) {
		alcance_maximo=alcance;
		daño=dñ;
	}
	
	public void decrementarAlcance() {
		alcance_maximo--;
	}
}
