package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;

public class Account implements Saveable {
    private int desiredCalories;
    private double desiredBudget;
    private boolean vegetarian;

    // EFFECTS: constructs an account with desired calories, budget, and dietary restriction
    public Account(int calories, double budget, boolean veggie) {
        this.desiredCalories = calories;
        this.desiredBudget = budget;
        this.vegetarian = veggie;

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


    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(desiredCalories);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(desiredBudget);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(vegetarian);
    }
}
