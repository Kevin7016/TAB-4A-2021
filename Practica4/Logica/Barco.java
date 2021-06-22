package Practica4.Logica;

import java.awt.Point;
import java.util.ArrayList;
import Practica4.ControlComunicacion.BarcoP;
public class Barco {

	private BarcoP[] piezas;
	private Point posicioninicial;

	/*
	 * Constructor. Establece piezas iguales al parámetro de lista
	 */
	Barco(BarcoP[] list) {
		piezas = list;
		posicioninicial = new Point(0,0);
	}
	
	Barco(ArrayList<BarcoP> list){
		piezas = list.toArray(new BarcoP[0]);
		posicioninicial = new Point(0,0);
	}


	/*
	 * Si todas las piezas del barco están muertas, devuelve que el barco está muerto.
	 */
	public boolean checkIfDead() {
		boolean isDead = true;
		for (int i = 0; i < piezas.length; i++) {
			if (!piezas[i].Destruido()) {
				isDead = false;
			}
		}
		return isDead;
	}

	/*
	 * devuelve el conjunto de piezas del barco
	 */
	public BarcoP[] getShipPieces() {
		return piezas;
	}
	
	public void setStartingOffGridPosition(Point sp){
		posicioninicial = sp;
	}
	
	public Point getStartingOffGridPosition(){
		return posicioninicial;
	}
}
