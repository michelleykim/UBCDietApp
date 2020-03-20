package ui;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JPanel {
    private static final String viewString = "View Account Information";
    private static final String generateString = "Generate Meal Plan";
    private static final String makeOwnString = "Make Own Meal Plan";
    protected static JFrame frame;
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
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.PAGE_AXIS));
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



}
