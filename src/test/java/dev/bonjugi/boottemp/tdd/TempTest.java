package dev.bonjugi.boottemp.tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TempTest {


	@Test
	public void testMultiplication(){
		Money five = Money.dollar(5);
		assertThat(Money.dollar(10), is(five.times(2)));
		assertThat(Money.dollar(15), is(five.times(3)));

	}
	@Test
	public void testFrancMultiplication(){
		Franc five = Money.franc(5);
		assertThat(Money.franc(10), is(five.times(2)));
		assertThat(Money.franc(15), is(five.times(3)));
	}

	@Test
	public void tetEquality(){
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertTrue(Money.franc(5).equals(Money.franc(5)));
		assertFalse(Money.franc(5).equals(Money.franc(6)));


		assertThat(Money.franc(5), not(Money.dollar(5)));
	}

}