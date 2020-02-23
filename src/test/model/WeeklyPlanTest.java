package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeeklyPlanTest {
    WeeklyPlan plan;
    DailyPlan apple = new DailyPlan();
    DailyPlan banana = new DailyPlan();
    DailyPlan grape = new DailyPlan();

    @BeforeEach
    void runBefore() {
        plan = new WeeklyPlan();
        apple.addMenu("apple", 120, 1.75, true);
        banana.addMenu("banana", 160, 1.25, true);
        grape.addMenu("grape", 100, 3.99, true);
    }

    @Test
    void testConstructor() {
        assertEquals(plan.getTotalCalories(), 0);
        assertEquals(plan.getTotalCost(), 0);
    }

    @Test
    void testAddOnePlan() {
        plan.addPlan(apple);
        assertEquals(plan.getTotalCalories(), 120);
        assertEquals(plan.getTotalCost(), 1.75);
    }

    @Test
    void testAddMultiplePlan() {
        plan.addPlan(apple);
        plan.addPlan(banana);
        plan.addPlan(grape);
        assertEquals(plan.getTotalCalories(), 120+160+100);
        assertEquals(plan.getTotalCost(), 1.75+1.25+3.99);
    }
}
