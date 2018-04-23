package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Ecosystem;
import views.MainWindow;

public class Controller implements ActionListener{
	
	private Ecosystem ecosystem;
	private MainWindow mainWindow;
	private javax.swing.Timer timer;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		mainWindow.showSetUp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case RUN_SIMULATION:
			runSimulation();
			break;

		default:
			break;
		}
	}

	private void runSimulation() {
		ecosystem = new Ecosystem(mainWindow.getPerson(), mainWindow.getAnimal(), mainWindow.getVegetation(), mainWindow.getWater());
		timer = new javax.swing.Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ecosystem.calculateTotalDamage();
				} catch (Exception e) {
					ecosystem.refillPerson(mainWindow.getPerson());
					ecosystem.refillAnimal(mainWindow.getAnimal());
				}
				ecosystem.checkEcoHabitable();
				ecosystem.checkIsAlive();
				stopSimulation();
				mainWindow.setVisible(true);
				mainWindow.hideSetUp();
				mainWindow.showBg(ecosystem);
			}
		});
		timer.start();
	}
	
	private void stopSimulation(){
		if (ecosystem.isHabitable() == false || ecosystem.isPerson() == false) {
			mainWindow.showMessage();
			timer.stop();
			mainWindow.refreshTables(ecosystem);
		}
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
