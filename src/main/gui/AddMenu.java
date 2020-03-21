package gui;

import model.DailyPlan;
import model.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.xml.internal.ws.message.Util.parseBool;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class AddMenu {
    protected static JFrame frame;
    private JPanel addMenuPanel;
    private JTextField menuName;
    private JTextField calories;
    private JTextField price;
    private JTextField veggie;
    private JButton doneButton;
    private JButton backButton;
    protected Menu menu;

    public AddMenu() {
        frame = new JFrame("Project_k3x2b");
        //Create and set up the window.
        frame.setContentPane(addMenuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add menu
                DailyPlan.addMenu(
                        menuName.getText(),
                        parseInt(calories.getText()),
                        parseDouble(price.getText()),
                        parseBool(veggie.getText())
                );
                new MakeOwn();
                frame.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MakeOwn();
                frame.setVisible(false);
            }
        });

    }
}
