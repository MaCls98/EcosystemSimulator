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
				ecosystem.calculateTotalDamage();
				mainWindow.hideSetUp();
				mainWindow.showBg(ecosystem);
				mainWindow.setVisible(true);
			}
		});
		timer.start();
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
