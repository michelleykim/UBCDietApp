package model;

import java.util.ArrayList;
import java.util.List;

public class AllMenus {
    public static List<Menu> allMenus;

    public AllMenus() {
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

        } catch (Exception e) {
            System.out.println("Cannot get all menus.");
        }
    }
}
