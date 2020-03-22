package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DailyPlanTest {
    DailyPlan plan;

    @BeforeEach
    void runBefore() {
        plan = new DailyPlan();

    }

    @Test
    void testConstructor() {
        assertEquals(plan.getTotalCalories(), 0);
        assertEquals(plan.getTotalCost(), 0);
    }

    @Test
    void testAddOneMenu() {
        plan.addMenu("apple", 120, 1.75, true);
        assertEquals(plan.getTotalCalories(), 120);
        assertEquals(plan.getTotalCost(), 1.75);
    }

    @Test
    void testAddMultipleMenu() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        assertEquals(plan.getTotalCalories(), 120+160+100);
        assertEquals(plan.getTotalCost(), 1.75+1.25+3.99);
    }

    @Test
    void testDeleteOneMenu() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        plan.deleteMenu("apple");
        assertEquals(plan.getTotalCalories(), 160+100);
        assertEquals(plan.getTotalCost(), 1.25+3.99);
    }

    @Test
    void testDeleteMultipleMenu() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        plan.deleteMenu("apple");
        plan.deleteMenu("banana");
        assertEquals(plan.getTotalCalories(), 100);
        assertEquals(plan.getTotalCost(), 3.99);
    }

    @Test
    void testDeleteMenuNotInPlan() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        plan.deleteMenu("pear");
        assertEquals(plan.getTotalCalories(), 120+160+100);
        assertEquals(plan.getTotalCost(), 1.75+1.25+3.99);
    }

    @Test
    void testGenerateMealPlanNoRestriction() {
        plan.generateMealPlan(1200, 10.00, false);
        assertEquals(plan.getTotalCalories(), 1000);
        assertEquals(plan.getTotalCost(), 5.25);
    }

    @Test
    void testGenerateMealPlanRestriction() {
        plan.generateMealPlan(2200, 50.00, true);
        assertEquals(plan.getTotalCalories(), 1000);
        assertEquals(plan.getTotalCost(), 5.25);
    }

    @Test
    void testGenerateMealPlanNoRestriction2() {
        plan.generateMealPlan(2200, 50.00, false);
        assertEquals(plan.getTotalCalories(), 2100);
        assertEquals(plan.getTotalCost(), 38.25);
    }

    @Test
    void testGenerateMealPlanRestriction2() {
        plan.generateMealPlan(1200, 50.00, true);
        assertEquals(plan.getTotalCalories(), 1000);
        assertEquals(plan.getTotalCost(), 5.25);
    }

    @Test
    void testGenerateMealPlanEqualCalories() {
        plan.generateMealPlan(200, 20.00, false);
        assertEquals(plan.getTotalCalories(), 200);
        assertEquals(plan.getTotalCost(), 2.25);
    }

    @Test
    void testGenerateMealPlanSmallCalories() {
        plan.generateMealPlan(80, 20.00, false);
        assertEquals(plan.getTotalCalories(), 0);
        assertEquals(plan.getTotalCost(), 0);
    }

    @Test
    void testGenerateMealPlanSmallCaloriesSmallBudget() {
        plan.generateMealPlan(100, 1.00, false);
        assertEquals(plan.getTotalCalories(), 0);
        assertEquals(plan.getTotalCost(), 0.00);
    }

    @Test
    void testGenerateMealPlanSmallBudget() {
        plan.generateMealPlan(2200, 20.00, false);
        assertEquals(plan.getTotalCalories(), 1880);
        assertEquals(plan.getTotalCost(), 13.00);
    }

    @Test
    void testToString() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        assertEquals(plan.toNewString(), "apple\nbanana\ngrape\n");
    }
}
