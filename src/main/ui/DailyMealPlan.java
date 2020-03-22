package ui;

import model.DailyPlan;
import model.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a window with current menus of the meal plan laid out.
public class DailyMealPlan {
    protected static JFrame frame;
    private JPanel dailyPlanPanel;
    private JButton doneButton;
    private JLabel totalCalories;
    private JLabel totalPrice;
    private JList list1;
    private DefaultListModel listModel;

    // EFFECTS: set up a window with current menus of the meal plan laid out in a JList.
    public DailyMealPlan() {
        frame = new JFrame("Project_k3x2b");
        //Create and set up the window.
        frame.setContentPane(dailyPlanPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel();
        for (Menu menu: DailyPlan.dailyPlan) {
            listModel.addElement(menu.getName());
        }
        list1.setModel(listModel);

        totalCalories.setText("Total Calories: " + DailyPlan.getTotalCalories());
        totalPrice.setText("Daily Budget: " + DailyPlan.getTotalCost());

        //Display the window.
        frame.pack();
        frame.setVisible(true);

        initiateDoneButton();
    }

    // EFFECTS: go back to the main window (App)
    public void initiateDoneButton() {
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new App();
                frame.setVisible(false);
            }
        });
    }
}
