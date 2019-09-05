package Logica;

public class Celda {
	protected Torre torre;
	protected Enemigo enemigo; //o bien una coleccion de enemigos
	protected int fila;
	
	public Celda(int f) {
		torre=null;
		enemigo=null; //o bien inicializar la coleccion
		fila=f;
	}
	
	public boolean hayTorre() {
		return torre!=null;
	}
	
	public Torre getTorre() {
		return torre;
	}
	
	public void eliminarTorre() {  //avisar al mapa
		torre=null;
	}
	
	public void añadirDisparo(Disparo disp) {
		//añadirlo a la coleccion de disparos
	}
}
