package model;

import java.util.ArrayList;

public class Menu {
    public int calories;
    public double cost;
    public boolean vegetarian;
    public String foodPlace;

    // REQUIRES: calories >= 0,  cost >=0, foodPlace is not null
    // EFFECTS: construct a menu with calories, cost, food place where the menu is available,
    //          and whether or not the menu is vegetarian
    public Menu(int cal, double price, boolean vegie, String place) {
        calories = cal;
        cost = price;
        vegetarian = vegie;
        foodPlace = place;
    }

    // EFFECTS: returns a string representation of a menu
    public String toString(Menu menu) {
        return null; // stub
    }

}
