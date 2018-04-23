package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;
import controller.Events;

public class JDialogSetUp extends JDialog{

	private static final long serialVersionUID = 1L;
	private JButton btnRunSimulation;
	private JSlider jsPerson;
	private JSlider jsAnimal;
	private JSlider jsVegetation;
	private JSlider jsWater;
	private ImageIcon run = new ImageIcon(getClass().getResource("/img/run.png"));
	
	public JDialogSetUp(Controller controller) {
		setTitle("SetUp");
		setLayout(new GridLayout(5, 1));
		setSize(500, 500);
		setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
		setBackground(Color.white);
		
		jsPerson = new JSlider();
		jsPerson.setBackground(Color.white);
		jsPerson.setMaximum(30);
		jsPerson.setBorder(BorderFactory.createTitledBorder("Cantidad de personas " + jsPerson.getValue()));
		jsPerson.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int currentTime = ((JSlider)e.getSource()).getValue();
				jsPerson.setBorder(BorderFactory.createTitledBorder("Cantidad de personas " + currentTime));
			}
		});
		add(jsPerson);
		
		jsAnimal = new JSlider();
		jsAnimal.setBackground(Color.white);
		jsAnimal.setMaximum(30);
		jsAnimal.setBorder(BorderFactory.createTitledBorder("Cantidad de animales " + jsAnimal.getValue()));
		jsAnimal.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int currentTime = ((JSlider)e.getSource()).getValue();
				jsAnimal.setBorder(BorderFactory.createTitledBorder("Cantidad de animales " + currentTime));
			}
		});
		add(jsAnimal);
		
		jsVegetation = new JSlider();
		jsVegetation.setBackground(Color.white);
		jsVegetation.setMaximum(100);
		jsVegetation.setBorder(BorderFactory.createTitledBorder("Cantidad de vegetacion " + jsVegetation.getValue()));
		jsVegetation.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int currentTime = ((JSlider)e.getSource()).getValue();
				jsVegetation.setBorder(BorderFactory.createTitledBorder("Cantidad de vegetacion " + currentTime));
			}
		});
		add(jsVegetation);
		
		jsWater = new JSlider();
		jsWater.setBackground(Color.white);
		jsWater.setMaximum(100);
		jsWater.setBorder(BorderFactory.createTitledBorder("Porcentaje de agua " + jsWater.getValue()));
		jsWater.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int currentTime = ((JSlider)e.getSource()).getValue();
				jsWater.setBorder(BorderFactory.createTitledBorder("Porcentaje de agua " + currentTime));
			}
		});
		add(jsWater);
		
		btnRunSimulation = new JButton("Iniciar Simulador");
		btnRunSimulation.setIcon(run);
		btnRunSimulation.setHorizontalAlignment(JLabel.CENTER);
		btnRunSimulation.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));
		btnRunSimulation.setBackground(Color.WHITE);
		btnRunSimulation.setBorder(null);
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
