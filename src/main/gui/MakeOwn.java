package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeOwn {
    protected static JFrame frame;
    private JList list1;
    private JPanel makeOwnPanel;
    private JButton addMenuButton;
    private JButton deleteMenuButton;
    private JButton doneButton;
    private JButton backButton;

    public MakeOwn() {

        frame = new JFrame("Project_k3x2b");
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
                new DailyMealPlan();
                frame.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new App();
                frame.setVisible(false);
            }
        });
    }

}
