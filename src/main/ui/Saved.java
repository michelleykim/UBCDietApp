package ui;

import javax.swing.*;

// Represents a pop up window that tells the user that the account information has been saved
public class Saved extends GuiWindow {
    protected static JFrame frame;
    private JPanel panel1;

    // EFFECTS: set up a pop up window that tells the user that the account information has been saved
    public Saved() {
        super(frame);
        createWindow(panel1);
        displayWindow();
    }
}
