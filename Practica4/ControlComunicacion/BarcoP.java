package Practica4.ControlComunicacion;

import java.awt.*;
import javax.swing.ImageIcon;

public class BarcoP {
	private Image barcovivo;
	private boolean pomuch;
	boolean jugador1;

	/*
	 *Constructor que tiene un booleano para determinar qué jugador es la pieza del barco.
* pertenece a. falso es el jugador 2, verdadero es el jugador 1
	 */
	public BarcoP(boolean jugador1) {
		this.jugador1 = jugador1;
		// establece la imagen según el jugador al que pertenece también
		if (jugador1)
			barcovivo = new ImageIcon("Player1.png").getImage();
		else
			barcovivo = new ImageIcon("Player2.png").getImage();
		pomuch = false;
	}

	/*
	 * establece la imagen según el nombre del archivo
	 */
	public void setImagen(String file) {
		barcovivo = new ImageIcon(file).getImage();

	}

	/*
	 * devuelve la imagen de la pieza del barco
	 */
	public Image getImagen() {
		return barcovivo;
	}

	/*
	 * Destruye la pieza del barco estableciendo shipIsDead en verdadero y cambiando el
*
	 */
	public void destruir() {
		pomuch = true;
		if (jugador1) {
			setImagen("Player1Hit.png");
		} else {
			setImagen("Player2Hit.png");
		}
	}

	/*
	 * Retorna la pieza destruida
	 */
	public boolean Destruido() {
		return pomuch;
	}

}
