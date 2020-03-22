package gui;

import model.Account;
import persistence.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.sun.javafx.fxml.expression.Expression.add;

// Represents a window that shows the current account information.
public class ViewAccount {
    private static final String ACCOUNTS_FILE = "./data/accounts.txt";
    protected static JFrame frame;
    public JPanel accountPanel;
    private JButton editInfoButton;
    private JButton backButton;
    private JLabel calories;
    private JLabel veggie;
    private JLabel budget;
    private JButton loadInfoButton;

    // EFFECTS: set up a window that shows desired calories, budget and dietary restrictions of the account
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

        initiateLoadButton();
        initiateEditButton();
        initiateBackButton();
    }

    // MODIFIES: Account
    // EFFECTS: load the previously saved account information.
    //          if no accounts were saved before, nothing happens.
    public void initiateLoadButton() {
        loadInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Account> accounts = Reader.readAccounts(new File(ACCOUNTS_FILE));
                    App.account = accounts.get(0);
                } catch (IOException ioe) {
                    System.out.println("there is no information saved in the file");
                }
                new App();
                frame.setVisible(false);
            }
        });
    }

    // EFFECTS: go to EditAccount window.
    public void initiateEditButton() {
        editInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditAccount();
                frame.setVisible(false);
            }
        });
    }

    // EFFECTS: go back to main App window.
    public void initiateBackButton() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new App();
                frame.setVisible(false);
            }
        });
    }
}
