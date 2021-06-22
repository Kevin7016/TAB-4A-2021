package Practica4.Interfaz;

import Practica4.ControlComunicacion.PanelJugador1;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrincipalP implements MouseListener {

	private JPanel window;
	private JLabel bkgImageContainer;
	private volatile boolean isImageVisible;
	private  PanelJugador1 grid;
	
	
	

	public boolean isImageVisible(){
		return isImageVisible;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		window.remove(bkgImageContainer);
		window.revalidate();
		window.repaint();
		grid.setTurn(true);
		grid.setVisible(true);
		//small.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}
	
}

