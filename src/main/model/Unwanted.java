package model;

import java.util.ArrayList;

public class Unwanted {
    ArrayList<Menu> unwanted;

    // EFFECTS: if user does not have a dietary restrictions, construct an empty list of unwanted menus
    //          otherwise, construct a list of unwanted menu with !restriction
    public Unwanted() {
        unwanted = new ArrayList<Menu>();
    }

    // MODIFIES: this
    // EFFECTS: adds a menu to unwanted list
    public void addMenu() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: deletes a menu from unwanted list
    public void deleteMenu() {
        // stub
    }

    // EFFECTS: returns a string representation of unwanted list
    public String toString() {
        return null; // stub
    }

}
