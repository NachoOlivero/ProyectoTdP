package Logica;

public class Disparo {
	protected int recorrido_restante;
	protected float da�o;
	
	public Disparo(int alcance, float d�) {
		recorrido_restante=alcance;
		da�o=d�;
	}
	
	public void decrementarAlcance() {
		recorrido_restante--;
	}
}
