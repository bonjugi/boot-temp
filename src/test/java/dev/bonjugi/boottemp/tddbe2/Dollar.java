package dev.bonjugi.boottemp.tddbe2;

public class Dollar extends Money {

    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar time(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dollar dollar = (Dollar) o;

        return amount == dollar.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
