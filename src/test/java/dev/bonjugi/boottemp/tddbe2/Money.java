package dev.bonjugi.boottemp.tddbe2;

public class Money {
    protected int amount;

    public Money() {
    }

    public Money(int i) {
        amount=i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }
}
