package ui;

import model.Account;
import model.DailyPlan;
import model.WeeklyPlan;
import persistence.Reader;
import persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

// Meal Planner Application
public class HealthyDietApp {
    private static final String ACCOUNTS_FILE = "./data/accounts.txt";
    private Scanner scanner;
    private DailyPlan mealPlan;
    private WeeklyPlan weeklyPlan;
    private Account account;
    String command;

    // EFFECTS: runs the healthy diet application
    public HealthyDietApp() {
        scanner = new Scanner(System.in);
        runHealthyDietApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runHealthyDietApp() {
        boolean keepGoing = true;

        loadAccounts();

        while (keepGoing) {

            System.out.println("Please select an option: ");
            System.out.println("view account or generate or make own or quit");
            command = scanner.nextLine();
            System.out.println("You selected: " + command);

            if (command.equals("quit")) {
                saveAccounts();
                System.out.println("Good bye!");
                keepGoing = false;
            } else {
                whichCommand(command);
            }
        }
    }

    private void whichCommand(String command) {
        if (command.equals("view account")) {
            mealPlan = processCommand(command);
        } else if (command.equals("generate")) {
            mealPlan = processCommand(command);
            System.out.println("Your recommended meal plan is:\n" + mealPlan.toString());
            weeklyPlan = addDailyToWeekly();
        } else if (command.equals("make own")) {
            mealPlan = processCommand(command);
            System.out.println("Your meal plan is: \n" + mealPlan.toString());
            System.out.println("Total calories is: " + mealPlan.getTotalCalories());
            System.out.println("Total price is: " + mealPlan.getTotalCost());
            weeklyPlan = addDailyToWeekly();
        }
    }

    // EFFECTS: saves state of account to ACCOUNTS_FILE
    private void saveAccounts() {
        try {
            Writer writer = new Writer(new File(ACCOUNTS_FILE));
            writer.write(account);
            writer.close();
            System.out.println("Account saved to file " + ACCOUNTS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save account to " + ACCOUNTS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private DailyPlan processCommand(String command) {

        if (command.equals("view account")) {
            viewAccount();
        } else if (command.equals("generate")) {
            System.out.println("Would you like to use saved account info to generate meal plan? (yes or no)");
            String whetherOr = scanner.nextLine();
            if (whetherOr.equals("yes")) {
                mealPlan = generateUsingAccount();
            } else if (whetherOr.equals("no")) {
                mealPlan = generateFromScratch();
            }

        } else if (command.equals("make own")) {
            mealPlan = makeOwn();
        }

        return mealPlan;
    }

    private void viewAccount() {
        System.out.println("Account desired daily calories intake is: ");
        System.out.println(account.getDesiredCalories());
        System.out.println("Account desired daily budget is: ");
        System.out.println(account.getDesiredBudget());
        System.out.println("Account dietary restriction status (vegetarian) is: ");
        System.out.println(account.getVegetarian());

        System.out.println("Would you like to make changes to the account info? (yes or no)");
        String whetherOr = scanner.nextLine();
        if (whetherOr.equals("yes")) {
            changeAccountInfo();
            System.out.println("Changes successfully made.");
        } else if (whetherOr.equals("no")) {
            System.out.println("No changes were made.");
        }
    }

    private void changeAccountInfo() {
        System.out.println("Please enter desired daily calories intake: ");
        account.setDesiredCalories(scanner.nextInt());
        System.out.println("Please enter desired daily budget: ");
        account.setDesiredBudget(scanner.nextDouble());
        System.out.println("Are you vegetarian? (true or false)");
        account.setVegetarian(scanner.nextBoolean());
        scanner.nextLine();
    }

    // MODIFIES: this
    // EFFECTS: loads accounts from ACCOUNTS_FILE, if that file exists;
    // otherwise initializes accounts with default values
    private void loadAccounts() {
        try {
            List<Account> accounts = Reader.readAccounts(new File(ACCOUNTS_FILE));
            account = accounts.get(0);
        } catch (IOException e) {
            init();
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        account = new Account(2000, 200.00, true);
    }

    private DailyPlan generateUsingAccount() {
        DailyPlan generatedPlan = new DailyPlan();

        int calories = account.getDesiredCalories();
        double budget = account.getDesiredBudget();
        boolean vegetarian = account.getVegetarian();

        generatedPlan.generateMealPlan(calories, budget, vegetarian);
        return generatedPlan;
    }

    private DailyPlan generateFromScratch() {
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
                addMenu(customizedPlan);
                System.out.println("The menu is added to the meal plan");
                System.out.println("Current meal plan:\n" + customizedPlan.toString());

            } else if (command.equals("delete menu")) {
                System.out.println("Which menu would you like to delete?");
                String menuName = scanner.nextLine();

                customizedPlan.deleteMenu(menuName);
                System.out.println("The menu is deleted from the meal plan");
                System.out.println("Current meal plan:\n" + customizedPlan.toString());
            }
        }
        return customizedPlan;
    }

    private void addMenu(DailyPlan newPlan) {
        System.out.println("Please enter the menu's name: ");
        String menuName = scanner.nextLine();

        System.out.println("Please enter the menu's calories: ");
        int cal = scanner.nextInt();

        System.out.println("Please enter the menu's price: ");
        double cost = scanner.nextDouble();

        System.out.println("Is the menu vegetarian?");
        boolean veggie = scanner.nextBoolean();

        scanner.nextLine();
        newPlan.addMenu(menuName, cal, cost, veggie);
    }

    private WeeklyPlan addDailyToWeekly() {
        weeklyPlan = new WeeklyPlan();
        System.out.println("Would you like to add the daily plan to the weekly plan? (yes or no)");
        String whetherOr = scanner.nextLine();

        if (whetherOr.equals("yes")) {
            weeklyPlan.addPlan(mealPlan);
            System.out.println("The daily plan has added to your weekly plan.");
        } else if (whetherOr.equals("no")) {
            System.out.println("The daily plan has not added to your weekly plan.");
        }
        return weeklyPlan;
    }

}
