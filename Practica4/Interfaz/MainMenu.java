package Practica4.Interfaz;

import Practica4.Logica.Logica;


public class MainMenu {
	
	private volatile boolean isImageVisible;
	
	
	
	
	public boolean canShipsFitOnBoard(){
		int totalShipSize = (Logica.battleshipCount * Logica.tamaño) + 
				(Logica.cruiserCount * Logica.cruiserSize) +
				(Logica.destroyerCount * Logica.destroyerSize) + 
				(Logica.submarineCount * Logica.submarineSize);
		if (totalShipSize > Logica.boardSize*Logica.boardSize){
			return false;
		}
		if (Logica.tamaño  > Logica.boardSize){
			return false;
		}
		if (Logica.cruiserSize > Logica.boardSize){
			return false;
		}
		if (Logica.destroyerSize > Logica.boardSize){
			return false;
		}
		if (Logica.submarineSize > Logica.boardSize){
			return false;
		}
		return true;
	}
	
	

	public boolean isImageVisible(){
		return isImageVisible;
	}
	
}
