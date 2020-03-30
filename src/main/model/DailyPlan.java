package model;

import java.util.ArrayList;
import java.util.Iterator;

//Represents a daily plan. Each Account can have one daily plan at a time.
public class DailyPlan {
    public static ArrayList<Menu> dailyPlan = new ArrayList<>();
    public static ArrayList<Menu> allMenus = allMenus();
    public static int totalCalories;
    public static double totalCost;

    // EFFECTS: constructs an empty daily plan
    public DailyPlan() {
        //construct an empty daily plan
    }

    // EFFECTS: constructs a list of all the menus
    public static ArrayList<Menu> allMenus() {
        allMenus = new ArrayList<>();
        try {
            Menu milk = new Menu("milk", 200, 2.25, true);
            Menu oreo = new Menu("oreo", 800, 3.00, true);
            Menu steak = new Menu("steak", 1100, 33.00, false);
            Menu wrap = new Menu("wrap", 880, 7.75, false);

            allMenus.add(milk);
            allMenus.add(oreo);
            allMenus.add(steak);
            allMenus.add(wrap);

            return allMenus;
        } catch (Exception e) {
            System.out.println("Cannot get all menus.");
            return allMenus;
        }
    }

    // MODIFIES: this
    // EFFECTS: generate a recommended daily plan based on user desired calories and budget
    public static void generateMealPlan(int totalCalories, double totalBudget, boolean vegetarian) {

        if (vegetarian) {
            allMenus.removeIf(menu -> !menu.getVegetarian());
        }

        for (Menu menu : allMenus) {
            if (menu.getCalories() <= totalCalories && menu.getCost() <= totalBudget) {
                dailyPlan.add(menu);
                totalCalories = totalCalories - menu.getCalories();
                totalBudget = totalBudget - menu.getCost();
            }
        }

    }

    // MODIFIES: this
    // EFFECTS: adds a menu to daily plan
    public static void addMenu(String menuName, int cal, double price, boolean vegie) {
        try {
            Menu newMenu = new Menu(menuName, cal, price, vegie);
            dailyPlan.add(newMenu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // MODIFIES: this
    // EFFECTS: deletes a menu from daily plan
    public static void deleteMenu(String menuName) {
        for (Menu menu : dailyPlan) {
            if (menu.getName().equals(menuName)) {
                dailyPlan.remove(menu);
                return;
            }
        }
    }

    // EFFECTS: returns a string representation of daily plan
    public static String toNewString() {
        StringBuilder dailyPlanString = new StringBuilder();

        for (Menu menu : dailyPlan) {
            dailyPlanString.append(menu.getName()).append(" ");
        }

        return dailyPlanString.toString();
    }

    // EFFECTS: add up all the calories of the menu in the plan and return total calories
    public static int getTotalCalories() {
        totalCalories = 0;

        for (Menu menu : dailyPlan) {
            totalCalories = totalCalories + menu.getCalories();
        }
        return totalCalories;
    }

    // EFFECTS: add up all the cost of the menu in the plan and return total cost
    public static double getTotalCost() {
        totalCost = 0.00;

        for (Menu menu : dailyPlan) {
            totalCost = totalCost + menu.getCost();
        }
        return Math.round(totalCost * 100.0) / 100.0;
    }

}
