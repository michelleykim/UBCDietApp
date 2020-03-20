package gui;

import javax.swing.*;

public class DailyPlan {

    private JList list1;
    private JPanel dailyPlanPanel;

    public DailyPlan(JFrame frame) {
        //Create and set up the window.
        frame.setContentPane(dailyPlanPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);


        // make a list of menus in daily meal plan
        // tell total calories
        // tell total cost


    }
}
