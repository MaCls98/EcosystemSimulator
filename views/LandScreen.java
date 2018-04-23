package views;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import linkedList.Node;
import model.Ecosystem;
import model.Person;

public class LandScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private Ecosystem ecosystem;
	private ImageIcon forestBG = new ImageIcon(getClass().getResource("/img/forestBG.jpg"));
	private ImageIcon mountainBG = new ImageIcon(getClass().getResource("/img/mountainBG.jpg"));
	private ImageIcon snowyBG = new ImageIcon(getClass().getResource("/img/snowBG.jpg"));
	private ImageIcon workOne = new ImageIcon(getClass().getResource("/img/work.gif"));
	private ImageIcon workTwo = new ImageIcon(getClass().getResource("/img/work2.gif"));
	private ImageIcon workThree = new ImageIcon(getClass().getResource("/img/work3.gif"));
	private ImageIcon workFour = new ImageIcon(getClass().getResource("/img/work4.gif"));
	private ImageIcon frog = new ImageIcon(getClass().getResource("/img/frog.gif"));
	private ImageIcon bird = new ImageIcon(getClass().getResource("/img/birds.gif"));
	private ImageIcon bear = new ImageIcon(getClass().getResource("/img/bear.gif"));
	private ImageIcon fish = new ImageIcon(getClass().getResource("/img/fish.gif"));
	private ImageIcon snake = new ImageIcon(getClass().getResource("/img/snake.gif"));
	private ImageIcon dead = new ImageIcon(getClass().getResource("/img/dead.png"));
	private int x, y;
	
	public LandScreen() {
	}
	
	public void showMessage(){
		if (!ecosystem.isHabitable()) {
			JOptionPane.showMessageDialog(getParent(), "No quedan humanos en este ecosistema");
		}else if (!ecosystem.isPerson()) {
			JOptionPane.showMessageDialog(getParent(), "Este ecosistema no cuenta con los recursos suficientes para ser habiado");
		}
	}
	
	public void setEcosystem(Ecosystem ecosystem){
		this.ecosystem = ecosystem;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		printBg(g);
		printPerson(g);
		printAnimal(g);
		printDeadBody(g);
		printInfo(g);
		repaint();
	}
	
	public void printDeadBody(Graphics g){
		Node<Person> aux = ecosystem.getPersonList().getHead();
		while (aux != null) {
			if (!aux.getInfo().isAlive()) {
				g.drawImage(dead.getImage(), aux.getInfo().getX(), aux.getInfo().getY(), this);
			}
			aux = aux.getNextNode();
		}
	}
	
	
	public void printAnimal(Graphics g){
		g.drawImage(frog.getImage(), 200, 300, this);
		g.drawImage(fish.getImage(), 900, 600, this);
		g.drawImage(bear.getImage(), 400, 600, this);
		g.drawImage(snake.getImage(), 570, 400, this);
		printBirds(g);
	}
	
	public void printBirds(Graphics g){
		g.drawImage(bird.getImage(), x, y, this);
	}

	public void printPerson(Graphics g) {
		Node<Person> headAux = ecosystem.getPersonList().getHead();
		while (headAux != null) {
			int x = headAux.getInfo().getX();
			int y = headAux.getInfo().getY();
			validatePersonImage(g, headAux, x, y);
			headAux = headAux.getNextNode();
		}
	}

	public void validatePersonImage(Graphics g, Node<Person> headAux, int x, int y) {
		if (headAux.getInfo().getAmbientalAffectation() > 0) {
			g.drawImage(workFour.getImage(), x, y, this);
			g.drawImage(workThree.getImage(), x+150, y, this);
		}else if (headAux.getInfo().getAmbientalAffectation() < 0) {
			g.drawImage(workTwo.getImage(), x, y, this);
			g.drawImage(workOne.getImage(), x+150, y, this);
		}
			
	}

	public void printInfo(Graphics g) {
		g.drawString("Cantidad de personas: " + ecosystem.getPersonList().size(), 30, 30);
		g.drawString("Cantidad de animales: " + ecosystem.getAnimalList().size(), 30, 60);
		g.drawString("Cantidad de agua: " + ecosystem.getWaterLevel(), 30, 90);
		g.drawString("Cantidad de vegetacion: " + ecosystem.getVegetationLevel(), 30, 120);
		g.drawString("Cantidad de daño: " + ecosystem.getLandExploitation(), 30, 150);
	}

	public void printBg(Graphics g) {
		switch (ecosystem.getEcosystemType()) {
		case FOREST:
			g.drawImage(forestBG.getImage(), 0, 0, getWidth(), getHeight(), this);;
		case MOUNTAIN:
			g.drawImage(mountainBG.getImage(), 0, 0, getWidth(), getHeight(), this);
			break;
		case SNOWY:
			g.drawImage(snowyBG.getImage(), 0, 0, getWidth(), getHeight(), this);
			break;
		default:
			break;
		}
	}
}
