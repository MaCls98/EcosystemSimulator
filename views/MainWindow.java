package views;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;
import model.Ecosystem;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDialogSetUp dialogSetUp;
	private LandScreen landScreen;
	private JTableReport tableReport;
	
	public MainWindow(Controller controller) {
		setTitle("Ecosystem Simulator");
		setLayout(new BorderLayout());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
		
		dialogSetUp = new JDialogSetUp(controller);
		tableReport = new JTableReport(controller);
	}
	
	public void refreshTables(Ecosystem ecosystem){
		tableReport.refreshAnimalTable(ecosystem);
		tableReport.refreshPersonTable(ecosystem);
		tableReport.showInfo(ecosystem);
		tableReport.setVisible(true);
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
	
	public void showMessage(){
		landScreen.showMessage();
	}
	
	public void removeAll(){
		landScreen.removeAll();
		tableReport.removeAll();
		removeAll();
	}
}
