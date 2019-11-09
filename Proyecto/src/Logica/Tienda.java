package Logica;

import Logica.abstracto.Torre;
import PowerUp.Barrera;
import PowerUp.Bomba;
import PowerUp.SpeedUp;
import Logica.Torres.*;
public class  Tienda {

	public static Torre comprarT1() {
		int costoTorre=Torre1.costo();
		int dineroDisponible=Singleton.getJugador().getDinero();
		Torre toReturn=null;
		if(dineroDisponible>=costoTorre) {
			Singleton.getJugador().setDinero(dineroDisponible-costoTorre);
			toReturn=new Torre1();
		}
		return toReturn;
	}
	
	public static Torre comprarT2() {
		int costoTorre=Torre2.costo();
		int dineroDisponible=Singleton.getJugador().getDinero();
		Torre toReturn=null;
		if(dineroDisponible>=costoTorre) {
			Singleton.getJugador().setDinero(dineroDisponible-costoTorre);
			toReturn=new Torre2();
		}
		return toReturn;
	}
	
	public static Torre comprarT3() {
		int costoTorre=Torre3.costo();
		int dineroDisponible=Singleton.getJugador().getDinero();
		Torre toReturn=null;
		if(dineroDisponible>=costoTorre) {
			Singleton.getJugador().setDinero(dineroDisponible-costoTorre);
			toReturn=new Torre3();
		}
		return toReturn;
	}
	
	public static Torre comprarDinero() {
		int costoTorre=TorreDinero.costo();
		int dineroDisponible=Singleton.getJugador().getDinero();
		Torre toReturn=null;
		if(dineroDisponible>=costoTorre) {
			Singleton.getJugador().setDinero(dineroDisponible-costoTorre);
			toReturn=new TorreDinero();
		}
		return toReturn;
	}
	
	public static Torre comprarBarricada() {
		int costoTorre=Barricada.costo();
		int dineroDisponible=Singleton.getJugador().getDinero();
		Torre toReturn=null;
		if(dineroDisponible>=costoTorre) {
			Singleton.getJugador().setDinero(dineroDisponible-costoTorre);
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
