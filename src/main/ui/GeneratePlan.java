package ui;

import model.Account;
import model.DailyPlan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a window to automatically generate daily plan
public class GeneratePlan extends GuiWindow {
    protected static JFrame frame;
    private JButton generateUsingAccountInfoButton;
    private JPanel generatePanel;
    private JButton generateFromScratchButton;
    private JButton backButton;

    // EFFECTS: set up a window where users can choose to either generate daily plan
    //          using account information, or new information.
    public GeneratePlan() {
        super(frame);
        createWindow(generatePanel);
        displayWindow();

        initiateScratchButton();
        initiateAccountButton();
        initiateBackButton();
    }

    // EFFECTS: go to GenerateIntermidStep window.
    public void initiateScratchButton() {
        generateFromScratchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GenerateIntermidStep();
                invisibleWindow();
            }
        });
    }

    // MODIFIES: DailyPlan
    // EFFECTS: generate daily plan using account information.
    //          go to DailyMealPlan window.
    public void initiateAccountButton() {
        generateUsingAccountInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // generate meal plan using account info -> Store it in daily plan
                DailyPlan.generateMealPlan(
                        Account.getDesiredCalories(), Account.getDesiredBudget(), Account.getVegetarian());

                new DailyMealPlan();
                invisibleWindow();
            }
        });
    }

    // EFFECTS: go back to main App window.
    public void initiateBackButton() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new App();
                invisibleWindow();
            }
        });
    }
}
