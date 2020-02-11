package ui;

import model.DailyPlan;
import model.Menu;

import java.util.Scanner;

public class HealthyDietApp {
    private Scanner scanner;
    private DailyPlan mealPlan;
    private int totalCalories;
    private double totalCost;

    // EFFECTS: runs the healthy diet application
    public HealthyDietApp() {
        scanner = new Scanner(System.in);
        runHealthyDietApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runHealthyDietApp() {
        String command;

        while (true) {
            System.out.println("Please select an option (generate or make own or quit):");
            command = scanner.nextLine();
            System.out.println("You selected: " + command);

            if (command.equals("quit")) {
                System.out.println("Good bye!");
                break;
            } else if (command.equals("generate")) {
                mealPlan = processCommand(command);
                System.out.println("Your recommended meal plan is: " + mealPlan.toString());
            } else if (command.equals("make own")) {
                mealPlan = processCommand(command);
                System.out.println("Your meal plan is: " + mealPlan.toString());
                System.out.println("Total calories is: " + mealPlan.getTotalCalories());
                System.out.println("Total price is: " + mealPlan.getTotalCost());
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private DailyPlan processCommand(String command) {

        if (command.equals("generate")) {
            mealPlan = generate();

        } else if (command.equals("make own")) {
            mealPlan = makeOwn();
        }
        return mealPlan;
    }

    private DailyPlan generate() {
        System.out.println("Please enter desired daily calories intake: ");
        int calories = scanner.nextInt();
        System.out.println("Please enter desired daily budget: ");
        double budget = scanner.nextDouble();
        System.out.println("Are you vegetarian? (true or false)");
        boolean vegetarian = scanner.nextBoolean();

        mealPlan.generateMealPlan(calories, budget, vegetarian);
        return mealPlan;
    }

    private DailyPlan makeOwn() {
        while (true) {
            System.out.println("Please select an option (add menu or delete menu or done):");
            String command = scanner.nextLine();
            System.out.println("You selected: " + command);

            if (command.equals("add menu")) {
                System.out.println("Please enter the menu's name: ");
                String menuName = scanner.nextLine();
                System.out.println("Please enter the menu's calories: ");
                int cal = scanner.nextInt();
                System.out.println("Please enter the menu's price: ");
                double cost = scanner.nextDouble();
                System.out.println("Is the menu vegetarian?");
                boolean vegie = scanner.nextBoolean();

                mealPlan.addMenu(menuName, cal, cost, vegie);

            } else if (command.equals("delete menu")) {
                System.out.println("Which menu would you like to delete?");
                String menuName = scanner.nextLine();

                mealPlan.deleteMenu(menuName);

            } else if (command.equals("done")) {
                return mealPlan;
            }
        }
    }

}
