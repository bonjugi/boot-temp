package dev.bonjugi.boottemp.tddbe2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TddTest {


    @Test
    public void  testMultiplication(){
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.time(2));
        assertEquals(new Dollar(15), five.time(3));
    }


    @Test
    public void  testFrancMultiplication(){
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.time(2));
        assertEquals(new Franc(15), five.time(3));
    }

    @Test
    public void testEquality(){
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        assertFalse(new Money(5).equals(new Money(6)));
        assertFalse(new Money(5).equals(new Money(6)));
    }



}
