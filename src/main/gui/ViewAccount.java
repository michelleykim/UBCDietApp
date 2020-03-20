package gui;

import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.javafx.fxml.expression.Expression.add;

public class ViewAccount {
    protected static JFrame frame;
    public JPanel accountPanel;
    private JButton editInfoButton;
    private JButton backButton;
    private JLabel calories;
    private JLabel veggie;
    private JLabel budget;

    public ViewAccount() {

        //Create and set up the window.
        frame = new JFrame("Project_k3x2b");
        frame.setContentPane(accountPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        calories.setText("Desired Daily Calories Intake: " + Account.getDesiredCalories());
        budget.setText("Daily Budget: " + Account.getDesiredBudget());
        veggie.setText("Dietary Restrictions (Vegetarian): " + Account.getVegetarian());

        //Display the window.
        frame.pack();
        frame.setVisible(true);


        editInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditAccount();
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
