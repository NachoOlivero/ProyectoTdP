package Logica.abstracto;

public abstract class Personaje extends ObjetoJuego {
	protected float hp;
	protected float dp;
	protected int rango;
	
	public abstract void atacar(Personaje p);
	public abstract void recibirDaño(float daño);

}
