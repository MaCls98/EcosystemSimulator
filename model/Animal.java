package model;

public class Animal {
	
	private int idAnimal;
	private String animalName;
	private boolean isAlive;
	private int animalAge;
	private int ambientalAffectation;
	private AnimalType animalType;
	
	public Animal(int idAnimal, String animalName, boolean isAlive, int animalAge, AnimalType animalType) {
		this.idAnimal = idAnimal;
		this.animalName = animalName;
		this.isAlive = isAlive;
		this.animalAge = animalAge;
		this.animalType = animalType;
		ambientalAffectation = animalType.getReparation();
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public String getAnimalName() {
		return animalName;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public int getAnimalAge() {
		return animalAge;
	}

	public int getAmbientalAffectation() {
		return ambientalAffectation;
	}

	public AnimalType getAnimalType() {
		return animalType;
	}

	@Override
	public String toString() {
		return "Animal [idAnimal=" + idAnimal + ", animalName=" + animalName + ", isAlive=" + isAlive + ", animalAge="
				+ animalAge + ", ambientalAffectation=" + ambientalAffectation + ", animalType=" + animalType + "]";
	}
}
