package Logica;

public class Enemigo1 extends Enemigo{

	public void avanzar() {
		if (celda.hayTorre())
			atacar(celda.getTorre());
		else avanzar();
	}

	public void atacar(Personaje p) {
		p.recibirDa�o(dp);
		
	}

	public void recibirDa�o(float da�o) {
		hp-=da�o;
		//if(hp<=0)
			//retirar de la celda
	}

}
