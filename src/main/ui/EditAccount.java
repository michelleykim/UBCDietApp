package ui;

import model.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

// Represents a window that user can edit account information
public class EditAccount extends GuiWindow {
    protected static JFrame frame;
    private JTextField caloriesTextField;
    private JTextField budgetTextField;
    private JTextField veggieTextField;
    private JButton doneButton;
    private JButton backButton;
    private JPanel editAccountPanel;

    // EFFECTS: set up a window where user can edit desired calories, budget and dietary restrictions.
    public EditAccount() {
        super(frame);
        createWindow(editAccountPanel);
        displayWindow();

        initiateDoneButton();
        initiateBackButton();
    }

    // REQUIRES: textFields are not empty
    // MODIFIES: Account
    // EFFECTS: updates account information with the user input.
    //          go back to the ViewAccount window.
    public void initiateDoneButton() {
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account.setDesiredCalories(parseInt(caloriesTextField.getText()));
                Account.setDesiredBudget(parseDouble(budgetTextField.getText()));
                Account.setVegetarian(parseBoolean(veggieTextField.getText()));

                new ViewAccount();
                invisibleWindow();
            }
        });
    }

    // EFFECTS: go back to the ViewAccount window.
    public void initiateBackButton() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAccount();
                invisibleWindow();
            }
        });
    }
}
