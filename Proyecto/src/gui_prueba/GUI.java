package gui_prueba;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanelConFondo contentPane;
	
	//private JLabel dibujo;

	private JLabel enemigo;
	private JLabel dibujo;
	private JButton[] botonesT;

	/**
	 * Launch the application.
	 */
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
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		addMouseListener(new Mouse());
		getContentPane().setLayout(new GridLayout(2,1));
		getContentPane().setLayout(null);
			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1200, 700);
		setResizable(false);
		
		contentPane = new JPanelConFondo("./mapa ver 1.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBotones= new JPanel();
		panelBotones.setVisible(true);
		panelBotones.setLayout(new GridLayout(1,6));
		add(panelBotones);
		
		botonesT=new JButton[6];
		for(int b=1 ; b<6;  b++) {
		botonesT[b]=new JButton("test:"+b);
		contentPane.add(botonesT[b]);
		botonesT[b].setBounds(40+(b*100), 590 , 70, 70);
		//agregar listener
		}
		//System.out.println(getWidth()+":::::"+getHeight());
	}
	
	
	
	private void agregarDibujo(int x,int y){
		//agrega dibujo solo dentro de las coordenadas posibles
		if(x>50 && x<1150 && y<600) {
		//System.out.println(x+"::::"+y);
		x=(x-50)/110; //compenso el espacio de 50 pixeles que decidimos no utilizar
		y=y/100;
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("./torre1.1.jpg"));
		dibujo = new JLabel(imagen);
		
		dibujo.setBounds((x*110)+75, (y*100) +10, 50, 50);  //75=50 de lo compensado  y 25 extra para centrar (el 10 del y tambien es para centrar)
															//110 y 100 son el ancho y el alto en px de las celdas
		this.add(dibujo);
		}
	}
	
	public void mover() {
		
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