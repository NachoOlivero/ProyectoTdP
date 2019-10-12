package Logica;

public class Jugador {
	
	protected int dinero;
	protected int puntaje;
	
	public Jugador() {
		dinero=100;
		puntaje=0;
	}
	
	public int getDinero() {
		return dinero;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void aumentarDinero(int d) {
		dinero+=d;
		actualizarGUI();
	}
	
	public void reducirDinero(int d) {
		dinero-=d;
		actualizarGUI();
	}
	
	public void aumentarPuntaje(int p) {
		puntaje+=p;
		actualizarGUI();
	}
	private void actualizarGUI() {
		Singleton.getGui().actualizarPunOdin();
	}

}
