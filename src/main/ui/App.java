package ui;

import model.Account;
import persistence.Writer;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

// Represents a main (initial) window of the app
public class App extends GuiWindow {
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
        super(frame);
        createWindow(mainPanel);
        displayWindow();

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
                invisibleWindow();
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
                invisibleWindow();
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
                invisibleWindow();
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
                invisibleWindow();
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
