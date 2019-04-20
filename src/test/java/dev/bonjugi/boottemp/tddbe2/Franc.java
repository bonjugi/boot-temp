package dev.bonjugi.boottemp.tddbe2;

public class Franc extends Money {

    public Franc(int amount, String currency) {
    	super(amount,currency);
    }

    @Override
    public String toString() {
        return "Franc{" +
                "amount=" + amount +
                '}';
    }
}
