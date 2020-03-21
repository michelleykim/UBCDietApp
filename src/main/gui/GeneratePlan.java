package gui;

import model.Account;
import model.DailyPlan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratePlan {
    protected static JFrame frame;
    private JButton generateUsingAccountInfoButton;
    private JPanel generatePanel;
    private JButton generateFromScratchButton;
    private JButton backButton;

    public GeneratePlan() {

        frame = new JFrame("Project_k3x2b");
    //Create and set up the window.
        frame.setContentPane(generatePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Display the window.
        frame.pack();
        frame.setVisible(true);



        generateFromScratchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GenerateIntermidStep();
                frame.setVisible(false);
            }
        });

        generateUsingAccountInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // generate meal plan using account info -> Store it in daily plan
                DailyPlan.generateMealPlan(
                        Account.getDesiredCalories(), Account.getDesiredBudget(), Account.getVegetarian());

                new DailyMealPlan();
                frame.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new App();
                frame.setVisible(false);
            }
        });
    }
}
