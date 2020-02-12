package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    Menu milk;

    @Test
    void testConstructor() {
        milk = new Menu("milk", 200, 2.25, true);
        assertEquals(milk.getName(), "milk");
        assertEquals(milk.getCalories(), 200);
        assertEquals(milk.getCost(), 2.25);
        assertTrue(milk.getVegetarian());
    }

}
