package gui;

import model.DailyPlan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DailyMealPlan {
    protected static JFrame frame;
    private JPanel dailyPlanPanel;
    private JButton doneButton;
    private JLabel totalCalories;
    private JLabel totalPrice;
    private JLabel dailyMenu;

    public DailyMealPlan() {
        frame = new JFrame("Project_k3x2b");
        //Create and set up the window.
        frame.setContentPane(dailyPlanPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        // turn list into a string and put it on a label
        dailyMenu.setText(DailyPlan.toNewString());

        totalCalories.setText("Total Calories: " + DailyPlan.getTotalCalories());
        totalPrice.setText("Daily Budget: " + DailyPlan.getTotalCost());

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new App();
                frame.setVisible(false);
            }
        });

    }
}
