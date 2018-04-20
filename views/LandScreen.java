package views;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.Ecosystem;

public class LandScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private Ecosystem ecosystem;
	
	public LandScreen() {
		// TODO Auto-generated constructor stub
	}
	
	public void setEcosystem(Ecosystem ecosystem){
		this.ecosystem = ecosystem;
		System.out.println(this.ecosystem.getEcosystemType());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		printBg(g);
		printInfo(g);
		
		repaint();
	}

	public void printInfo(Graphics g) {
		g.drawString("Cantidad de personas: " + ecosystem.getPersonList().size(), 30, 30);
		g.drawString("Cantidad de animales: " + ecosystem.getAnimalList().size(), 30, 60);
		g.drawString("Cantidad de agua: " + ecosystem.getWaterLevel(), 30, 90);
		g.drawString("Cantidad de vegetacion: " + ecosystem.getVegetationLevel(), 30, 120);
	}

	public void printBg(Graphics g) {
		switch (ecosystem.getEcosystemType()) {
		case FOREST:
			ImageIcon forestBG = new ImageIcon(getClass().getResource("/img/forestBG.jpg"));
			g.drawImage(forestBG.getImage(), 0, 0, getWidth(), getHeight(), null);;
		case MOUNTAIN:
			ImageIcon mountainBG = new ImageIcon(getClass().getResource("/img/mountainBG.jpg"));
			g.drawImage(mountainBG.getImage(), 0, 0, getWidth(), getHeight(), null);
			break;
		case SNOWY:
			ImageIcon snowyBG = new ImageIcon(getClass().getResource("/img/snowBG.jpg"));
			g.drawImage(snowyBG.getImage(), 0, 0, getWidth(), getHeight(), null);
			break;

		default:
			break;
		}
	}
}