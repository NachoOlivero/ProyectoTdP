package gui_prueba;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gui_mapa_inicial extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanelConFondo contentPane;
	
	private JLabel dibujo;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_mapa_inicial frame = new gui_mapa_inicial();
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
	public gui_mapa_inicial() {
		addMouseListener(new Mouse());
		getContentPane().setLayout(null);
			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		setResizable(false);
		
		contentPane = new JPanelConFondo("./torre1.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**JLabel imFondo=new JLabel();
		ImageIcon fondo = new ImageIcon(this.getClass().getResource("./torre1.png"));
		imFondo.setIcon(fondo);
		imFondo.setBounds(100, 100, 450, 300);
		contentPane.add(imFondo);
		*/
	}
	
	
	
	private void agregarDibujo(int x,int y){
		x-=x % 145;
		y-=y % 130;
		
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("./torre1.png"));
		dibujo = new JLabel(imagen);
		
		dibujo.setBounds(x, y, 50, 100);
		
		this.add(dibujo);
	}
	
	//public Indices getIndices(int x, int y) {
		
	//}
	
	private class Mouse implements MouseListener { 
	          
	        
	    public void mouseClicked(MouseEvent e) {  
	       agregarDibujo(e.getXOnScreen(),e.getYOnScreen());
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
