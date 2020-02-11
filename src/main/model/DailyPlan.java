package model;

import java.util.ArrayList;

public class DailyPlan {
    ArrayList<Menu> dailyPlan;
    public int totalCalories;
    public double totalCost;

    // EFFECTS: constructs an empty daily plan
    public DailyPlan() {
        dailyPlan = new ArrayList<Menu>();
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public double getTotalCost() {
        return totalCost;
    }

    // MODIFIES: this
    // EFFECTS: generate a recommended daily plan based on user desired calories and budget
    public void generateMealPlan(int totalCalories, double totalCost) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: adds a menu to daily plan
    public void addMenu() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: deletes a menu from daily plan
    public void deleteMenu() {
        // stub
    }

    // EFFECTS: returns a string representation of daily plan
    public String toString() {
        return null; // stub
    }

}
