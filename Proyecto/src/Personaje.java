
public abstract class Personaje {
	protected float hp;
	protected float dp;
	protected Celda celda;
	
	public abstract void atacar(Personaje p);
	public abstract void recibirDaño(float daño);

}
