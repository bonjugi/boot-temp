package dev.bonjugi.boottemp.tddbe2;

public class Franc extends Money {

    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc time(int multiplier) {
        return new Franc(amount * multiplier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Franc dollar = (Franc) o;

        return amount == dollar.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
