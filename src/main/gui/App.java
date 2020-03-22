package gui;

import model.Account;
import persistence.Reader;
import persistence.Writer;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

// Represents a main (initial) window of the app
public class App {
    private static final String ACCOUNTS_FILE = "./data/accounts.txt";
    protected static JFrame frame;
    private JPanel mainPanel;
    private JButton viewAccountButton;
    private JButton generatePlanButton;
    private JButton makeOwnPlanButton;
    private JButton quitButton;
    protected static Account account;
    File audioFile = new File("c:\\Windows\\media\\click.wav");
    AudioClip audio;

    // EFFECTS: set up a window where user can choose to either view account,
    //          generate meal plan, customize meal plan, or save and exit the app
    public App() {
        //Create and set up the window.
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        initiateViewButton();
        initiateGenerateButton();
        initiateMakeButton();
        initiateQuitButtons();
    }

    // EFFECTS: with a clicking sound, goto ViewAccount window.
    public void initiateViewButton() {
        viewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound();
                new ViewAccount();
                frame.setVisible(false);
            }
        });
    }

    // EFFECTS: with a clicking sound, goto GeneratePlan window.
    public void initiateGenerateButton() {
        generatePlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound();
                new GeneratePlan();
                frame.setVisible(false);
            }
        });

    }

    // EFFECTS: with a clicking sound, goto MakeOwn window.
    public void initiateMakeButton() {
        makeOwnPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound();
                new MakeOwn();
                frame.setVisible(false);
            }
        });
    }

    // MODIFIES: Account
    // EFFECTS: with a clicking sound, save the account and goto Saved window.
    public void initiateQuitButtons() {
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
                playSound();
                new Saved();
                frame.setVisible(false);
            }
        });
    }

    // REQUIRES: valid URL with wanted sound
    // EFFECTS: plays the clicking sound.
    public void playSound() {
        try {
            audio = Applet.newAudioClip(audioFile.toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        audio.play();
    }

    // Open the app.
    public static void main(String[] args) {
        frame = new JFrame("Project_k3x2b");

        new App();
    }

}
