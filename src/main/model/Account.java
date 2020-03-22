package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;

//Represents an account. Only one account is formed per app
public class Account implements Saveable {
    private static int desiredCalories;
    private static double desiredBudget;
    private static boolean vegetarian;

    // MODIFIES: this
    // EFFECTS: constructs an account with desired calories, budget, and dietary restriction
    public Account(int calories, double budget, boolean veggie) {
        this.desiredCalories = calories;
        this.desiredBudget = budget;
        this.vegetarian = veggie;

    }

    public static int getDesiredCalories() {
        return desiredCalories;
    }

    public static double getDesiredBudget() {
        return desiredBudget;
    }

    public static boolean getVegetarian() {
        return vegetarian;
    }

    public static void setDesiredCalories(int i) {
        desiredCalories = i;
    }

    public static void setDesiredBudget(double d) {
        desiredBudget = d;
    }

    public static void setVegetarian(boolean b) {
        vegetarian = b;
    }

    @Override
    // save the account data in a form: desiredCalories/desiredBudget/vegetarian
    public void save(PrintWriter printWriter) {
        printWriter.print(desiredCalories);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(desiredBudget);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(vegetarian);
    }

}
