package Logica;

public class Enemigo1 extends Enemigo{

	public void avanzar() {
		if (celda.hayTorre())
			atacar(celda.getTorre());
		else avanzar();
	}

	public void atacar(Personaje p) {
		p.recibirDaño(dp);
		
	}

	public void recibirDaño(float daño) {
		hp-=daño;
		//if(hp<=0)
			//retirar de la celda
	}

}
