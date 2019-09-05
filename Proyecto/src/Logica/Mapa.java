package Logica;
public class Mapa {
	Celda celdas[][];
	
	public Mapa(int x,int y) {
		celdas= new Celda[x][y];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				celdas[i][j]=new Celda(i);
	}
}
