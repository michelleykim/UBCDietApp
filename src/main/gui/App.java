package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    protected static JFrame frame;
    private JPanel mainPanel;
    private JButton viewAccountButton;
    private JButton generatePlanButton;
    private JButton makeOwnPlanButton;
    private JButton quitButton;

    public App() {

        //Create and set up the window.
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        initiateButtons();

    }

    public void initiateButtons() {
        viewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAccount();
                frame.setVisible(false);
            }
        });

        generatePlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GeneratePlan();
                frame.setVisible(false);
            }
        });

        makeOwnPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MakeOwn();
                frame.setVisible(false);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //save account information and break
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Project_k3x2b");

        new App();
    }

}
