package gui;

import javax.swing.*;

public class Saved {
    protected static JFrame frame;
    private JPanel panel1;

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
