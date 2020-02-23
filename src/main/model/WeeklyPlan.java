package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;

public class WeeklyPlan implements Saveable {
    ArrayList<DailyPlan> weeklyPlan;
    int totalCalories;
    double totalCost;

    // EFFECTS: constructs an empty weekly plan
    public WeeklyPlan() {
        weeklyPlan = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add daily plan to weekly plan
    public void addPlan(DailyPlan dailyPlan) {
        weeklyPlan.add(dailyPlan);
    }

    public int getTotalCalories() {
        for (DailyPlan plan : weeklyPlan) {
            totalCalories = totalCalories + plan.getTotalCalories();
        }
        return totalCalories;
    }

    public double getTotalCost() {
        totalCost = 0.00;

        for (DailyPlan plan : weeklyPlan) {
            totalCost = totalCost + plan.getTotalCost();
        }
        return totalCost;
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(getTotalCalories());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(getTotalCost());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(weeklyPlan);
    }
}
