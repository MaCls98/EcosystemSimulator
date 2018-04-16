package model;

public class Person {
	
	private int idPerson;
	private String personName;
	private boolean isAlive;
	private int personAge;
	private int ambientalAffectation;
	private Gender gender;
	
	public Person(int idPerson, String personName, boolean isAlive, int personAge, Gender gender) {
		this.idPerson = idPerson;
		this.personName = personName;
		this.isAlive = isAlive;
		this.personAge = personAge;
		this.gender = gender;
	}

	public void calculateAmbAffec(int ambientalConservation, int ambientalImpact){
		ambientalAffectation = ambientalConservation - ambientalImpact;
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

	public Gender getGender() {
		return gender;
	}
	
	@Override
	public String toString() {
		return "Person [idPerson=" + idPerson + ", personName=" + personName + ", isAlive=" + isAlive + ", personAge="
				+ personAge + ", ambientalAffectation=" + ambientalAffectation + ", gender=" + gender + "]";
	}
}
