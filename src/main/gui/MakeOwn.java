package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeOwn {
    private JList list1;
    private JPanel makeOwnPanel;
    private JButton addMenuButton;
    private JButton deleteMenuButton;
    private JButton doneButton;

    public MakeOwn(JFrame frame) {
        //Create and set up the window.
        frame.setContentPane(makeOwnPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        addMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DailyPlan(frame);
                makeOwnPanel.setVisible(false);
            }
        });
    }

}
