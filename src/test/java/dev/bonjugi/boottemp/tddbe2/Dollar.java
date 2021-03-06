package dev.bonjugi.boottemp.tddbe2;

public class Dollar extends Money {

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Money time(int multiplier) {
        return new Dollar(amount * multiplier);
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
