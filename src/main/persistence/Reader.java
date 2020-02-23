package persistence;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.Account;
import model.DailyPlan;
import model.Menu;
import model.WeeklyPlan;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static final String DELIMITER = "/";

    // EFFECTS: returns a list of accounts parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<Account> readAccounts(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of accounts parsed from list of strings
    // where each string contains data for one account
    private static List<Account> parseContent(List<String> fileContent) {
        List<Account> accounts = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            accounts.add(parseAccount(lineComponents));
        }

        return accounts;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 3 where element 0 represents the
    // desiredCalories, element 1 represents the desiredBudget,
    // and elements 2 represents the dietary restriction
    // EFFECTS: returns an account constructed from components
    private static Account parseAccount(List<String> components) {
        int desiredCalories = Integer.parseInt(components.get(0));
        double desiredBudget = Double.parseDouble(components.get(1));
        boolean vegetarian = Boolean.parseBoolean(components.get(2));

        return new Account(desiredCalories, desiredBudget, vegetarian);
    }

    //private static WeeklyPlan parseWeeklyPlan(String stringPlan) {
    //    WeeklyPlan weeklyPlan = null;
    //    String[] splits = stringPlan.split(",");
    //    ArrayList<String> plans = new ArrayList<>(Arrays.asList(splits));
    //
    //    for (String plan : plans) {
    //        ArrayList<DailyPlan> dailyPlan = new ArrayList();
    //
    //        if (menu.getName == plan) {
    //            dailyPlan.add(menu);
    //        }
    //    }
    //    return weeklyPlan;
    //}
}
