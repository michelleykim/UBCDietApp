package model;

import java.util.ArrayList;

public class DailyPlan {
    ArrayList<Menu> dailyPlan;
    ArrayList<Menu> allMenus;
    public int totalCalories;
    public double totalCost;

    // EFFECTS: constructs an empty daily plan
    public DailyPlan() {
        dailyPlan = new ArrayList<Menu>();
    }

    public int getTotalCalories() {
        for (Menu menu : dailyPlan) {
            totalCalories = totalCalories + menu.getCalories();
        }
        return totalCalories;
    }

    public double getTotalCost() {
        for (Menu menu : dailyPlan) {
            totalCost = totalCost + menu.getCost();
        }
        return totalCost;
    }

    // MODIFIES: this
    // EFFECTS: generate a recommended daily plan based on user desired calories and budget
    public void generateMealPlan(int totalCalories, double totalBudget, boolean vegetarian) {
        int caloriesPerMeal = totalCalories / 3;
        double budgetPerMeal = totalBudget / 3;

        if (vegetarian == true) {
            for (Menu menu : allMenus) {
                if (!menu.getVegetarian()) {
                    allMenus.remove(menu);
                }
            }
            for (Menu menu : allMenus) {
                if (menu.getCalories() <= caloriesPerMeal && menu.getCost() <= budgetPerMeal) {
                    dailyPlan.add(menu);
                }
            }
        }

    }

    // MODIFIES: this
    // EFFECTS: adds a menu to daily plan
    public void addMenu(String menuName, int cal, double price, boolean vegie) {
        Menu newMenu = new Menu(menuName, cal, price, vegie);
        dailyPlan.add(newMenu);
    }

    // MODIFIES: this
    // EFFECTS: deletes a menu from daily plan
    public void deleteMenu(String menuName) {
        for (Menu menu : dailyPlan) {
            if (menu.getName() == menuName) {
                dailyPlan.remove(menu);
                return;
            }
        }
    }

    // EFFECTS: returns a string representation of daily plan
    public String toString() {
        String dailyPlanString = "";

        for (Menu menu : dailyPlan) {
            dailyPlanString = dailyPlanString + "\n" + menu.getName();
        }

        return dailyPlanString;
    }

}
