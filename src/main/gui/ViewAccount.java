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
