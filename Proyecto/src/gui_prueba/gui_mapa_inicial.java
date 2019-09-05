package gui_prueba;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gui_mapa_inicial extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	
	
	private void agregarDibujo(int x,int y){
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("./up.png"));
		dibujo = new JLabel(imagen);
		
		dibujo.setBounds(x, y, 25, 25);
		
		this.add(dibujo);
	}
	
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
