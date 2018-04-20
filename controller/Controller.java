package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Ecosystem;
import views.MainWindow;

public class Controller implements ActionListener{
	
	private Ecosystem ecosystem;
	private MainWindow mainWindow;
	
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
		ecosystem.addPersonToQueue(mainWindow.getPerson());
		ecosystem.addAnimalToQueue(mainWindow.getAnimal());
		ecosystem.addPersonToStack(mainWindow.getPerson());
		ecosystem.addAnimalToStack(mainWindow.getAnimal());
		mainWindow.hideSetUp();
		mainWindow.showBg(ecosystem);
		mainWindow.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
