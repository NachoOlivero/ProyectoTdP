package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanelConFondo contentPane;
	
	private JLabel dibujo;

	private JButton[] botonesT;
    private abstractFactoriT torres;
	private JLabel[][] matrizTorres ;
	
	private JLabel iconPrueba;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public GUI() {
		addMouseListener(new Mouse());
		getContentPane().setLayout(null);
		torres=new fabricaT(); 
		 matrizTorres=new JLabel[10][6];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1200, 700);
		setResizable(false);
		
		contentPane = new JPanelConFondo("./mapa ver 1.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ImageIcon imagen = torres.Torre1();
		//iconPrueba=new JLabel(imagen);
		//iconPrueba.setBounds(650, 300, 50, 50);
		//this.add(iconPrueba);

		botonesT=new JButton[6];
		for(int b=1 ; b<6;  b++) {
		botonesT[b]=new JButton("test:"+b);
		contentPane.add(botonesT[b]);
		botonesT[b].setBounds(40+(b*100), 590 , 70, 70);
		
		//agregar listener
		}
		//System.out.println(getWidth()+":::::"+getHeight());
		/**JLabel imFondo=new JLabel();
		ImageIcon fondo = new ImageIcon(this.getClass().getResource("./torre1.png"));
		imFondo.setIcon(fondo);
		imFondo.setBounds(100, 100, 450, 300);
		contentPane.add(imFondo);
		*/
	}
	
	
	
	private void agregarDibujo(int x,int y){
		JLabel dibujo;
		//agrega dibujo solo dentro de las coordenadas posibles
		if(x>50 && x<1150 && y<600) {
		//System.out.println(x+"::::"+y);
			x=(x-50)/110; //compenso el espacio de 50 pixeles que decidimos no utilizar
			y=y/100;
			if(matrizTorres[x][y]==null) {
			    ImageIcon imagen = torres.Torre1();
				//dibujo = new JLabel("");
				dibujo = new JLabel(imagen);
				//dibujo.setIcon(imagen);
				matrizTorres[x][y]=dibujo;
				dibujo.setBounds((x*110)+60, (y*100)-15 , 80, 90);  //75=50 de lo compensado  y 20 extra para centrar (el 10 del y tambien es para centrar)
																	//110 y 100 son el ancho y el alto en px de las celdas
				this.add(dibujo);
		}
		}
	}
	
	public void moverImagen() {
		iconPrueba.setBounds(iconPrueba.getX()-10, iconPrueba.getY(), 50, 50);
	}
	
	public void mover() {
		
	}
	public void agregarEnemigo(JLabel enemigo) {
		int numero=(int) (Math.random()*6);
		enemigo.setBounds(1200,numero*50,50,50);
		this.add(enemigo);
		
	}
	
	//public Indices getIndices(int x, int y) {
		
	//}
	
	private class Mouse implements MouseListener { 
	          
	        
	    public void mouseClicked(MouseEvent e) { 
	    
	       agregarDibujo(e.getX(),e.getY());
	       repaint();
	    }  
	    public void mouseEntered(MouseEvent e) {  
	    }  
	    public void mouseExited(MouseEvent e) {   
	    }  
	    public void mousePressed(MouseEvent e) {  
	    }  
	    public void mouseReleased(MouseEvent e) {  
	    }  
 }

}
