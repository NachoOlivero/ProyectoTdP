package Logica;

import java.util.LinkedList;
import java.util.List;

import PowerUp.Bomba;

public class Jugador {
	
	protected int dinero;
	protected int puntaje;
	protected List<Bomba> listaBombas;
	
	public Jugador() {
		listaBombas=new LinkedList<Bomba>();
		dinero=100;
		puntaje=0;
	}
	
	public int getDinero() {
		return dinero;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public int getBombas() {
		return listaBombas.size();
	}
	
	public void setPuntaje(int d) {
		puntaje=d;
		actualizarGUI();
	}
	
	public void setDinero(int a) {
		dinero=a;
		actualizarGUI();
	}
	
	private void actualizarGUI() {
		Singleton.getGui().actualizarValores();
	}
	
	public void insertarBomba(Bomba bomba) {
		listaBombas.add(bomba);
		Singleton.getGui().actualizarValores();
	}
	
	public Bomba getBomba() {
		Bomba bombaRet=null;
		if(listaBombas.isEmpty())
			return bombaRet;
		else {
			bombaRet=listaBombas.get(0);  //verificar tema indices del get 
			listaBombas.remove(bombaRet);
			Singleton.getGui().actualizarValores();
			return bombaRet;
		}
	}

}
