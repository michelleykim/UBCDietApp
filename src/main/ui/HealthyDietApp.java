package ui;

import model.DailyPlan;
import model.User;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HealthyDietApp {
    private Scanner scanner;
    private User user;
    private DailyPlan mealPlan;

    // EFFECTS: runs the healthy diet application
    public HealthyDietApp() {
        scanner = new Scanner(System.in);
        runHealthyDietApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runHealthyDietApp() {
        String command = "";

        while (true) {
            System.out.println("Please select an option (generate meal plan or quit):");
            command = scanner.nextLine();
            System.out.println("You selected: " + command);

            if (command.equals("quit")) {
                System.out.println("Good bye!");
                break;
            }
            mealPlan = processCommand(command);
            System.out.println("Your recommended meal plan is: " + mealPlan);
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private DailyPlan processCommand(String command) {
        System.out.println("Please enter desired daily calories intake");
        int calories = scanner.nextInt();
        System.out.println("Please enter desired daily budget");
        int budget = scanner.nextInt();

        if (command.equals("generate meal plan")) {
            mealPlan.generateMealPlan(calories, budget);
        }
        return mealPlan;
    }

    // MODIFIES: this
    // EFFECTS: initializes user
    private void init() {
        user = new User(0, 0, false);
    }

}
