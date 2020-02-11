package model;

public class User {
    private int desiredCalories;
    private double desiredBudget;
    private boolean isVegetarian;

    // REQUIRES: calories >= 0,  budget >=0
    // EFFECTS: constructs a user with calories, budget, and whether or not they are vegetarian
    public User(int calories, double budget, boolean vegetarian) {
        desiredCalories = calories;
        desiredBudget = budget;
        isVegetarian = vegetarian;
    }

    public int getDesiredCalories() {
        return desiredCalories;
    }

    public double getDesiredBudget() {
        return desiredBudget;
    }

    // REQUIRES: calories >= 0,  budget >=0
    // MODIFIES: this
    // EFFECTS: update current user with the new calories, budget, and vegetarian status
    public void updateUser(int calories, double budget, boolean vegetarian) {
        this.desiredCalories = calories;
        this.desiredBudget = budget;
        this.isVegetarian = vegetarian;
    }

}
