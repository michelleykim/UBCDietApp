package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    Menu milk;

    @Test
    void testConstructor() {
        try {
            milk = new Menu("milk", 200, 2.25, true);
        } catch (Exception e) {
            fail("This exception should not have been thrown.");
        }
        assertEquals(milk.getName(), "milk");
        assertEquals(milk.getCalories(), 200);
        assertEquals(milk.getCost(), 2.25);
        assertTrue(milk.getVegetarian());
    }

    @Test
    void testMinusBudgetException() {
        try {
            milk = new Menu("milk", 200, -2.25, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertNull(milk);
    }

    @Test
    void testMinusCaloriesException() {
        try {
            milk = new Menu("milk", -10, 2.25, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertNull(milk);
    }

}
