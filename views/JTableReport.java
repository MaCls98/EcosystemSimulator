package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import controller.Events;
import linkedList.Node;
import model.Animal;
import model.Ecosystem;
import model.Person;

public class JTableReport extends JDialog{

	private static final long serialVersionUID = 1L;
	private JTable tableAnimal;
	private JTable tablePerson;
	private DefaultTableModel defaultTableModelP;
	private DefaultTableModel defaultTableModelA;
	private JLabel lblPerson, lblAnimal, lblEcosystemType, lblVegetation, lblWater;
	private JButton btnRestart;
	private ImageIcon snow = new ImageIcon(getClass().getResource("/img/snow.png"));
	private ImageIcon forest = new ImageIcon(getClass().getResource("/img/forest.png"));
	private ImageIcon mountain = new ImageIcon(getClass().getResource("/img/mountain.png"));
	private GridBagConstraints c;
	private Controller controller;
	
	public JTableReport(Controller controller) {
		setTitle("Reporte del simulador");
		setSize(800, 710);
		setLayout(new GridBagLayout());
		setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
		loadAnimalTable();
		loadPersonTable();
		
		this.controller = controller;
		
		setBackground(Color.white);
		
		c = new GridBagConstraints();
		c.insets = new Insets(2, 10, 10, 10);
	}
	
	public void showInfo(Ecosystem ecosystem){
		c.fill = GridBagConstraints.BOTH;
		
		c.weightx = 1;
		c.gridheight = 1;
		
		for (int i = 0; i < 2; i++) {
			c.gridx = i;
			add(new JLabel(""), c);
		}
		
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 2;
		c.weighty = 0.1;
		lblEcosystemType = new JLabel();
		lblEcosystemType.setHorizontalAlignment(JLabel.CENTER);
		validateEcosystem(ecosystem);
		lblEcosystemType.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		add(lblEcosystemType, c);
		
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 1;
		c.weighty = 0.1;
		lblPerson = new JLabel();
		lblPerson.setText("Total de Personas: " + ecosystem.getPersonList().size());
		lblPerson.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		add(lblPerson, c);
		
		c.gridy = 2;
		c.gridx = 1;
		c.gridwidth = 1;
		c.weighty = 0.1;
		lblAnimal = new JLabel();
		lblAnimal.setText("Total de Animales: " + ecosystem.getAnimalList().size());
		lblAnimal.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		add(lblAnimal, c);
		
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 1;
		c.weighty = 0.1;
		lblWater = new JLabel();
		lblWater.setText("Cantidad restante de agua: " + ecosystem.getWaterLevel());
		lblWater.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		add(lblWater, c);
		
		c.gridy = 3;
		c.gridx = 1;
		c.gridwidth = 1;
		c.weighty = 0.1;
		lblVegetation = new JLabel();
		lblVegetation.setText("Cantidad restante de vegetacion: " + ecosystem.getVegetationLevel());
		lblVegetation.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		add(lblVegetation, c);
		
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 1;
		c.weighty = 0.6;
		JScrollPane paneP = new JScrollPane(tablePerson);
		add(paneP, c);
		
		c.gridy = 4;
		c.gridx = 1;
		c.gridwidth = 1;
		c.weighty = 0.6;
		JScrollPane paneA = new JScrollPane(tableAnimal);
		add(paneA, c);
		
		c.gridy = 5;
		c.gridx = 0;
		c.gridwidth = 2;
		c.weighty = 0.1;
		btnRestart = new JButton("Reiniciar el simulador");
		btnRestart.addActionListener(controller);
		btnRestart.setActionCommand(Events.RESTART.toString());
		btnRestart.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		btnRestart.setBorder(null);
		btnRestart.setBackground(Color.WHITE);
		add(btnRestart, c);
	}

	public void validateEcosystem(Ecosystem ecosystem) {
		switch (ecosystem.getEcosystemType()) {
		case FOREST:
			lblEcosystemType.setIcon(forest);
			lblEcosystemType.setText("Bosque");
			break;
		case MOUNTAIN:
			lblEcosystemType.setIcon(mountain);
			lblEcosystemType.setText("Montaña");
			break;
		case SNOWY:
			lblEcosystemType.setIcon(snow);
			lblEcosystemType.setText("Nevado");
			break;

		default:
			break;
		}
	}
	
	public void loadAnimalTable(){
		defaultTableModelA = new DefaultTableModel();
		defaultTableModelA.setRowCount(0);
		defaultTableModelA.setColumnIdentifiers(new Object[]{"Animal", "Edad", "Estado final","Impacto al ambiente"});
		tableAnimal = new JTable(defaultTableModelA);
	}
	
	public void refreshAnimalTable(Ecosystem ecosystem){
		for (int i = 0; i < ecosystem.getAnimalList().size(); i++) {
			Node<Animal> aux = ecosystem.getAnimalList().get(i);
			defaultTableModelA.addRow(aux.getInfo().toArrayAnimal());
		}
	}
	
	public void loadPersonTable(){
		defaultTableModelP = new DefaultTableModel();
		defaultTableModelP.setRowCount(0);
		defaultTableModelP.setColumnIdentifiers(new Object[]{"Persona", "Edad", "Estado final","Impacto al ambiente"});
		tablePerson = new JTable(defaultTableModelP);
	}
	
	public void refreshPersonTable(Ecosystem ecosystem){
		for (int i = 0; i < ecosystem.getPersonList().size(); i++) {
			Node<Person> aux = ecosystem.getPersonList().get(i);
			defaultTableModelP.addRow(aux.getInfo().toArrayPerson());
		}
	}
}
