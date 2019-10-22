package PowerUp;

import java.util.Random;

import Grafica.ObjetoGrafico;
import Logica.Singleton;

public abstract class PowerUp {
	protected ObjetoGrafico grafico;
	
	public abstract void comenzar();
	
	public void eliminar() {
		Singleton.getMapa().eliminarPowerUp(this);
		grafico.eliminar();
	}
	
	public static void randonPowerUp(int x,int y) {
		Random rand=new Random();
		PowerUp pu=null;
		
		int caso=rand.nextInt(10);
		
		switch (caso) {
		
		case 0:
				pu=new SpeedUp(x,y);
				break;
		case 1:
				pu=new KillAll(x,y);
				break;
		case 2:
				pu=new Barrera(x,y);
				break;
		case 3:
				pu=new Bomba(x,y);
				break;
		
		}
		
		if(pu!=null)
			Singleton.getMapa().insertarPowerUp(pu);
	}
	

}