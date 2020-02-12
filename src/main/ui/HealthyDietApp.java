package ui;

import model.DailyPlan;

import java.util.Scanner;

public class HealthyDietApp {
    private Scanner scanner;
    private DailyPlan mealPlan;

    // EFFECTS: runs the healthy diet application
    public HealthyDietApp() {
        scanner = new Scanner(System.in);
        runHealthyDietApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runHealthyDietApp() {
        String command;

        System.out.println("Please select an option (generate or make own or quit):");
        command = scanner.nextLine();
        System.out.println("You selected: " + command);

        switch (command) {
            case "quit":
                System.out.println("Good bye!");
                break;
            case "generate":
                mealPlan = processCommand(command);
                System.out.println("Your recommended meal plan is:\n" + mealPlan.toString());
                break;
            case "make own":
                mealPlan = processCommand(command);
                System.out.println("Your meal plan is: " + mealPlan.toString());
                System.out.println("Total calories is: " + mealPlan.getTotalCalories());
                System.out.println("Total price is: " + mealPlan.getTotalCost());
                break;
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
        DailyPlan generatedPlan = new DailyPlan();

        System.out.println("Please enter desired daily calories intake: ");
        int calories = scanner.nextInt();
        System.out.println("Please enter desired daily budget: ");
        double budget = scanner.nextDouble();
        System.out.println("Are you vegetarian? (true or false)");
        boolean vegetarian = scanner.nextBoolean();

        generatedPlan.generateMealPlan(calories, budget, vegetarian);
        return generatedPlan;
    }

    private DailyPlan makeOwn() {
        DailyPlan customizedPlan = new DailyPlan();

        while (true) {
            System.out.println("Please select an option (add menu or delete menu or done):");
            String command = scanner.nextLine();
            System.out.println("You selected: " + command);

            if (command.equals("done")) {
                System.out.println("Done customizing meal plan!");
                break;
            }

            if (command.equals("add menu")) {
                customizedPlan = addMenu();
                System.out.println("The menu is added to the meal plan");
                System.out.println("Current meal plan: " + customizedPlan + customizedPlan.toString());

            } else if (command.equals("delete menu")) {
                System.out.println("Which menu would you like to delete?");
                String menuName = scanner.nextLine();

                customizedPlan.deleteMenu(menuName);
                System.out.println("The menu is deleted from the meal plan");
                System.out.println("Current meal plan: " + customizedPlan.toString());
            }
        }
        return customizedPlan;
    }

    private DailyPlan addMenu() {
        DailyPlan customizedPlan = new DailyPlan();

        System.out.println("Please enter the menu's name: ");
        String menuName = scanner.nextLine();

        System.out.println("Please enter the menu's calories: ");
        int cal = scanner.nextInt();

        System.out.println("Please enter the menu's price: ");
        double cost = scanner.nextDouble();

        System.out.println("Is the menu vegetarian?");
        boolean vegie = scanner.nextBoolean();

        customizedPlan.addMenu(menuName, cal, cost, vegie);
        return customizedPlan;
    }

}
