package ui;

import model.DailyPlan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

// Represents a window where user can input the desired information to generate meal plan with
public class GenerateIntermidStep extends GuiWindow {
    protected static JFrame frame;
    private JTextField caloriesTextField;
    private JTextField budgetTextField;
    private JTextField veggieTextField;
    private JPanel generateIntermediatePanel;
    private JButton doneButton;
    private JButton backButton;

    // EFFECTS: set up a window where user can type
    //          desired calories, budget, dietary restriction to generate meal plan with
    public GenerateIntermidStep() {
        super(frame);
        createWindow(generateIntermediatePanel);
        displayWindow();

        initiateDoneButton();
        initiateBackButton();
    }

    // REQUIRES: textFields are not empty
    // MODIFIES: DailyPlay
    // EFFECTS: generate a daily plan using the desired calories, budget, and dietary restriction users entered.
    //          go to DailyMealPlan window.
    public void initiateDoneButton() {
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DailyPlan.generateMealPlan(
                        parseInt(caloriesTextField.getText()),
                        parseDouble(budgetTextField.getText()),
                        parseBoolean(veggieTextField.getText()));

                new DailyMealPlan();
                invisibleWindow();
            }
        });
    }

    // EFFECTS: go back to GeneratePlan window.
    public void initiateBackButton() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GeneratePlan();
                invisibleWindow();
            }
        });
    }
}
