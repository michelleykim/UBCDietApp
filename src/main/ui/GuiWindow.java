package ui;

import javax.swing.*;


public class GuiWindow {
    JFrame frame;

    public GuiWindow(JFrame frame0) {
        this.frame = frame0;
    }

    // EFFECTS: Create and set up the window.
    public void createWindow(JPanel panel) {
        frame = new JFrame("Project_k3x2b");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // EFFECTS: Display window.
    public void displayWindow() {
        frame.pack();
        frame.setVisible(true);
    }

    // EFFECTS: Make window invisible.
    public void invisibleWindow() {
        frame.setVisible(false);
    }
}
