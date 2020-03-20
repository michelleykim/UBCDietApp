package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DailyPlan {
    protected static JFrame frame;
    private JList list1;
    private JPanel dailyPlanPanel;
    private JButton doneButton;

    public DailyPlan() {
        frame = new JFrame("Project_k3x2b");
        //Create and set up the window.
        frame.setContentPane(dailyPlanPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);


        // make a list of menus in daily meal plan
        // tell total calories
        // tell total cost


        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new App();
                frame.setVisible(false);
            }
        });

    }
}
