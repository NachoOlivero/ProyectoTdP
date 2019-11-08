package Logica;

import Logica.abstracto.Torre;
import PowerUp.Barrera;
import PowerUp.Bomba;
import PowerUp.SpeedUp;
import Logica.Torres.*;
public class  Tienda {

	public static Torre comprarT1() {
		int aux;
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=100) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-100);
			toReturn=new Torre1();
		}
		return toReturn;
	}
	
	public static Torre comprarT3() {
		int aux;
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=200) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-200);
			toReturn=new Torre3();
		}
		return toReturn;
	}
	
	public static Torre comprarDinero() {
		int aux;
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=50) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-50);
			toReturn=new TorreDinero();
		}
		return toReturn;
	}
	
	public static Torre comprarBarricada() {
		int aux;
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=140) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-140);
			toReturn=new Barricada();
		}
		return toReturn;
	}
	
	public static Bomba comprarBomba() {
		int dinero=Singleton.getJugador().getDinero();
		Bomba toRet=null;
		if(dinero>=200) {
			Singleton.getJugador().setDinero(dinero-200);
			toRet=new Bomba();
			Singleton.getJugador().insertarBomba(toRet);
		}
		return toRet;	
	}
	
	public static void comprarKillAll() {
		int dinero=Singleton.getJugador().getDinero();
		if(dinero>=1500) {
			Singleton.getJugador().setDinero(dinero-1500);
			Singleton.getMapa().KillAll();
		}
	}
	
	public static void comprarSpeedUp() {
		int dinero=Singleton.getJugador().getDinero();
		if(dinero>=500) {
			Singleton.getJugador().setDinero(dinero-500);
			SpeedUp spUp=new SpeedUp();
			spUp.comenzar();
		}
	}
	
	public static Barrera comprarBarrera() {
		int dinero=Singleton.getJugador().getDinero();
		Barrera toRet=null;
		if(dinero>=200) {
			Singleton.getJugador().setDinero(dinero-200);
			toRet=new Barrera();
		}
		return toRet;	
	}
	
}
