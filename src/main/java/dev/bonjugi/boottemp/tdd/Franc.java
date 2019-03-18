package dev.bonjugi.boottemp.tdd;

public class Franc extends Money{

	public Franc(int amount) {
		this.amount = amount;
	}

	public Franc times(int multiplier) {
		return Money.franc(amount * multiplier);
	}

	@Override
	public String toString() {
		return "Franc{" +
				"amount=" + amount +
				'}';
	}
}
