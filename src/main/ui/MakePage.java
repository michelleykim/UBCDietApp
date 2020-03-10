package ui;

import javax.swing.*;
import java.awt.*;

public class MakePage extends JPanel {
    private static final String addString = "Add Menu";
    private static final String deleteString = "Delete Menu";
    private JButton addButton;
    private JButton deleteButton;

    public MakePage() {
        super(new BorderLayout());

        addButton = new JButton(addString);
        ViewListener viewListener = new ViewListener(addButton);
        addButton.setActionCommand(addString);
        addButton.addActionListener(viewListener);

        deleteButton = new JButton(deleteString);
        GenerateListener generateListener = new GenerateListener(deleteButton);
        deleteButton.setActionCommand(deleteString);
        deleteButton.addActionListener(generateListener);

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.PAGE_AXIS));
        buttonPane.add(addButton);
        buttonPane.add(Box.createVerticalStrut(5));
        buttonPane.add(deleteButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(buttonPane, BorderLayout.PAGE_END);
    }

}
