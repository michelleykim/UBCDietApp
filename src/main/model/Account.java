package model;

import persistence.Saveable;

import java.io.PrintWriter;

public class Account implements Saveable {
    private int desiredCalories;
    private double desiredBudget;
    private boolean vegetarian;
    private WeeklyPlan weeklyPlan;

    // EFFECTS: constructs an account with desired calories, budget, and dietary restriction
    public Account(int calories, double budget, boolean veggie, WeeklyPlan plan) {
        this.desiredCalories = calories;
        this.desiredBudget = budget;
        this.vegetarian = veggie;
        this.weeklyPlan = plan;

    }

    public int getDesiredCalories() {
        return desiredCalories;
    }

    public double getDesiredBudget() {
        return desiredBudget;
    }

    public boolean getVegetarian() {
        return vegetarian;
    }

    public WeeklyPlan getWeeklyPlan() {
        return weeklyPlan;
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(desiredCalories);
        printWriter.print(desiredBudget);
        printWriter.print(vegetarian);
        printWriter.print(weeklyPlan);
    }
}
