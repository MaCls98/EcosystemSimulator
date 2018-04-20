package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.Controller;
import model.Ecosystem;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDialogSetUp dialogSetUp;
	private LandScreen landScreen;
	
	public MainWindow(Controller controller) {
		setTitle("Ecosystem Simulator");
		setLayout(new BorderLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dialogSetUp = new JDialogSetUp(controller);
	}
	
	public void showSetUp(){
		dialogSetUp.setVisible(true);
	}
	
	public void hideSetUp(){
		dialogSetUp.setVisible(false);
	}
	
	public void showBg(Ecosystem ecosystem){
		landScreen = new LandScreen();
		landScreen.setEcosystem(ecosystem);
		add(landScreen, BorderLayout.CENTER);
	}
	
	public int getPerson(){
		return dialogSetUp.getPerson();
	}
	
	public int getAnimal(){
		return dialogSetUp.getAnimal();
	}
	
	public int getWater(){
		return dialogSetUp.getWater();
	}
	
	public int getVegetation(){
		return dialogSetUp.getVegetation();
	}
}
