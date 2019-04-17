package dev.bonjugi.boottemp.tddbe2;

public class Franc extends Money {


    public Franc(int amount) {
        this.amount = amount;
    }

	@Override
	public Money times(int multiplier) {
		return new Franc(amount * multiplier);
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;
        return amount == money.amount;
    }

	@Override
    public int hashCode() {
        return amount;
    }

    @Override
    public String toString() {
        return "Franc{" +
                "amount=" + amount +
                '}';
    }
}
