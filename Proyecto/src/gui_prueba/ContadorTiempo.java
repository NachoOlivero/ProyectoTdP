package gui_prueba;


public class ContadorTiempo extends Thread {

	private GUI gui;

	ContadorTiempo(GUI gui) {
		this.gui = gui;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gui.mover();
		}
	}
}
