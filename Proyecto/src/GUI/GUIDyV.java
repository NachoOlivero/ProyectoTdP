package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

	public class GUIDyV extends JFrame {
		private static final long serialVersionUID = 1L;
		private JPanelConFondo contentPane;
	
		public GUIDyV(String nombre) {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0,0, 1280, 700);
			setResizable(false);
			contentPane = new JPanelConFondo(nombre);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setVisible(true);
		}
	}

