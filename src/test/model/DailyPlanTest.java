package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.DailyPlan.*;
import static org.junit.jupiter.api.Assertions.*;

public class DailyPlanTest {
    DailyPlan plan;

    @BeforeEach
    void runBefore() {
        plan = new DailyPlan();

    }

    @Test
    void testConstructor() {
        assertEquals(getTotalCalories(), 0);
        assertEquals(getTotalCost(), 0.00);
    }

    @Test
    void testAddMenuException1() {
        try {
            plan.addMenu("apple", -120, 1.75, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testAddMenuException2() {
        try {
            plan.addMenu("apple", 120, -1.75, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testAddOneMenu() {
        plan.addMenu("apple", 120, 1.75, true);
        assertEquals(getTotalCalories(), 120);
        assertEquals(getTotalCost(), 1.75);
    }

    @Test
    void testAddMultipleMenu() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        assertEquals(getTotalCalories(), 120+160+100);
        assertEquals(getTotalCost(), 1.75+1.25+3.99);
    }

    @Test
    void testDeleteOneMenu() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        plan.deleteMenu("apple");
        assertEquals(getTotalCalories(), 260);
        assertEquals(getTotalCost(), 5.24);
    }

    @Test
    void testDeleteMultipleMenu() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        plan.deleteMenu("apple");
        plan.deleteMenu("banana");
        assertEquals(getTotalCalories(), 100);
        assertEquals(getTotalCost(), 3.99);
    }

    @Test
    void testDeleteMenuNotInPlan() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        plan.deleteMenu("pear");
        assertEquals(getTotalCalories(), 380);
        assertEquals(getTotalCost(), 6.99);
    }

    @Test
    void testGenerateMealPlanNoRestriction() {
        generateMealPlan(1200, 10.00, false);
        assertEquals(getTotalCalories(), 1000);
        assertEquals(getTotalCost(), 5.25);
    }

    @Test
    void testGenerateMealPlanRestriction() {
        generateMealPlan(2200, 50.00, true);
        assertEquals(getTotalCalories(), 1000);
        assertEquals(getTotalCost(), 5.25);
    }

    @Test
    void testGenerateMealPlanNoRestriction2() {
        generateMealPlan(2200, 50.00, false);
        assertEquals(getTotalCalories(), 2100);
        assertEquals(getTotalCost(), 38.25);
    }

    @Test
    void testGenerateMealPlanRestriction2() {
        generateMealPlan(1200, 50.00, true);
        assertEquals(getTotalCalories(), 1000);
        assertEquals(getTotalCost(), 5.25);
    }

    @Test
    void testGenerateMealPlanEqualCaloriesMoreBudget() {
        generateMealPlan(200, 20.00, false);
        assertEquals(getTotalCalories(), 200);
        assertEquals(getTotalCost(), 2.25);
    }

    @Test
    void testGenerateMealPlanEqualCaloriesEqualBudget() {
        generateMealPlan(200, 2.25, false);
        assertEquals(getTotalCalories(), 200);
        assertEquals(getTotalCost(), 2.25);
    }

    @Test
    void testGenerateMealPlanEqualCaloriesSmallBudget() {
        generateMealPlan(200, 0.00, false);
        assertEquals(getTotalCalories(), 0);
        assertEquals(getTotalCost(), 0);
    }

    @Test
    void testGenerateMealPlanSmallCaloriesMoreBudget() {
        generateMealPlan(80, 20.00, false);
        assertEquals(getTotalCalories(), 0);
        assertEquals(getTotalCost(), 0);
    }

    @Test
    void testGenerateMealPlanSmallCaloriesSmallBudget() {
        generateMealPlan(100, 1.00, false);
        assertEquals(getTotalCalories(), 0);
        assertEquals(getTotalCost(), 0);
    }

    @Test
    void testGenerateMealPlanSmallCaloriesEqualBudget() {
        generateMealPlan(100, 2.25, false);
        assertEquals(getTotalCalories(), 0);
        assertEquals(getTotalCost(), 0);
    }

    @Test
    void testGenerateMealPlanMoreCaloriesEqualBudget() {
        generateMealPlan(300, 2.25, false);
        assertEquals(getTotalCalories(), 200);
        assertEquals(getTotalCost(), 2.25);
    }

    @Test
    void testGenerateMealPlanMoreCaloriesSmallBudget() {
        generateMealPlan(300, 0.25, false);
        assertEquals(getTotalCalories(), 0);
        assertEquals(getTotalCost(), 0);
    }

    @Test
    void testGenerateMealPlanMoreCaloriesMoreBudget() {
        generateMealPlan(300, 2.55, false);
        assertEquals(getTotalCalories(), 200);
        assertEquals(getTotalCost(), 2.25);
    }

    @Test
    void testGenerateMealPlanSmallBudget() {
        generateMealPlan(300, 2.00, false);
        assertEquals(getTotalCalories(), 0);
        assertEquals(getTotalCost(), 0);
    }

    @Test
    void testToString() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        assertEquals(plan.toNewString(), "apple banana grape ");
    }
}
