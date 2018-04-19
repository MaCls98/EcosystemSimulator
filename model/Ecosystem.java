package model;

import java.util.Random;

import linkedList.MyLinkedList;
import linkedList.MyQueue;
import linkedList.MyStack;
import linkedList.Node;

public class Ecosystem {
	
	private MyLinkedList<Person> personList;
	private MyLinkedList<Animal> animalList;
	private MyQueue<Person> personQueue;
	private MyQueue<Animal> animalQueue;
	private MyStack<Person> personStack;
	private MyStack<Animal> animalStack;
	private EcosystemType ecosystemType;
	private int vegetationLevel;
	private int damageVegetation;
	private int waterLevel;
	private int contaminedWater;
	private int landExploitation;
	private Random random;
	
	public Ecosystem() {
		random = new Random();
		personList = new MyLinkedList<Person>();
		animalList = new MyLinkedList<Animal>();
	}
	
	public void addPersonToList(int quantity){
		for (int i = 0; i < quantity; i++) {
			Person person = new Person(i, "Person: " + i, true, random.nextInt(80), Gender.values()[random.nextInt(1)]);
			personList.append(new Node<Person>(person));
		}
	}
	
	public void addAnimalToList(int quantity){
		for (int i = 0; i < quantity; i++) {
			Animal animal = new Animal(i, "Animal: " + i, true, random.nextInt(35), AnimalType.values()[random.nextInt(5)]);
			animalList.append(new Node<Animal>(animal));
		}
		
	}
	
}