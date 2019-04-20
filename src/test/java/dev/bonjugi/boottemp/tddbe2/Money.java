package dev.bonjugi.boottemp.tddbe2;

public class Money {

    protected int amount;
	protected String currency;

	public static Money dollar(int amount) {
		return new Money(amount,"USD");
	}

	public static Money franc(int amount) {
		return new Money(amount,"CHF");
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Money money = (Money) o;
        return amount == money.amount && currency().equals(money.currency());
    }

	public Money times(int multiplier){
		return new Money(amount * multiplier , currency);
	}

	public String currency() {
		return this.currency;
	}

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Money{" +
				"amount=" + amount +
				", currency='" + currency + '\'' +
				'}';
	}
}
