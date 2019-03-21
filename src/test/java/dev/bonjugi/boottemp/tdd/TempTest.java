package dev.bonjugi.boottemp.tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TempTest {


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