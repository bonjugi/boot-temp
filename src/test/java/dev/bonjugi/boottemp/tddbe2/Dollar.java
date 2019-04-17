package dev.bonjugi.boottemp.tddbe2;

public class Dollar extends Money {

    public Dollar(int amount, String currency) {
	    super(amount,currency);
    }

    @Override
    public Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }

	@Override
    public int hashCode() {
        return amount;
    }

    @Override
    public String toString() {
        return "Dollar{" +
                "amount=" + amount +
                '}';
    }
}
