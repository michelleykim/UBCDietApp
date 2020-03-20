package gui;

import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.javafx.fxml.expression.Expression.add;

public class ViewAccount {
    public JPanel accountPanel;
    private JButton editInfoButton;
    private JButton backButton;
    private JList list1;

    public ViewAccount(JFrame frame) {

        JLabel calories = new JLabel();
        calories.setText("Desired Daily Calories Intake: " + Account.getDesiredCalories());
        JLabel budget = new JLabel();
        budget.setText("Daily Budget: " + Account.getDesiredBudget());
        JLabel veggie = new JLabel();
        veggie.setText("Dietary Restrictions (Vegetarian): " + Account.getVegetarian());

        list1.add(calories);
        list1.add(budget);
        list1.add(veggie);

        //Create and set up the window.
        frame.setContentPane(accountPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        initiateButtons();

    }

    public void initiateButtons() {
        editInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new App();
                accountPanel.setVisible(false);
            }
        });
    }
}
