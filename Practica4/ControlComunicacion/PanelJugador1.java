package Practica4.ControlComunicacion;

import Practica4.ControlComunicacion.BarcoP;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelJugador1 extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	private BufferedImage cuadricula;
	private Object[][] array;
	public static final int X = 54; // X coordenada de la parte superior izquierda
	public static final int Y = 56; // Y coordenada de la parte superior izquierda
	public static final int titulo = 47; // Tamaño de los espacios del titulo
	public static final int borde = 5; // tamaño del borde entre espacios
	private volatile boolean isTurn;
	private boolean state;

	/*
	 * Constructor predeterminado. Usa una matriz vacía
	 */
	public PanelJugador1() {
		this(new Object[10][10], "gridLabels.png");
	}

	/*
	 * Constructor que toma una matriz
	 */
	public PanelJugador1(Object[][] arr) {
		this(arr, "gridLabels.png");
	}

	/*
	 * constructor que toma una matriz y una ruta de archivo.
	 */
	public PanelJugador1(Object[][] arr, String path) {
		array = arr;
		isTurn = true;
		state = false;
		// hace que el fondo sea blanco y establece el tamaño
		setBackground(Color.blue);
		setPreferredSize(new Dimension((X+ arr.length + 1 + ((titulo+borde)*array.length)), 
				Y+ arr.length + 1 + ((titulo+borde)*array.length)));
		setSize(getPreferredSize());
		setLocation(0,0);

		try {
			cuadricula = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// dibuja la cuadrícula
		g2.drawImage(cuadricula, 0, 0, this);

		// recorre todos los puntos de la cuadrícula
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				// comprueba si hay un 1 o un Barco que no ha sido
                                // destruido
				if (array[i][j].equals((Object) 1) || ((array[i][j]).getClass().getName().equals("ShipPiece")
						&& !((BarcoP) array[i][j]).Destruido())) {
					// cubre el lugar de la cuadrícula con un cuadro gris
					g2.setColor(Color.gray);
					g2.fillRect(X + i + 1 + ((titulo + borde) * i), Y + j + 1 + ((titulo + borde) * j),
							titulo+(borde/2)-1, titulo+(borde/2)-1);
					// si hay una pieza de barco en la posición que está
                                         // destruido
				} else if ((array[i][j]).getClass().getName().equals("ShipPiece")) {
					// dibuja la imagen asociada con la pieza del barco
					g2.drawImage(((BarcoP) array[i][j]).getImagen(),
							X + i + ((titulo + borde) * i) + borde/2,
							Y + j + ((titulo + borde) * j) + borde/2, this);
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// click izquierdo
		if (isTurn && e.getButton() == MouseEvent.BUTTON1) {

			// convierte la coordenada x del mouse en una coordenada x en la
                          // matriz de cuadrícula usando MATH
			int value = e.getX();
			int counter1 = 0;
			while (X + ((titulo + borde) * counter1) + borde < value) {
				counter1++;
			}
			counter1--;

			// convierte la coordenada y del mouse en una coordenada y en la
// matriz de cuadrícula usando MATH
			int value2 = e.getY() - (borde / 2);
			int counter2 = 0;
			while (Y + ((titulo + borde) * counter2) + borde < value2) {
				counter2++;
			}
			counter2--;

			// si (contador1, contador2) es una posición válida en la matriz
			if (counter1 < array.length && counter1 >= 0) {
				if (counter2 < array[0].length && counter2 >= 0) {
					// si el objeto en la coordenada es 1
					if (array[counter1][counter2].equals((Object) 1)) {
						// establece el objeto en la coordenada en 0 (un vacío
                                               // espacio)
						array[counter1][counter2] = 0;
						repaint();
						// fin del turno
						isTurn = false;
						// si el objeto en la coordenada es un Barco que
                                                // no se destruye
					} else if ((array[counter1][counter2]).getClass().getName().equals("ShipPiece")//Se puede bborrar
							&& !((BarcoP) array[counter1][counter2]).Destruido()) {
						// Destruye el Barco
						((BarcoP) array[counter1][counter2]).destruir();
						repaint();
						// Fin
						isTurn = false;
					}
					state = false;
				}
			}
		}else if(!isTurn && e.getButton() == MouseEvent.BUTTON1){
			state = true;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	/*
	 * Devoluciones isTurn
	 */
	public boolean isTurn() {
		return isTurn;
	}

	/*
	 * Establece el giro al parámetro
	 */
	public void setTurn(boolean t) {
		isTurn = t;
	}

	/*
	 * Devuelve la matriz de cuadrícula
	 */
	public Object[][] getArray() {
		return array;
	}

	/*
	 * Establece la matriz de cuadrícula en el parámetro
	 */
	public void setArray(Object[][] arr) {
		array = arr;
	}
	
	public boolean getState(){
		return state;
	}
	
	public void setState(boolean s){
		state = s;
	}

}

