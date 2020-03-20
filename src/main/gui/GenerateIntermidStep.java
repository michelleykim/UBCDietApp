package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateIntermidStep {
    protected static JFrame frame;
    private JTextField ex1800TextField;
    private JTextField ex2000TextField;
    private JTextField exYesTextField;
    private JPanel generateIntermediatePanel;
    private JButton doneButton;
    private JButton backButton;

    public GenerateIntermidStep() {

        frame = new JFrame("Project_k3x2b");
        //Create and set up the window.
        frame.setContentPane(generateIntermediatePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DailyPlan();
                frame.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GeneratePlan();
                frame.setVisible(false);
            }
        });

    }
}
