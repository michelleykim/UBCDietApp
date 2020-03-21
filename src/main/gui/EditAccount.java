package gui;

import model.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class EditAccount {
    protected static JFrame frame;
    private JTextField caloriesTextField;
    private JTextField budgetTextField;
    private JTextField veggieTextField;
    private JButton doneButton;
    private JButton backButton;
    private JPanel editAccountPanel;

    public EditAccount() {

        frame = new JFrame("Project_k3x2b");
        //Create and set up the window.
        frame.setContentPane(editAccountPanel);
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
                Account.setDesiredCalories(parseInt(caloriesTextField.getText()));
                Account.setDesiredBudget(parseDouble(budgetTextField.getText()));
                Account.setVegetarian(parseBoolean(veggieTextField.getText()));

                new ViewAccount();
                frame.setVisible(false);
            }
        });
    }

    public void initiateBackButton() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAccount();
                frame.setVisible(false);
            }
        });
    }
}
