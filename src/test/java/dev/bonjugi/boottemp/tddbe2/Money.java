package dev.bonjugi.boottemp.tddbe2;

public abstract class Money {
    protected int amount;

    public Money() {
    }

    public Money(int i) {
        amount=i;
    }

	public static Money dollar(int amount) {
		return new Dollar(amount);
	}

	public static Money franc(int amount) {
		return new Franc(amount);
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && money.getClass().equals(o.getClass());
    }


	public abstract Money times(int multiplier);
}
