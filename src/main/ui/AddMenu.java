package ui;

import model.DailyPlan;
import model.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Boolean.parseBoolean;

// Represents a window to add the specification of the desired menu
public class AddMenu extends GuiWindow {
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
        super(frame);
        createWindow(addMenuPanel);
        displayWindow();

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
                        parseBoolean(veggie.getText())
                );
                new MakeOwn();
                invisibleWindow();
            }
        });
    }

    // EFFECTS: go back to the MakeOwn window.
    public void initiateBackButton() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MakeOwn();
                invisibleWindow();
            }
        });
    }
}
