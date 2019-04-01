package dev.bonjugi.boottemp.tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * TDDBE 책을 보면서 예제를 따라하였음.
 */
public class TempTest {

	@Test
	public void testPlusSameCurrencyReturnsMoney(){

		Expression sum = Money.dollar(1).plus(Money.dollar(1));

		System.out.println(sum instanceof Money);
		System.out.println(sum instanceof Expression);
		System.out.println(sum instanceof Sum);


	}

	@Test
	public void testSumTimes(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFranc = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);

		Expression sum = new Sum(fiveBucks,tenFranc).times(2);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(20), result);
	}
	@Test
	public void testSumPlusMoney(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFranc = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFranc).plus(fiveBucks);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(15), result);
	}

	@Test
	public void testMixedAddition(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);

		Money result = bank.reduce( fiveBucks.plus(tenFrancs), "USD");
		assertEquals(Money.dollar(10),result);
	}


	@Test
	public void testIdentityRate(){
		assertEquals(1, new Bank().rate("USD","USD"));
	}


	@Test
	public void testReduceMoney(){
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(1), "USD");
		assertEquals(Money.dollar(1),result);
	}

	@Test
	public void testReduceSum(){
		Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(7),result);
	}

	@Test
	public void testPlusReturnsSum(){
		Money five = Money.dollar(5);
		Expression result= five.plus(five);
		Sum sum = (Sum) result;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
	}

	@Test
	public void testSimpleAddition(){
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(10),reduced);

	}

	@Test
	public void testCurrency(){
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}


	@Test
	public void testMultiplication(){
		Money five = Money.dollar(5);
		assertThat(Money.dollar(10), is(five.times(2)));
		assertThat(Money.dollar(15), is(five.times(3)));

	}

	@Test
	public void tetEquality(){
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertThat(Money.franc(5), not(Money.dollar(5)));
	}

}