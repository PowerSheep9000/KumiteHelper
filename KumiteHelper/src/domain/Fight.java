package domain;

public class Fight {
	private WeightClass weightClass;
	private Contestant shiro;
	private Contestant aka;
	private int roundLengthMinutes;
	
	public Fight(WeightClass weightClass, Contestant shiro, Contestant aka) {
		this.weightClass = weightClass;
		this.shiro = shiro;
		this.aka = aka;
		this.roundLengthMinutes = 3;
	}

	public WeightClass getWeightClass() {
		return weightClass;
	}

	public void setWeightClass(WeightClass weightClass) {
		this.weightClass = weightClass;
	}

	public Contestant getShiro() {
		return shiro;
	}

	public void setShiro(Contestant shiro) {
		this.shiro = shiro;
	}

	public Contestant getAka() {
		return aka;
	}

	public void setAka(Contestant aka) {
		this.aka = aka;
	}

	public int getRoundLengthMinutes() {
		return roundLengthMinutes;
	}

	public void setRoundLengthMinutes(int roundLengthMinutes) {
		this.roundLengthMinutes = roundLengthMinutes;
	}
	
	
}
