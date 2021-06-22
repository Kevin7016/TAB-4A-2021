package Practica4.Logica;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Practica4.ControlComunicacion.BarcoP;

public class CreadorC extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage gridImage = null;
	private Object[][] gridArray;
	private Barco[] barcoArray;
	private JPanel[] panelArray;
	private JButton endSetup, randomJony;
	private JFrame window;
	private volatile boolean setup = false;
	public static final int X = 54;
	public static final int Y = 56;
	public static final int TILE_SIZE = 47;
	public static final int BORDER_SIZE = 5;
	public static boolean currentlyPlacingShip = false;

	public CreadorC(Barco[] shipArray, JFrame app) {
		this(shipArray, 10, app);
	}

	public CreadorC(Barco[] shipArray, int gridSize, JFrame app) {
		this(shipArray, gridSize, "gridLabels.png", app);
	}

	public CreadorC(Barco[] barcoArray, int gridSize, String path, JFrame app) {
		setLayout(null);
		setBackground(Color.white);
		setLocation(0,0);
		window = app;

		Object[][] grid = new Object[gridSize][gridSize];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = 1;
			}
		}

		gridArray = grid;
		this.barcoArray = barcoArray;
		panelArray = new JPanel[barcoArray.length];

		try {
			gridImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}

	}

	/*
	 * Hace todo el trabajo para configurar la cuadrícula.
	 */
	public void setup() {
		int largestShipSize = 0;
		for (int i = 0; i < barcoArray.length; i++){
			int temp = barcoArray[i].getShipPieces().length;
			if (temp > largestShipSize){
				largestShipSize = temp;
			}
		}
		
		int windowWidth = X + ((TILE_SIZE + BORDER_SIZE) * gridArray.length) + (2 * BORDER_SIZE) + 50
				+ ((largestShipSize + 1) * TILE_SIZE);
		int windowHeight = Y+ ((TILE_SIZE + BORDER_SIZE) * (gridArray.length + 1));
		if (windowHeight < 2 * TILE_SIZE + (barcoArray.length * (TILE_SIZE + BORDER_SIZE + 2))) {
			windowHeight = 2 * TILE_SIZE + (barcoArray.length * (TILE_SIZE + BORDER_SIZE + 2));
		}
		window.setPreferredSize(new Dimension(windowWidth, windowHeight));
		window.setMinimumSize(new Dimension(windowWidth, windowHeight));
		window.pack();
		setSize(window.getContentPane().getSize());

		// crea una etiqueta con la imagen de la cuadrícula y la agrega a la pantalla
		JLabel gridLabel = new JLabel(new ImageIcon(gridImage));
		gridLabel.setSize(X + gridArray.length + 1 + ((TILE_SIZE + BORDER_SIZE) * gridArray.length),
				Y + gridArray.length + 1 + ((TILE_SIZE + BORDER_SIZE) * (gridArray.length)));
		gridLabel.setLocation(0, 0);
		gridLabel.setHorizontalAlignment(SwingConstants.LEFT);
		gridLabel.setVerticalAlignment(SwingConstants.TOP);
		add(gridLabel);

		int buttonXPos = gridLabel.getWidth();

		randomJony = new JButton("Orden Random");
		randomJony.setBounds(buttonXPos, 0, window.getWidth() - buttonXPos, TILE_SIZE - 5);
		randomJony.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				for (int i = 0; i < panelArray.length; i++) {
					panelArray[i].setLocation(barcoArray[i].getStartingOffGridPosition());
				}
				for (int i = 0; i < panelArray.length; i++) {
					int timeout = 0;
					while (timeout < 500
							&& barcoArray[i].getStartingOffGridPosition().equals(panelArray[i].getLocation())) {
						int x = rand.nextInt(gridArray.length);
						int y = rand.nextInt(gridArray.length);
						timeout++;
						ClickL2(i, x, y);
						if (rand.nextInt(2) == 0
								&& !barcoArray[i].getStartingOffGridPosition().equals(panelArray[i].getLocation())) {
							ClickR1(i, x, y);
						}
					}
				}
			}
		});
		add(randomJony);
		randomJony.setVisible(true);
		repaint();

		// crea un botón que finaliza la configuración cuando se presiona
		endSetup = new JButton("Finish");
		endSetup.setBounds(buttonXPos, TILE_SIZE - 5, window.getWidth() - buttonXPos, window.getHeight());
		endSetup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setup = true;
			}
		});
		add(endSetup);
		// Establece la visibilidad del botón en falsa
		endSetup.setVisible(false);

		// recorre todos los barcos
		for (int j = 0; j < barcoArray.length; j++) {
			final int shipNum = j;

			// crea un panel con un diseño de caja del eje X para el barco
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setOpaque(false);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.add(Box.createRigidArea(new Dimension(0, 0)));

			// recorre las piezas del barco en el barco
			for (int i = 0; i < barcoArray[j].getShipPieces().length; i++) {
				// agrega etiquetas que contienen cada imagen al panel
				ImageIcon icon = new ImageIcon(barcoArray[j].getShipPieces()[i].getImagen());
				JLabel label = new JLabel(icon);
				panel.add(label);
				panel.add(Box.createRigidArea(new Dimension(BORDER_SIZE + 2, 0)));
				// coloca el panel a un lado de la cuadrícula
                               // panel.setLocation (650, 50 + (j * 50));

			}
			panel.setLocation(X + ((TILE_SIZE + BORDER_SIZE) * gridArray.length) + (2 * BORDER_SIZE) + 50,
					TILE_SIZE + BORDER_SIZE + 2 + (j * (TILE_SIZE + BORDER_SIZE + 2)));
			panel.setSize(barcoArray[j].getShipPieces().length * (TILE_SIZE + BORDER_SIZE), TILE_SIZE);
			barcoArray[shipNum].setStartingOffGridPosition(panel.getLocation());
			add(panel);
			panelArray[j] = panel;
			setComponentZOrder(panel, 0);

			panel.addMouseMotionListener(new MouseMotionAdapter() {

				@Override
				public void mouseDragged(MouseEvent e) {
					// cuando el botón izquierdo del mouse está presionado, el panel se mueve a
                                        // la ubicación del mouse
					if (SwingUtilities.isLeftMouseButton(e)) {
						JPanel component = (JPanel) e.getComponent().getParent().getParent();
						Point pt = new Point(SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), component));
						panel.setLocation((int) pt.getX() - (TILE_SIZE / 2), (int) pt.getY() - (TILE_SIZE / 2));
						currentlyPlacingShip = true;
					}
				}

			});
			// agrega un listener de mouse al panel
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					// obtiene las coordenadas del mouse en términos de la ventana
					JPanel component = (JPanel) e.getComponent().getParent().getParent();
					Point pt = new Point(SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), component));
					int counter1 = 0;
					int counter2 = 0;

					// calcula la posición en la matriz de la cuadrícula basándose en el
                                       // coordenadas del mouse
					int value = (int) pt.getX();

					while (X + ((TILE_SIZE + BORDER_SIZE) * counter1) < value) {
						counter1++;
					}
					counter1--;

					int value2 = (int) (pt.getY());
					while (Y + ((TILE_SIZE + BORDER_SIZE) * counter2) < value2) {
						counter2++;
					}
					counter2--;

					// si se suelta el botón izquierdo
					if (e.getButton() == MouseEvent.BUTTON1) {
						// llama al método de clic izquierdo
						currentlyPlacingShip = false;
						ClickL2(shipNum, counter1, counter2);
						// si se suelta el botón derecho
					} else if (e.getButton() == MouseEvent.BUTTON3) {
						ClickR1(shipNum, counter1, counter2);
					}

					endSetup.repaint();

				}

			});
		}
	}

	/*
	 * Se llama cuando se presiona el botón derecho del ratón en un panel de envío. Intenta
         * girar el panel
	 */
	private void ClickR1(int shipNum, int x, int y) {
		// isVertical se establece en función del diseño del panel (eje X o Y)
		boolean isVertical = false;
		if (((BoxLayout) panelArray[shipNum].getLayout()).getAxis() == BoxLayout.Y_AXIS) {
			isVertical = true;
		}
		// llama al método de eliminación para eliminar la nave (no el panel)
		removeShipFromGridArray(barcoArray[shipNum], isVertical);
		// intenta girar el panel.
		if (rotatePanel(panelArray[shipNum]) && !currentlyPlacingShip) {
			// si funciona, llame al método add para agregar las piezas del barco en el
                       // nueva orientación
			addShipToGridArray(barcoArray[shipNum], new Point(x, y), !isVertical);
		} else if (!currentlyPlacingShip) {
			panelArray[shipNum].setLocation(barcoArray[shipNum].getStartingOffGridPosition());
			rotatePanel(panelArray[shipNum]);
		}

		showFinishButton();
	}

	/*
	 * Se llama cuando se presiona el botón izquierdo del mouse en un panel de envío
	 */
	private void ClickL2(int shipNum, int x, int y) {
		// si el panel tiene un diseño de caja X AXIS
		if ((((BoxLayout) panelArray[shipNum].getLayout()).getAxis() == BoxLayout.X_AXIS)) {
			// comprueba si el panel está en la cuadrícula
			if (x < gridArray.length - panelArray[shipNum].getWidth() / TILE_SIZE + 1 && x >= 0) {
				if (y < gridArray[0].length - panelArray[shipNum].getHeight() / TILE_SIZE + 1 && y >= 0) {
					// llama al método para colocar un panel de barco en el lugar adecuado
                                       // colocar en la imagen de la cuadrícula
					placeShipPanelOnGrid(x, y, shipNum, false);
				} else {
					// devuelve la ubicación a su posición inicial
					panelArray[shipNum].setLocation(barcoArray[shipNum].getStartingOffGridPosition());
					// quita el panel de la matriz
					removeShipFromGridArray(barcoArray[shipNum], false);
				}
			} else {
				// devuelve la ubicación a la posición inicial
				panelArray[shipNum].setLocation(barcoArray[shipNum].getStartingOffGridPosition());
				// quita el panel de la matriz
				removeShipFromGridArray(barcoArray[shipNum], false);
			}
		} else {
			// comprueba si el panel está en la cuadrícula
			if (x < gridArray.length - panelArray[shipNum].getWidth() / TILE_SIZE + 1 && x >= 0) {
				if (y < gridArray[0].length - panelArray[shipNum].getHeight() / TILE_SIZE + 1 && y >= 0) {
					// llama al método para colocar un panel de barco en el lugar adecuado
// colocar en la imagen de la cuadrícula
					placeShipPanelOnGrid(x, y, shipNum, true);
				} else {
					// gira el panel para que quede a lo largo del eje x
					rotatePanel(panelArray[shipNum]);
					// devuelve la ubicación a la posición inicial
					panelArray[shipNum].setLocation(barcoArray[shipNum].getStartingOffGridPosition());
					// quita el panel de la matriz
					removeShipFromGridArray(barcoArray[shipNum], true);
				}
			} else {
				// gira el panel para que quede a lo largo del eje x
				rotatePanel(panelArray[shipNum]);
				// devuelve la ubicación a la posición inicial
				panelArray[shipNum].setLocation(barcoArray[shipNum].getStartingOffGridPosition());
				// quita el panel de la matriz
				removeShipFromGridArray(barcoArray[shipNum], true);
			}
		}

		showFinishButton();
	}

	/*
	 * Método para colocar un panel de barco en la imagen de la cuadrícula
	 */
	private void placeShipPanelOnGrid(int x, int y, int shipNum, boolean isVertical) {
		// establece la ubicación
		panelArray[shipNum].setLocation(X + x + (((TILE_SIZE + BORDER_SIZE) * x) + BORDER_SIZE / 2),
				Y + y + ((TILE_SIZE + BORDER_SIZE) * y) + BORDER_SIZE / 2);
		// comprueba si hay una intersección con otro panel
		if (isIntersection(panelArray[shipNum])) {
			// si es vertical
			if (isVertical) {
				//rotar el panel del barco
				rotatePanel(panelArray[shipNum]);
			}
			// quitar la nave de la matriz de la cuadrícula
			removeShipFromGridArray(barcoArray[shipNum], false);
			// establece la ubicación del panel en su ubicación original
			panelArray[shipNum].setLocation(barcoArray[shipNum].getStartingOffGridPosition());

			// si no hay intersección
		} else {
			removeShipFromGridArray(barcoArray[shipNum], isVertical);
			addShipToGridArray(barcoArray[shipNum], new Point(x, y), isVertical);

		}
	}

	/*
	 * Comprueba si se debe agregar el botón Mostrar finalización y si se debe agregar
         * eso
	 */
	private void showFinishButton() {
		boolean showButton = true;
		if (!currentlyPlacingShip) {
			for (int i = 0; i < barcoArray.length; i++) {
				if (barcoArray[i].getStartingOffGridPosition().equals(panelArray[i].getLocation())) {
					showButton = false;
				}
			}
			endSetup.setVisible(showButton);
		}
	}

	/*
	 * Comprueba si un panel se cruza con otro panel.
	 */
	private boolean isIntersection(JPanel p) {
		// recorre la matriz de paneles
		for (int i = 0; i < panelArray.length; i++) {
			// comprueba si p se cruza con un panel en la matriz que no sea
                       // sí mismo
			if (p.getBounds().intersects(panelArray[i].getBounds()) && !p.equals(panelArray[i])) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Elimina los barcos de la matriz de la cuadrícula
	 */
	private void removeShipFromGridArray(Barco ship, boolean isVertical) {
		// recorre la matriz de la cuadrícula
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray[i].length; j++) {
				for (int k = 0; k < ship.getShipPieces().length; k++) {
					if (gridArray[j][i] == (BarcoP) ship.getShipPieces()[k]) {
						gridArray[j][i] = 1;
					}
				}
			}
		}
	}

	/*
	 * Añade un barco a la cuadricula 
	 */
	private void addShipToGridArray(Barco ship, Point location, boolean isVertical) {

		// si la ubicación es un punto válido en la matriz
		if (location.getX() < gridArray.length && location.getX() >= 0 && location.getY() < gridArray.length
				&& location.getY() >= 0) {
			// bucle a través de las piezas del barco en el barco
			for (int i = 0; i < ship.getShipPieces().length; i++) {
				// si el barco es vertical
				if (isVertical) {
					// agrega una pieza de barco en el punto pero con i agregada a la y
                                       // coordinar
					gridArray[(int) location.getX()][(int) location.getY() + i] = ship.getShipPieces()[i];
				} else {
					// agrega una pieza de barco en el punto pero con i agregado a la x
                                       // coordinar
					gridArray[(int) location.getX() + i][(int) location.getY()] = ship.getShipPieces()[i];
				}
			}
		}
	}

	/*
	 * Gira un panel de barco
	 */
	private boolean rotatePanel(JPanel panel) {
		// si el panel tiene un diseño de caja del eje x
		if (((BoxLayout) panel.getLayout()).getAxis() == BoxLayout.X_AXIS) {
			if (panel.getX() > X + ((TILE_SIZE + BORDER_SIZE) * gridArray.length) && !currentlyPlacingShip) {
				return false;
			}
			// establecer el diseño en el eje y
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			// intercambiar el ancho y el alto
			int temp = panel.getWidth();
			int temp2 = panel.getHeight();
			panel.setSize(temp2, temp);
			// reemplaza todo el relleno del eje x con el relleno del eje y entre el barco
                       // imágenes de piezas
			for (int i = 0; i < panel.getComponentCount(); i++) {
				if (!panel.getComponent(i).getClass().toString().equals("JPanel")) {
					panel.add(Box.createRigidArea(new Dimension(0, BORDER_SIZE + 2)), i);
					panel.remove(++i);
				}
			}
			panel.add(Box.createRigidArea(new Dimension(0, 0)), 0);
			panel.remove(1);
			// revalida el panel, lo que obliga a actualizar el diseño
			panel.validate();

			// establece la ubicación del panel
			panel.setLocation(panel.getX(), panel.getY());

			// obtiene la longitud del barco
			int counter = 0;
			while (Y + ((TILE_SIZE + BORDER_SIZE) * counter) < panel.getY() + panel.getWidth()) {
				counter++;
			}
			counter--;

			// si el panel se cruza con otro panel de barco o está parcialmente
                       // fuera de la red
			if (!(counter <= gridArray[0].length - panel.getHeight() / TILE_SIZE && counter >= 0)
					|| isIntersection(panel)) {
				// volver que la rotacion fue un fracaso
				return false;
			}
			// si el panel tiene un diseño de caja del eje y
		} else if (((BoxLayout) panel.getLayout()).getAxis() == BoxLayout.Y_AXIS) {
			// establecer el diseño en el eje y
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			// intercambiar el ancho y el alto
			int temp = panel.getWidth();
			int temp2 = panel.getHeight();
			panel.setSize(temp2, temp);
			// reemplaza todo el relleno del eje y con el relleno del eje x entre el barco
                       // imágenes de piezas
			for (int i = 0; i < panel.getComponentCount(); i++) {
				if (!panel.getComponent(i).getClass().toString().equals("JPanel")) {
					panel.add(Box.createRigidArea(new Dimension(BORDER_SIZE + 2, 0)), i);
					panel.remove(++i);
				}
			}
			panel.add(Box.createRigidArea(new Dimension(0, 0)), 0);
			panel.remove(1);
			// revalida el panel, lo que obliga a actualizar el diseño
			panel.validate();

			// establece la ubicación del panel
			panel.setLocation(panel.getX(), panel.getY());

			// obtiene la longitud del barco
			int counter = 0;
			while (X + ((TILE_SIZE + BORDER_SIZE) * counter) < panel.getX() + panel.getHeight()) {
				counter++;
			}
			counter--;

			// si el panel se cruza con otro panel de barco o está parcialmente
                        // fuera de la red
			if (!(counter <= gridArray.length - panel.getWidth() / TILE_SIZE && counter >= 0)
					|| isIntersection(panel)) {
				// establece la ubicación en la ubicación inicial
                                // panel.setLocation (shipArray [shipNum] .getStartingOffGridPosition ());
                                // devuelve que la rotación fue un fracaso
				return false;
			}

		}
		// volver que la rotacion fue un exito
		return true;
	}

	/*
	 * Devuelve la matriz de cuadrícula
	 */
	public Object[][] getGridArray() {
		return gridArray;
	}

	/*
	 * Devuelve si la configuración ha terminado
	 */
	public boolean isSetupOver() {
		return setup;
	}

	public JButton getButton() {
		return endSetup;
	}

}
