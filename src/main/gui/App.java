package gui;

import model.Account;
import persistence.Reader;
import persistence.Writer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class App {
    private static final String ACCOUNTS_FILE = "./data/accounts.txt";
    protected static JFrame frame;
    private JPanel mainPanel;
    private JButton viewAccountButton;
    private JButton generatePlanButton;
    private JButton makeOwnPlanButton;
    private JButton quitButton;
    protected static Account account;

    public App() {

        //Create and set up the window.
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        initiateButtons();
    }


    public void initiateButtons() {
        viewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAccount();
                frame.setVisible(false);
            }
        });

        generatePlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GeneratePlan();
                frame.setVisible(false);
            }
        });

        makeOwnPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MakeOwn();
                frame.setVisible(false);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //save account information and break
                try {
                    Writer writer = new Writer(new File(ACCOUNTS_FILE));
                    writer.write(account);
                    writer.close();
                    System.out.println("Account saved to file " + ACCOUNTS_FILE);
                } catch (FileNotFoundException | UnsupportedEncodingException fnfe) {
                    System.out.println("Unable to save account to " + ACCOUNTS_FILE);
                }
                new Saved();
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Project_k3x2b");

        new App();
    }

}
