//package dev.bonjugi.tddbestudy.tdd;
//
//import java.util.Objects;
//
//public class Money {
//	protected int amount;
//	protected String currency;
//
//
//	public Money (int amount, String currency){
//		this.amount=amount;
//		this.currency=currency;
//	}
//
//	public static Franc franc(int multiplier) {
//		return new Franc(multiplier,"CHF");
//	}
//
//	public static Dollar dollar(int amount) {
//		return new Dollar(amount,"USD");
//	}
//
//	public Money times(int multiplier){
//		return null;
//	}
//	String currency(){
//		return currency;
//	}
//
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		Money money = (Money) o;
//		return amount == money.amount &&
//				Objects.equals(currency, money.currency);
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Money{" +
//				"amount=" + amount +
//				", currency='" + currency + '\'' +
//				'}';
//	}
//}
