package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    Account account;

    @Test
    void testConstructor() {
        account = new Account(1000, 100.88, true);
        assertEquals(account.getDesiredCalories(), 1000);
        assertEquals(account.getDesiredBudget(), 100.88);
        assertTrue(account.getVegetarian());
    }

    @Test
    void testSetters() {
        account = new Account(1000, 100.88, true);
        account.setDesiredCalories(2020);
        account.setDesiredBudget(200.21);
        account.setVegetarian(false);
        assertEquals(account.getDesiredCalories(), 2020);
        assertEquals(account.getDesiredBudget(), 200.21);
        assertFalse(account.getVegetarian());
    }
}
