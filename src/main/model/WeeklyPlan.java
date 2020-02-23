package model;

import java.util.ArrayList;

public class WeeklyPlan {
    ArrayList<DailyPlan> weeklyPlan;

    // EFFECTS: constructs an empty weekly plan
    public WeeklyPlan() {
        weeklyPlan = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add daily plan to weekly plan
    public void addPlan(DailyPlan dailyPlan) {
        weeklyPlan.add(dailyPlan);
    }

}
