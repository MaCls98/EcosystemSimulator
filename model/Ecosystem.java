package model;

import java.util.Random;

import linkedList.MyLinkedList;
import linkedList.MyQueue;
import linkedList.MyStack;
import linkedList.Node;

public class Ecosystem {
	
	private MyLinkedList<Person> personList;
	private MyLinkedList<Animal> animalList;
	private MyQueue<Animal> animalQueue;
	private MyStack<Person> personStack;
	private EcosystemType ecosystemType;
	private int vegetationLevel;
	private int damageVegetation;
	private int waterLevel;
	private int contaminedWater;
	private int landExploitation = 0;
	private boolean isHabitable = true;
	private boolean isPerson = true;
	private Random random;
	
	public Ecosystem(int personQuantity, int animalQuantity, int vegetationLevel, int waterLevel) {
		random = new Random();
		personList = new MyLinkedList<Person>();
		animalList = new MyLinkedList<Animal>();
		animalQueue = new MyQueue<Animal>();
		personStack = new MyStack<Person>();
		this.ecosystemType = EcosystemType.values()[random.nextInt(3)];
		this.vegetationLevel = vegetationLevel;
		this.waterLevel = waterLevel;
		addPersonToList(personQuantity);
		addAnimalToList(animalQuantity);
	}
	
	public void checkEcoHabitable(){
		if (waterLevel < 0 || vegetationLevel < 0 || landExploitation > 100) {
			isHabitable = false;
		}
	}
	
	public void checkIsAlive(){
		if (waterLevel < 20 || vegetationLevel < 20) {
			personList.get(random.nextInt(personList.size())).getInfo().setAlive(false);
			animalList.get(random.nextInt(animalList.size())).getInfo().setAlive(false);
		}
		deadCounter();
	}
	
	public void deadCounter(){
		int deadCount = 0;
		Node<Person> aux = personList.getHead();
		while (aux != null) {
			if (!aux.getInfo().isAlive()) {
				deadCount = deadCount + 1;
				if (deadCount == personList.size()) {
					isPerson = false;
				}
			}
			aux = aux.getNextNode();
		}
	}

	public int calculatePersonDamage(){
		Node<Person> personNS = personStack.pop();
		int personDamage = personNS.getInfo().getAmbientalAffectation();
		return personDamage;
	}
	
	public int calculateAnimalDamage(){
		Node<Animal> animalNQ = animalQueue.dequeue();
		int animalDamage = animalNQ.getInfo().getAmbientalAffectation();
		return animalDamage;
	}
	
	public int calculateVegetationDamage(){
		int personDamage = (int) (calculatePersonDamage() * 0.1);
		int animalDamage = (int) (calculateAnimalDamage() * 0.1);
		vegetationLevel = vegetationLevel - personDamage + animalDamage -5;
		return vegetationLevel;
	}
	
	public int calculateContaminedWater(){
		int personDamage = (int) (calculatePersonDamage() * 0.1);
		int animalDamage = (int) (calculateAnimalDamage() * 0.1);
		contaminedWater = personDamage + animalDamage;
		waterLevel = waterLevel - contaminedWater;
		return waterLevel;
	}
	
	public int calculateTotalDamage(){
		return landExploitation = (int) ((landExploitation + calculateContaminedWater() + calculateVegetationDamage()) * 0.1);
	}
	
	public void addPersonToList(int quantity){
		for (int i = 0; i < quantity; i++) {
			Person person = new Person(i, "Person: " + i, true, random.nextInt(80), random.nextInt(60), random.nextInt(60), Gender.values()[random.nextInt(2)], random.nextInt(1024), random.nextInt(600));
			personList.append(new Node<Person>(person));
			personStack.push(new Node<Person>(person));
		}
	}
	
	public void addAnimalToList(int quantity){
		for (int i = 0; i < quantity; i++) {
			Animal animal = new Animal(i, "Animal: " + i, true, random.nextInt(35), AnimalType.values()[random.nextInt(5)], random.nextInt(1024), random.nextInt(600));
			animalList.append(new Node<Animal>(animal));
			animalQueue.enqueue(new Node<Animal>(animal));
		}
	}
	
	public void refillPerson(int quantity){
		for (int i = 0; i < quantity; i++) {
			Person person = new Person(i, "Person: " + i, true, random.nextInt(80), random.nextInt(60), random.nextInt(60), Gender.values()[random.nextInt(2)], random.nextInt(1024), random.nextInt(600));
			personStack.push(new Node<Person>(person));
		}
	}
	
	public void refillAnimal(int quantity){
		for (int i = 0; i < quantity; i++) {
			Animal animal = new Animal(i, "Animal: " + i, true, random.nextInt(35), AnimalType.values()[random.nextInt(5)], random.nextInt(1024), random.nextInt(600));
			animalQueue.enqueue(new Node<Animal>(animal));
		}
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

	public boolean isHabitable() {
		return isHabitable;
	}

	public boolean isPerson() {
		return isPerson;
	}

	@Override
	public String toString() {
		return "Ecosystem [ecosystemType=" + ecosystemType + ", vegetationLevel=" + vegetationLevel + ", waterLevel="
				+ waterLevel + "]";
	}
}