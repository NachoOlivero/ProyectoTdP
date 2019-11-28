package Logica.abstracto;

import javax.swing.ImageIcon;

import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
import Grafica.OGEnemigo;
import Grafica.ObjetoGrafico;
import Logica.Celda;
import Logica.Singleton;
import PowerUp.PowerUp;

public abstract class Enemigo extends Personaje{
	protected int vel;

	protected final int min=1;
	protected int pos=120;
	//protected boolean charco=false;
	protected int tiempoFrenar=0;
	protected int MovD;
	protected int cooldown;
	protected int cooldownMax;
	protected Estado estado;
	
	
	public int PosActual() {
		return pos;
	}
	
	public void turno() {
		if(cooldown!=0)
			cooldown--;
		MovD=vel;
		celda.recibirEnemigo(this);
		AvisarTorres();
	}
	
	
	protected void AvisarTorres() {
		if(celda!=null)//Revisa que no llegue al final del nivel
			for(int i=0;i!=celda.getColumna();i++)
				Singleton.getMapa().getCelda(celda.getFila(), i).detectarEnemigo(this);
		else System.out.println("Solo al final");
	}
	public void avanzar() {
			MovD--;
			if(MovD>=0) {
			grafico.avanzar();
			pos-=1;
			if(pos<min) {
				celda.moverEnemigoCelda(this);
				pos=120;
				}
			if(celda!=null) //solucion temporal
				celda.recibirEnemigo(this);
		
			}
	}

	public void atacar(Personaje p) {
		if(cooldown==0) {
			p.recibirDaño(dp);
			cooldown=cooldownMax;
		}
	}
	
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0) {
			Eliminar();
		}
	}
	
	public ObjetoGrafico getGrafico() {
		return grafico;
	}
	
	public void Eliminar() {
		int aux;
		celda.eliminarEnemigo(this);
		grafico.eliminar();
		aux=Singleton.getJugador().getPuntaje();
		Singleton.getJugador().setPuntaje(aux+20);
		PowerUp.randonPowerUp(grafico.getGrafico().getX(),grafico.getGrafico().getY());
	}
	
	public void actualizarCelda(Celda c) {
		celda=c;
	}
	
	public boolean estaEnPosicion(int pos) {
		return this.pos==pos;
	}
	
	public boolean tieneMenorPosicion(int pos) {
		return this.pos<pos;
	}
	
	public void setImagen(ImageIcon imagen) {
		grafico.setImage(imagen);
	}
		
}
