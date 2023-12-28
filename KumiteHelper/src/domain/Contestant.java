package domain;

public class Contestant {
	private String firstName;
	private String lastName;
	private char gender;
	private double weight;
	private String grade;
	
	public Contestant(String firstName, String lastName, char gender, double weight, String grade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.weight = weight;
		this.grade = grade;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String toString() {
		return this.firstName + " " + this.lastName + " (" + this.weight + " kg), " + this.grade;
	}
	
	
}
