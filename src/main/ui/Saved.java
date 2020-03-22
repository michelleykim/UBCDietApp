package ui;

import javax.swing.*;

// Represents a pop up window that tells the user that the account information has been saved
public class Saved {
    protected static JFrame frame;
    private JPanel panel1;

    // EFFECTS: set up a pop up window that tells the user that the account information has been saved
    public Saved() {
        frame = new JFrame("Project_k3x2b");
        //Create and set up the window.
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
