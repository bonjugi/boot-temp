package dev.bonjugi.boottemp.tdd;

public class Dollar extends Money{

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar times(int multiplier) {
		return new Dollar(amount * multiplier);
	}

	@Override
	public String toString() {
		return "Dollar{" +
				"amount=" + amount +
				'}';
	}
}
