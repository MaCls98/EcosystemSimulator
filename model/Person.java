package model;

public class Person {
	
	private int idPerson;
	private String personName;
	private boolean isAlive;
	private int personAge;
	private int ambientalAffectation;
	private String gender;
	
	public Person(int idPerson, String personName, boolean isAlive, int personAge, String gender) {
		this.idPerson = idPerson;
		this.personName = personName;
		this.isAlive = isAlive;
		this.personAge = personAge;
		this.gender = gender;
	}

	public void calculateAmbAffec(int ambientalImpact, int ambientalConservation){
		if (ambientalImpact > ambientalConservation) {
			ambientalAffectation = ambientalImpact - ambientalConservation;
		}else if (ambientalConservation < ambientalImpact) {
			ambientalAffectation = ambientalConservation - ambientalImpact;
		}
	}

	public int getIdPerson() {
		return idPerson;
	}

	public String getPersonName() {
		return personName;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public int getPersonAge() {
		return personAge;
	}

	public int getAmbientalAffectation() {
		return ambientalAffectation;
	}

	public String getGender() {
		return gender;
	}
}
