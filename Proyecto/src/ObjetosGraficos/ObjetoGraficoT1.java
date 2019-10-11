package ObjetosGraficos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.GUI;
import GUI.fabricaT;
import Logica.Celda;
import Logica.Singleton;

public class ObjetoGraficoT1 extends OGTorre {
	
	public ObjetoGraficoT1(Celda c) {
		fabricaT to=new fabricaT();
		ImageIcon imagen = to.Torre1();
		GUI gui=Singleton.getGui();
		grafico=new JLabel(imagen);
		grafico.setBounds((c.getX()*120)+40, (c.getY()*100)-15 , 80, 90);
		gui.add(grafico);
		grafico.setVisible(true);
		gui.repaint();
		
	}
}
