package Logica;

import Logica.abstracto.Torre;
import PowerUp.Barrera;
import PowerUp.Bomba;
import PowerUp.KillAll;
import PowerUp.SpeedUp;
import Logica.Torres.*;
public class  Tienda {

	public static Torre comprarT1() {
		int aux;
		Torre toReturn=null;
		Torre auxt=new Torre1();
		if(Singleton.getJugador().getDinero()>=auxt.getCosto()) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-100);
			toReturn=auxt;
		}
		return toReturn;
	}
	
	public static Torre comprarT3() {
		int aux;
		Torre toReturn=null;
		Torre auxt=new Torre3();
		if(Singleton.getJugador().getDinero()>=auxt.getCosto()) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-200);
			toReturn=auxt;
		}
		return toReturn;
	}
	public static Torre comprarT2() {
		int aux;
		Torre toReturn=null;
		Torre auxt=new Torre2();
		if(Singleton.getJugador().getDinero()>=auxt.getCosto()) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-200);
			toReturn=auxt;
		}
		return toReturn;
	}
	
	public static Torre comprarDinero() {
		int aux;
		Torre toReturn=null;
		Torre auxt=new TorreDinero();
		if(Singleton.getJugador().getDinero()>=auxt.getCosto()) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-50);
			toReturn=auxt;
		}
		return toReturn;
	}
	
	public static Torre comprarBarricada() {
		int aux;
		Torre toReturn=null;
		Torre auxt=new Barricada();
		if(Singleton.getJugador().getDinero()>=auxt.getCosto()) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-140);
			toReturn=auxt;
		}
		return toReturn;
	}
	
	public static Bomba comprarBomba() {
		int dinero=Singleton.getJugador().getDinero();
		Bomba toRet=null;
		if(dinero>=Bomba.getCosto()) {
			Singleton.getJugador().setDinero(dinero-Bomba.getCosto());
			toRet=new Bomba();
			Singleton.getJugador().insertarBomba(toRet);
		}
		return toRet;	
	}
	
	public static void comprarKillAll() {
		int dinero=Singleton.getJugador().getDinero();
		if(dinero>=KillAll.getCosto()) {
			Singleton.getJugador().setDinero(dinero-KillAll.getCosto());
			Singleton.getMapa().KillAll();
		}
	}
	
	public static void comprarSpeedUp() {
		int dinero=Singleton.getJugador().getDinero();
		if(dinero>=SpeedUp.getCosto()) {
			Singleton.getJugador().setDinero(dinero-SpeedUp.getCosto());
			SpeedUp spUp=new SpeedUp();
			spUp.comenzar();
		}
	}
	
	public static Barrera comprarBarrera() {
		int dinero=Singleton.getJugador().getDinero();
		Barrera toRet=null;
		if(dinero>=Barrera.getCosto()) {
			Singleton.getJugador().setDinero(dinero-Barrera.getCosto());
			toRet=new Barrera();
		}
		return toRet;	
	}
	
}
