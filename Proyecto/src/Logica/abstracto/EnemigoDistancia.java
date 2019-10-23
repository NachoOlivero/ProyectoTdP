package Logica.abstracto;

public abstract class EnemigoDistancia extends Enemigo {
	protected int rango;
	protected boolean accion;
	
	
	public void atacar(Personaje p) {
		if(cooldown==0 && celda.getX()-p.getCelda().getX()<=rango && accion) {
			crearDisparo();
			accion=false;
		}else accion=true;
		
	}
	
	public void turno() {
		if(cooldown != 0)
			cooldown--;
		celda.recibirEnemigo(this);
	}
	
	private void crearDisparo() {
		
	}
	
	public void avanzar() {
		if(accion) {//si le queda accion
			grafico.avanzar();
			pos-=vel;
			if(pos<min) {
				celda.moverEnemigoCelda(this);
				pos=120;
			}	
		}else accion=true; //si no ejecuto la accion recupera una accion
	}
}
