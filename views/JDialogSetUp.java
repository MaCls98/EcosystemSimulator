package views;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSlider;

import controller.Controller;
import controller.Events;

public class JDialogSetUp extends JDialog{

	private static final long serialVersionUID = 1L;
	private JButton btnRunSimulation;
	private JSlider jsPerson;
	private JSlider jsAnimal;
	private JSlider jsVegetation;
	private JSlider jsWater;
	
	public JDialogSetUp(Controller controller) {
		setTitle("SetUp");
		setLayout(new GridLayout(5, 1, 5, 5));
		setSize(500, 500);
		
		jsPerson = new JSlider();
		jsPerson.setMaximum(30);
		jsPerson.setBorder(BorderFactory.createTitledBorder("Cantidad de personas"));
		add(jsPerson);
		
		jsAnimal = new JSlider();
		jsAnimal.setMaximum(30);
		jsAnimal.setBorder(BorderFactory.createTitledBorder("Cantidad de animales"));
		add(jsAnimal);
		
		jsVegetation = new JSlider();
		jsVegetation.setMaximum(100);
		jsVegetation.setBorder(BorderFactory.createTitledBorder("Cantidad de vegetacion"));
		add(jsVegetation);
		
		jsWater = new JSlider();
		jsWater.setMaximum(100);
		jsWater.setBorder(BorderFactory.createTitledBorder("Porcentaje de agua"));
		add(jsWater);
		
		btnRunSimulation = new JButton("Iniciar simulador");
		btnRunSimulation.addActionListener(controller);
		btnRunSimulation.setActionCommand(Events.RUN_SIMULATION.toString());
		add(btnRunSimulation);
	}
	
	public int getPerson(){
		return jsPerson.getValue();
	}
	
	public int getAnimal(){
		return jsAnimal.getValue();
	}
	
	public int getWater(){
		return jsWater.getValue();
	}
	
	public int getVegetation(){
		return jsVegetation.getValue();
	}
}
