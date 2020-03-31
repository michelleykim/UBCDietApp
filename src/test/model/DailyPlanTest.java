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
        assertEquals(getTotalCalories(), 7520);
        assertEquals(getTotalCost(), 94.95);
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
        assertEquals(getTotalCalories(), 3480);
        assertEquals(getTotalCost(), 32.98);
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
        assertEquals(getTotalCalories(), 3740);
        assertEquals(getTotalCost(), 38.22);
    }

    @Test
    void testDeleteMultipleMenu() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        plan.deleteMenu("apple");
        plan.deleteMenu("banana");
        assertEquals(getTotalCalories(), 5040);
        assertEquals(getTotalCost(), 49.71);
    }

    @Test
    void testDeleteMenuNotInPlan() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        plan.deleteMenu("pear");
        assertEquals(getTotalCalories(), 5420);
        assertEquals(getTotalCost(), 56.7);
    }

    @Test
    void testGenerateMealPlanNoRestriction() {
        generateMealPlan(1200, 10.00, false);
        assertEquals(getTotalCalories(), 2960);
        assertEquals(getTotalCost(), 26.73);
    }

    @Test
    void testGenerateMealPlanRestriction() {
        generateMealPlan(2200, 50.00, true);
        assertEquals(getTotalCalories(), 1380);
        assertEquals(getTotalCost(), 12.24);
    }

    @Test
    void testGenerateMealPlanNoRestriction2() {
        generateMealPlan(2200, 50.00, false);
        assertEquals(getTotalCalories(), 7520);
        assertEquals(getTotalCost(), 94.95);
    }

    @Test
    void testGenerateMealPlanRestriction2() {
        generateMealPlan(1200, 50.00, true);
        assertEquals(getTotalCalories(), 4740);
        assertEquals(getTotalCost(), 43.47);
    }

    @Test
    void testGenerateMealPlanEqualCaloriesMoreBudget() {
        generateMealPlan(200, 20.00, false);
        assertEquals(getTotalCalories(), 3360);
        assertEquals(getTotalCost(), 31.23);
    }

    @Test
    void testGenerateMealPlanEqualCaloriesEqualBudget() {
        generateMealPlan(200, 2.25, false);
        assertEquals(getTotalCalories(), 1580);
        assertEquals(getTotalCost(), 14.49);
    }

    @Test
    void testGenerateMealPlanEqualCaloriesSmallBudget() {
        generateMealPlan(200, 0.00, false);
        assertEquals(getTotalCalories(), 1960);
        assertEquals(getTotalCost(), 21.48);
    }

    @Test
    void testGenerateMealPlanSmallCaloriesMoreBudget() {
        generateMealPlan(80, 20.00, false);
        assertEquals(getTotalCalories(), 3160);
        assertEquals(getTotalCost(), 28.98);
    }

    @Test
    void testGenerateMealPlanSmallCaloriesSmallBudget() {
        generateMealPlan(100, 1.00, false);
        assertEquals(getTotalCalories(), 7520);
        assertEquals(getTotalCost(), 94.95);
    }

    @Test
    void testGenerateMealPlanSmallCaloriesEqualBudget() {
        generateMealPlan(100, 2.25, false);
        assertEquals(getTotalCalories(), 4740);
        assertEquals(getTotalCost(), 43.47);
    }

    @Test
    void testGenerateMealPlanMoreCaloriesEqualBudget() {
        generateMealPlan(300, 2.25, false);
        assertEquals(getTotalCalories(), 4940);
        assertEquals(getTotalCost(), 45.72);
    }

    @Test
    void testGenerateMealPlanMoreCaloriesSmallBudget() {
        generateMealPlan(300, 0.25, false);
        assertEquals(getTotalCalories(), 380);
        assertEquals(getTotalCost(), 6.99);
    }

    @Test
    void testGenerateMealPlanMoreCaloriesMoreBudget() {
        generateMealPlan(300, 2.55, false);
        assertEquals(getTotalCalories(), 3160);
        assertEquals(getTotalCost(), 28.98);
    }

    @Test
    void testGenerateMealPlanSmallBudget() {
        generateMealPlan(300, 2.00, false);
        assertEquals(getTotalCalories(), 1380);
        assertEquals(getTotalCost(), 12.24);
    }

    @Test
    void testToString() {
        plan.addMenu("apple", 120, 1.75, true);
        plan.addMenu("banana", 160, 1.25, true);
        plan.addMenu("grape", 100, 3.99, true);
        assertEquals(plan.toNewString(), "apple banana grape milk oreo milk apple banana grape ");
    }
}
