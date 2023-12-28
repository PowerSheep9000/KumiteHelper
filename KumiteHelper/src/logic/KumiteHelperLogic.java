package logic;

import java.util.*;
import java.util.stream.Collectors;
import domain.Contestant;
import domain.Fight;
import domain.WeightClass;

public class KumiteHelperLogic {
	private static KumiteHelperLogic INSTANCE;
	private List<Contestant> contestants;
	private List<Fight> fights;
	private List<WeightClass> weightClasses;
	
	public KumiteHelperLogic() {
		this.contestants = new ArrayList<>();
		this.fights = new ArrayList<>();
		this.weightClasses = new ArrayList<>();
	}
	
	public static KumiteHelperLogic getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new KumiteHelperLogic();
		}
		return INSTANCE;
	}
	public void addContestant(String firstName, String lastName, char gender, double weight, String grade) {
		Contestant toAdd = new Contestant(firstName, lastName, gender, weight, grade);
		this.contestants.add(toAdd);
	}
	public void printAllContestants() {
		for (Contestant c: this.contestants) {
			System.out.println(c);
		}
	}
	public List<Contestant> getAllContestants() {
		List<Contestant> toReturn = new ArrayList<>();
		for (Contestant c: this.contestants) {
			toReturn.add(c);
		}
		return toReturn;
	}
	public void addWeightClass(double maxWeight, char genderOfContestants) {
		WeightClass toAdd = new WeightClass(maxWeight, genderOfContestants);
		this.weightClasses.add(toAdd);
	}
	public WeightClass getWeightClass(double maxWeight, char gender) {
		WeightClass toReturn = new WeightClass();
		for (WeightClass w: this.weightClasses) {
			if (w.getMaxWeight() == maxWeight && w.getGenderOfContestants() == gender) {
				toReturn = w;
			}
		}
		return toReturn;
	}
	public void printAllWeightClasses() {
		for (WeightClass w: this.weightClasses) {
			System.out.println(w);
		}
	}
	public List<WeightClass> getAllWeightClasses() {
		List<WeightClass> toReturn = new ArrayList<>();
		for (WeightClass w: this.weightClasses) {
			toReturn.add(w);
		}
		return toReturn;
	}
	public void addContestantsToWeightClass(WeightClass weightClass, char genderInput) {
		List<Contestant> toAdd = this.contestants.stream()
			.filter(gender -> gender.getGender() == genderInput)
			.filter(weight -> weight.getWeight() < weightClass.getMaxWeight() && weight.getWeight() >= (weightClass.getMaxWeight() - 5))
			.collect(Collectors.toList());
		weightClass.setContestantsInClass(toAdd);
		//TODO: add check if weight class exists
		// + open category and lowest category
	}
}
