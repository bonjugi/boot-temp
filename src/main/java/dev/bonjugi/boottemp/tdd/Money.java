package dev.bonjugi.boottemp.tdd;

public class Money implements Expression {

	/**
	 * member variables
	 */
	protected int amount;

	protected String currency;


	public Money times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}



	/**
	 * factory method
	 */
	public static Money franc(int multiplier) {
		return new Money(multiplier,"CHF");
	}
	public static Money dollar(int amount) {
		return new Money(amount,"USD");
	}


	/**
	 * constructor
	 */
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}



	public String currency() {
		return this.currency;
	}


	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return amount == money.amount && currency.equals(money.currency());
	}

	public Expression plus(Money addend) {
		return new Sum(this,addend);
	}

	public Money reduce(Bank bank,String to) {

		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}




	@Override
	public String toString() {
		return "Money{" +
				"amount=" + amount +
				", currency='" + currency + '\'' +
				'}';
	}
}
