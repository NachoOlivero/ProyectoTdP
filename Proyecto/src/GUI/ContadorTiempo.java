package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

import Logica.Mapa;
import Logica.Enemigos.Enemigo1;
import Logica.abstracto.Enemigo;
import Logica.abstracto.ObjetoGrafico;

public class ContadorTiempo extends Thread {

	private GUI gui;
	private Mapa mapa;
	
	private boolean agregar=true;
	//KeyListener elim=new ClickEnemigo();

	public ContadorTiempo(GUI gui,Mapa mapa) {
		this.gui = gui;
		this.mapa=mapa;
		
		/**gui.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				aux(arg0);}}
			);*/
		gui.agregarBoton(new Eliminar());
	}
	int aux=0;

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(agregar) {
				crearEnemigo();
				agregar=false;
			}
				aux++;
				mapa.mover();
				System.out.println(aux);
			
			mapa.mover();

		}
	}
	
	private Enemigo crearEnemigo() {
		Enemigo nuevo=new Enemigo1(null);
		Random r=new Random();
		int fila=r.nextInt(5);
		
		mapa.insertarEnemigo(nuevo,fila);
		System.out.println(nuevo.getGrafico());
		nuevo.getGrafico().getGrafico().setBounds(1100, 500-100*fila, 50, 50);
		gui.add(nuevo.getGrafico().getGrafico());
		
		return nuevo;
	}
	
	/**public class ClickEnemigo implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			//if((int)e.getKeyChar()==8) {
				//Enemigo rem=listaEnemigos.removeFirst();
				gui.remove(listaEnemigos.removeFirst().getGrafico().getGrafico());
				System.out.println("hola");
			//}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}*/

	public class Eliminar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
				mapa.KillAll();
				agregar=true;
			
		}
		
	}
}
