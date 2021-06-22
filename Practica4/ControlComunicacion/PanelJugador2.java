package Practica4.ControlComunicacion;

import Practica4.ControlComunicacion.BarcoP;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelJugador2 extends JPanel {
	private static final long serialVersionUID = 1L;
	private Object[][] array;
	private BufferedImage gridImage;
	public static final int Xs = 23;
	public static final int Ys = 39;
	public static final int titulo2 = 20; 
	public static final int borde = 3; 
	public static final int piezas = 18; 

	/*
	 * Constructor que toma un objeto de matriz 2d
	 */
	public PanelJugador2(Object[][] array) {
		this.array = array;
		
		// establece el fondo en blanco
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((Xs + 2 + (titulo2+borde)*array.length), 
				Ys+ 2 + ((titulo2+borde)*array.length)));
		setSize(getPreferredSize());
		
		// carga el archivo de cuadrícula
		try {
			gridImage = ImageIO.read(new File("gridSmallLabels.png"));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// dibuja la cuadricula
		g2.drawImage(gridImage, 0, 15, this);

		// recorre la matriz
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				// si hay una pieza de barco en la ubicación
				if ((array[i][j]).getClass().getName().equals("ShipPiece")) {
					// dibuja la imagen de la pieza del barco en la cuadrícula adecuada
// localización
					g2.drawImage(((BarcoP) array[i][j]).getImagen(), 
							Xs + 2 + ((titulo2+borde) * i) + borde/2,
							Ys + 2 + ((titulo2+borde) * j) + borde/2,
							piezas, piezas, this);
				}
			}
		}
	}

	/*
	 * Retorna el arreglo
	 */
	public Object[][] getArray() {
		return array;
	}

	/*
	 * Establece la matriz
	 */
	public void setArray(Object[][] array) {
		this.array = array;
	}

}

