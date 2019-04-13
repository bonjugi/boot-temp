package dev.bonjugi.tddbestudy.tddseason2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TddTest {


    @Test
    public void  testMultiplication(){
        Dollar five = new Dollar(5);
        Dollar product = five.time(2);
        assertEquals(10, product.amount);       // 이 public 참조가 언제어떻게 사라지는지!
        product = five.time(3);
        assertEquals(15, product.amount);

    }

    @Test
    public void testEquality(){
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }



}
