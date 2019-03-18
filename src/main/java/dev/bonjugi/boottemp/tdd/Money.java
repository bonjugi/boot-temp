package dev.bonjugi.boottemp.tdd;

public abstract class Money {

	public static Franc franc(int multiplier) {
		return new Franc(multiplier);

	}

	abstract Money times(int multiplier);

	protected int amount;

	public static Dollar dollar(int amount) {
		return new Dollar(amount);
	}


	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return amount == money.amount && getClass().equals(money.getClass());
	}
}
