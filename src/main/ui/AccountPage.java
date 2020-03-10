package ui;

import javax.swing.*;
import java.awt.*;

public class AccountPage extends JPanel {
    private static final String editString = "Edit Account Information";
    private JButton viewButton;

    public AccountPage() {
        super(new BorderLayout());

        viewButton = new JButton(editString);
        ViewListener viewListener = new ViewListener(viewButton);
        viewButton.setActionCommand(editString);
        viewButton.addActionListener(viewListener);

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.PAGE_AXIS));
        buttonPane.add(viewButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(buttonPane, BorderLayout.PAGE_END);
    }

}
