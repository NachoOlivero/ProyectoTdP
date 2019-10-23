package Logica.abstracto;

public abstract class EnemigoDistancia extends Enemigo {
	protected int rango;
	protected boolean accion;
	protected boolean torre;
	
	
	public void atacar(Personaje p) {
		if(cooldown==0 && celda.getX()-p.getCelda().getX()<=rango) {
			torre=true;
			if(accion) {
			crearDisparo();
			accion=false;
			}
		}torre=false;
		
	}
	
	public void turno() {
		if(cooldown != 0)
			cooldown--;
		celda.recibirEnemigo(this);
	}
	
	private void crearDisparo() {
		
	}
	
	public void avanzar() {
		if(accion && !torre) {//si le queda accion y no detecto torre
			grafico.avanzar();
			pos-=vel;
			if(pos<min) {
				celda.moverEnemigoCelda(this);
				pos=120;
			}	
		}else accion=true; //si no ejecuto la accion recupera una accion
	}
}
