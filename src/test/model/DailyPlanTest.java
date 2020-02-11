package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DailyPlanTest {
    DailyPlan plan;
    Menu milk = new Menu("milk", 200, 2.25, true);
    Menu oreo = new Menu("oreo", 800, 3.00, true);
    Menu steak = new Menu("steak", 1100, 33.00, false);
    Menu wrap = new Menu("wrap", 880, 7.75, false);

    @BeforeEach
    void runBefore() {
        plan = new DailyPlan();
        ArrayList<Menu> allMenus = new ArrayList<Menu>();
        allMenus.add(0, milk);
        allMenus.add(1, oreo);
        allMenus.add(2, steak);
        allMenus.add(3, wrap);
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
}
