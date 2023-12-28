package domain;

import java.util.*;

public class WeightClass {
	private double maxWeight;
	private char genderOfContestants;
	private List<Contestant> contestantsInClass;
	
	public WeightClass() {
		
	}
	public WeightClass(double maxWeight, char genderOfContestants) {
		this.maxWeight = maxWeight;
		this.genderOfContestants = genderOfContestants;
		this.contestantsInClass = new ArrayList<>();
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public char getGenderOfContestants() {
		return genderOfContestants;
	}

	public void setGenderOfContestants(char genderOfContestants) {
		this.genderOfContestants = genderOfContestants;
	}

	public List<Contestant> getContestantsInClass() {
		return contestantsInClass;
	}

	public void setContestantsInClass(List<Contestant> contestantsInClass) {
		this.contestantsInClass = contestantsInClass;
	}
	public String toString() {
		return "under " + this.maxWeight + " category for " + this.genderOfContestants + " competitors";
	}
	
}
