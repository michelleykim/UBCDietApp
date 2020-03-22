package gui;

import model.DailyPlan;
import model.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.xml.internal.ws.message.Util.parseBool;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

// Represents a window to add the specification of the desired menu
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

    // EFFECTS: set up a window where the specifics of the menu will be written
    public AddMenu() {
        frame = new JFrame("Project_k3x2b");
        //Create and set up the window.
        frame.setContentPane(addMenuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        initiateDoneButton();
        initiateBackButton();
    }

    // REQUIRES: non-empty textFields
    // MODIFIES: DailyPlan
    // EFFECTS: adds a menu with typed calories, price and dietary restrictions to the daily plan.
    //          go back to the MakeOwn window.
    public void initiateDoneButton() {
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
    }

    // EFFECTS: go back to the MakeOwn window.
    public void initiateBackButton() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MakeOwn();
                frame.setVisible(false);
            }
        });
    }
}
