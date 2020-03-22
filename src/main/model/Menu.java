package model;

import java.util.ArrayList;

//Represents an individual menu that can be added to the daily plan
public class Menu {
    public String name;
    public int calories;
    public double cost;
    public boolean vegetarian;

    // REQUIRES: calories >= 0,  cost >=0, foodPlace is not null
    // EFFECTS: construct a menu with name, calories, cost,
    //          and whether or not the menu is vegetarian
    public Menu(String menuName, int cal, double price, boolean vegie) {
        name = menuName;
        calories = cal;
        cost = price;
        vegetarian = vegie;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public double getCost() {
        return cost;
    }

    public boolean getVegetarian() {
        return vegetarian;
    }

}
