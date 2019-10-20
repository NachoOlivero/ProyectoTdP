package GUI;

import java.util.List;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Logica.Singleton;

import Logica.abstracto.Torre;

public class Eliminador {

	public void eliminar(JLabel a,ImageIcon b) {
		Timer timer=new Timer();
		a.setIcon(b);
		timer.schedule(new eliminar(a), 5000);

	}
	
	private class eliminar extends TimerTask {
		private JLabel a;
		eliminar(JLabel a){
			this.a=a;
		}
		public void run() {
			
			GUI gui=Singleton.getGui();
			a.setVisible(false);
			a.setIcon(null);
			gui.remove(a);

			
		}
	}
}
	
	
	
	


