package ui;

import javax.swing.*;
import java.awt.*;

public class GeneratePage extends JPanel {
    private static final String savedAccountString = "Generate With Saved Account Info";
    private static final String newAccountString = "Generate With New Account Info";
    private JButton savedAccountButton;
    private JButton newAccountButton;
    private JButton backButton;

    public GeneratePage() {
        super(new BorderLayout());

        savedAccountButton = new JButton(savedAccountString);
        GenerateListener generateListener = new GenerateListener(savedAccountButton);
        savedAccountButton.setActionCommand(savedAccountString);
        savedAccountButton.addActionListener(generateListener);

        newAccountButton = new JButton(newAccountString);
        MakeOwnListener makeOwnListener = new MakeOwnListener(newAccountButton);
        newAccountButton.setActionCommand(newAccountString);
        newAccountButton.addActionListener(makeOwnListener);

        backButton = new JButton("Back");
        BackMainListener backMainListener = new BackMainListener(backButton);
        backButton.setActionCommand("Back");
        backButton.addActionListener(backMainListener);

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.PAGE_AXIS));
        buttonPane.add(savedAccountButton);
        buttonPane.add(Box.createVerticalStrut(5));
        buttonPane.add(newAccountButton);
        buttonPane.add(Box.createVerticalStrut(5));
        buttonPane.add(backButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(buttonPane, BorderLayout.CENTER);
    }

}
