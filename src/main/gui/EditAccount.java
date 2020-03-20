package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAccount {
    private JTextField ex2000TextField;
    private JTextField ex2125TextField;
    private JTextField yesTextField;
    private JButton doneButton;
    private JButton backButton;
    private JPanel editAccountPanel;

    public EditAccount(JFrame frame) {
        //Create and set up the window.
        frame.setContentPane(editAccountPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAccount(frame);
                editAccountPanel.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAccount(frame);
                editAccountPanel.setVisible(false);
            }
        });

    }
}
