package gui;

import model.Account;
import model.DailyPlan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class GenerateIntermidStep {
    protected static JFrame frame;
    private JTextField caloriesTextField;
    private JTextField budgetTextField;
    private JTextField veggieTextField;
    private JPanel generateIntermediatePanel;
    private JButton doneButton;
    private JButton backButton;

    public GenerateIntermidStep() {

        frame = new JFrame("Project_k3x2b");
        //Create and set up the window.
        frame.setContentPane(generateIntermediatePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        initiateDoneButton();
        initiateBackButton();
    }

    public void initiateDoneButton() {
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DailyPlan.generateMealPlan(
                        parseInt(caloriesTextField.getText()),
                        parseDouble(budgetTextField.getText()),
                        parseBoolean(veggieTextField.getText()));

                new DailyMealPlan();
                frame.setVisible(false);
            }
        });
    }

    public void initiateBackButton() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GeneratePlan();
                frame.setVisible(false);
            }
        });
    }
}
