package model;

public class Person {
	
	private int idPerson;
	private String personName;
	private boolean isAlive;
	private int personAge;
	private int ambientalAffectation;
	private int x;
	private int y;
	private Gender gender;
	
	public Person(int idPerson, String personName, boolean isAlive, int personAge, int ambientalConservation, int ambientalImpact, Gender gender, int x, int y) {
		this.idPerson = idPerson;
		this.personName = personName;
		this.isAlive = isAlive;
		this.personAge = personAge;
		this.gender = gender;
		this.x = x;
		this.y = y;
		calculateAmbAffec(ambientalConservation, ambientalImpact);
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

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
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
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Person [idPerson=" + idPerson + ", personName=" + personName + ", isAlive=" + isAlive + ", personAge="
				+ personAge + ", ambientalAffectation=" + ambientalAffectation + ", gender=" + gender + "]";
	}
	
	public Object[] toArrayPerson(){
		return new Object[]{personName, personAge, isAlive, getAmbientalAffectation()};
	}
}
