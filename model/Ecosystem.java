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
	
	public Ecosystem(int personQuantity, int animalQuantity, int vegetationLevel, int waterLevel) {
		random = new Random();
		personList = new MyLinkedList<Person>();
		animalList = new MyLinkedList<Animal>();
		personQueue = new MyQueue<Person>();
		animalQueue = new MyQueue<Animal>();
		personStack = new MyStack<Person>();
		animalStack = new MyStack<Animal>();
		this.ecosystemType = EcosystemType.values()[random.nextInt(3)];
		this.vegetationLevel = vegetationLevel;
		this.waterLevel = waterLevel;
		addPersonToList(personQuantity);
		addAnimalToList(animalQuantity);
	}

	

	public MyLinkedList<Person> getPersonList() {
		return personList;
	}

	public MyLinkedList<Animal> getAnimalList() {
		return animalList;
	}

	public EcosystemType getEcosystemType() {
		return ecosystemType;
	}

	public int getVegetationLevel() {
		return vegetationLevel;
	}

	public int getDamageVegetation() {
		return damageVegetation;
	}

	public int getWaterLevel() {
		return waterLevel;
	}

	public int getContaminedWater() {
		return contaminedWater;
	}

	public int getLandExploitation() {
		return landExploitation;
	}
	
	public void addPersonToList(int quantity){
		for (int i = 0; i < quantity; i++) {
			personList.append(new Node<Person>(new Person(i, "Person: " + i, true, random.nextInt(80), random.nextInt(100), random.nextInt(100), Gender.values()[random.nextInt(2)])));
		}
	}
	
	public void addAnimalToList(int quantity){
		for (int i = 0; i < quantity; i++) {
			Animal animal = new Animal(i, "Animal: " + i, true, random.nextInt(35), random.nextInt(100), random.nextInt(100), AnimalType.values()[random.nextInt(5)]);
			animalList.append(new Node<Animal>(animal));
		}
	}
	
	public void addPersonToQueue(int quantity){
		for (int i = 0; i < quantity; i++) {
			personQueue.enqueue(new Node<Person>(new Person(i, "Person: " + i, true, random.nextInt(80), random.nextInt(100), random.nextInt(100), Gender.values()[random.nextInt(2)])));
		}
	}
	
	public void addAnimalToQueue(int quantity){
		for (int i = 0; i < quantity; i++) {
			animalQueue.enqueue(new Node<Animal>(new Animal(i, "Animal: " + i, true, random.nextInt(35), random.nextInt(100), random.nextInt(100), AnimalType.values()[random.nextInt(5)])));
		}
	}
	
	public void addPersonToStack(int quantity){
		for (int i = 0; i < quantity; i++) {
			personStack.push(new Node<Person>(new Person(i, "Person: " + i, true, random.nextInt(80), random.nextInt(100), random.nextInt(100), Gender.values()[random.nextInt(2)])));
		}
		personStack.print();
	}
	
	public void addAnimalToStack(int quantity){
		for (int i = 0; i < quantity; i++) {
			animalStack.push(new Node<Animal>(new Animal(i, "Animal: " + i, true, random.nextInt(35), random.nextInt(100), random.nextInt(100), AnimalType.values()[random.nextInt(5)])));
		}
		animalStack.print();
	}

	@Override
	public String toString() {
		return "Ecosystem [ecosystemType=" + ecosystemType + ", vegetationLevel=" + vegetationLevel + ", waterLevel="
				+ waterLevel + "]";
	}
}