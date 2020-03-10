package ui;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JPanel {

    private static final String viewString = "View Account Information";
    private static final String generateString = "Generate Meal Plan";
    private static final String makeOwnString = "Make Own Meal Plan";
    private JButton viewButton;
    private JButton generateButton;
    private JButton makeOwnButton;

    public MainPage() {
        super(new BorderLayout());

        viewButton = new JButton(viewString);
        ViewListener viewListener = new ViewListener(viewButton);
        viewButton.setActionCommand(viewString);
        viewButton.addActionListener(viewListener);

        generateButton = new JButton(generateString);
        GenerateListener generateListener = new GenerateListener(generateButton);
        generateButton.setActionCommand(generateString);
        generateButton.addActionListener(generateListener);

        makeOwnButton = new JButton(makeOwnString);
        MakeOwnListener makeOwnListener = new MakeOwnListener(makeOwnButton);
        makeOwnButton.setActionCommand(makeOwnString);
        makeOwnButton.addActionListener(makeOwnListener);

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.PAGE_AXIS));
        buttonPane.add(viewButton);
        buttonPane.add(Box.createVerticalStrut(5));
        buttonPane.add(generateButton);
        buttonPane.add(Box.createVerticalStrut(5));
        buttonPane.add(makeOwnButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(buttonPane, BorderLayout.CENTER);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Project_k3x2b");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new MainPage();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


    public static void viewAccount() {

    }



}