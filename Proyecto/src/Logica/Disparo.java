package Logica;

public class Disparo {
	protected int recorrido_restante;
	protected float daño;
	
	public Disparo(int alcance, float dñ) {
		recorrido_restante=alcance;
		daño=dñ;
	}
	
	public void decrementarAlcance() {
		recorrido_restante--;
	}
}
