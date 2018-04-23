package model;

public class Animal {
	
	private int idAnimal;
	private String animalName;
	private boolean isAlive;
	private int animalAge;
	private int ambientalAffectation;
	private int x;
	private int y;
	private AnimalType animalType;
	
	public Animal(int idAnimal, String animalName, boolean isAlive, int animalAge, AnimalType animalType, int x, int y) {
		this.idAnimal = idAnimal;
		this.animalName = animalName;
		this.isAlive = isAlive;
		this.animalAge = animalAge;
		this.animalType = animalType;
		this.x = x;
		this.y = y;
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void move(){
		if (x < 500) {
			x+=10;
		}
	}

	@Override
	public String toString() {
		return "Animal [idAnimal=" + idAnimal + ", animalName=" + animalName + ", isAlive=" + isAlive + ", animalAge="
				+ animalAge + ", ambientalAffectation=" + ambientalAffectation + ", animalType=" + animalType + "]";
	}
	
	public Object[] toArrayAnimal(){
		return new Object[]{animalName, animalAge, isAlive, getAmbientalAffectation()};
	}
}
