package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanelConFondo contentPane;
	private JButton[] botonesT;

	public GUI() {
		//addMouseListener(new Mouse());
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1200, 700);
		setResizable(false);
		
		contentPane = new JPanelConFondo("./mapa ver 1.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		botonesT=new JButton[6];
		for(int b=0 ; b<6;  b++) {
		botonesT[b]=new JButton("test:"+b);
		contentPane.add(botonesT[b]);
		botonesT[b].setBounds(40+(b*100), 590 , 70, 70);
		//agregar listener
		}
	}
	
	public void agregarOyenteBoton(ActionListener ac,int boton) {
		botonesT[boton].addActionListener(ac);
	}
	
	public void agregarOyenteClick(MouseListener ac) {
		addMouseListener(ac);
	}
	
}
