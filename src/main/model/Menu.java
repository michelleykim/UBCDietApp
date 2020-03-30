package model;

import model.exceptions.MinusPriceException;
import model.exceptions.MinusCaloriesException;

//Represents an individual menu that can be added to the daily plan
public class Menu {
    public String name;
    public int calories;
    public double cost;
    public boolean vegetarian;

    // EFFECTS: construct a menu with name, calories, cost,
    //          and whether or not the menu is vegetarian
    public Menu(String menuName, int cal, double price, boolean vegie)
            throws MinusCaloriesException, MinusPriceException {
        if (cal < 0) {
            throw new MinusCaloriesException("Calories is negative.");
        } else {
            if (price < 0) {
                throw new MinusPriceException("Price is negative.");
            } else {
                name = menuName;
                calories = cal;
                cost = price;
                vegetarian = vegie;
            }
        }
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
