package gui;

import model.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratePlan {
    private JButton generateUsingAccountInfoButton;
    private JPanel generatePanel;
    private JButton generateFromScratchButton;
    private JButton backButton;

    public GeneratePlan(JFrame frame) {
    //Create and set up the window.
        frame.setContentPane(generatePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Display the window.
        frame.pack();
        frame.setVisible(true);

        generateFromScratchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        generateUsingAccountInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DailyPlan(frame);
                generatePanel.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new App();
                generatePanel.setVisible(false);
            }
        });
    }
}
