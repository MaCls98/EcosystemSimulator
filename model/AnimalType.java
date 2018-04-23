package model;

public enum AnimalType {
	MAMMALS(60), FISHES(50), BIRDS(50), REPTILES(45), AMPHIBIANS(45);
	
	private int reparation;

	private AnimalType(int reparation) {
		this.reparation = reparation;
	}

	public int getReparation() {
		return reparation;
	}
}
