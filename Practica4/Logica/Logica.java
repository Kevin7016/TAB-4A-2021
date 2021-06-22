package Practica4.Logica;

import Practica4.ControlComunicacion.BarcoP;
import Practica4.ControlComunicacion.PanelJugador1;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Logica {
	
	public static int boardSize = 10;
	
	public static int tamaño  = 4;
	public static int cruiserSize = 3;
	public static int destroyerSize = 2;
	public static int submarineSize = 1;
	
	public static int battleshipCount = 1;
	public static int cruiserCount = 2;
	public static int destroyerCount = 3;
	public static int submarineCount = 4;
	private JFrame frame;
	
	public void setUpWindow() {
		frame = new JFrame();
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(900, 615));
		frame.setMinimumSize(new Dimension(900, 615));
		frame.setResizable(false);
		frame.pack();
				
		
		Barco[] p1Ships = CreaciondeBARCO(true);
		
		
		PanelJugador1 grid = new PanelJugador1(chooseShipPositions(p1Ships));
		//PanelJugador2 small = new PanelJugador2(chooseShipPositions(p2Ships));
		//small.setLocation(grid.getWidth()+10, grid.getY());
		
		//panel.setLayout(null);
		
		
	}
	
	private Barco[] CreaciondeBARCO(boolean isPlayerOne) {
		Barco[] battleships = piezas(tamaño , battleshipCount, isPlayerOne);
		Barco[] cruisers = piezas(cruiserSize, cruiserCount, isPlayerOne);
		Barco[] destroyers = piezas(destroyerSize, destroyerCount, isPlayerOne);
		Barco[] submarines = piezas(submarineSize, submarineCount, isPlayerOne);

		Barco[] ships = concatShipArray(battleships, cruisers);
		ships = concatShipArray(ships, destroyers);
		ships = concatShipArray(ships, submarines);

		return ships;
	}

	private Barco[] piezas(int shipSize, int numOfShips, boolean isPlayerOne) {
		Barco[] listOfShips = new Barco[numOfShips];
		for (int i = 0; i < numOfShips; i++) {
			BarcoP[] shipArray = new BarcoP[shipSize];
			for (int j = 0; j < shipSize; j++) {
				BarcoP p = new BarcoP(isPlayerOne);
				shipArray[j] = p;
			}
			listOfShips[i] = new Barco(shipArray);
		}

		return listOfShips;
	}

	private Barco[] concatShipArray(Barco[] a, Barco[] b) {
		int aLen = a.length;
		int bLen = b.length;
		Barco[] c = new Barco[aLen + bLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}
	
	private Object[][] chooseShipPositions(Barco[] ships){
		CreadorC creator = new CreadorC(ships, boardSize, frame);
		creator.setup();
		frame.getContentPane().add(creator);
		frame.getContentPane().repaint();
		frame.setVisible(true);
		while (!creator.isSetupOver()) {}
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		
		return creator.getGridArray();
	}
}

