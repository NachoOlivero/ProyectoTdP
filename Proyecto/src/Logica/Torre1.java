package Logica;

public class Torre1 extends Torre {
	
	public Torre1(Celda cel) {
		this.hp=500;
		this.dp=500;
		this.celda=cel;
	}

	public void atacar(Personaje p) {
		Disparo disp=new Disparo(rango,dp);
		celda.añadirDisparo(disp);
	}
	
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0)
			celda.eliminarTorre();
		}
}
