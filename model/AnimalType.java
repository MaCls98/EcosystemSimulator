package model;

public enum AnimalType {
	MAMMALS(15), FISHES(20), BIRDS(40), REPTILES(10), AMPHIBIANS(10);
	
	private int reparation;

	private AnimalType(int reparation) {
		this.reparation = reparation;
	}

	public int getReparation() {
		return reparation;
	}
}
