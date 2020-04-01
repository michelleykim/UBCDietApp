package ui;

import model.DailyPlan;
import model.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a window for users to manually make their meal plan
public class MakeOwn extends GuiWindow {
    protected static JFrame frame;
    private JList list1;
    private DefaultListModel listModel;
    private JPanel makeOwnPanel;
    private JButton addMenuButton;
    private JButton deleteMenuButton;
    private JButton doneButton;
    private JButton backButton;

    // EFFECTS: set up a window that shows the list of menus currently in the daily plan in a JList
    public MakeOwn() {
        super(frame);
        createWindow(makeOwnPanel);

        listModel = new DefaultListModel();
        for (Menu menu: DailyPlan.dailyPlan) {
            listModel.addElement(menu.getName());
        }
        list1.setModel(listModel);

        displayWindow();

        initiateAddButton();
        initiateDeleteButton();
        initiateDoneButton();
        initiateBackButton();
    }

    // EFFECTS: go to AddMenu window.
    public void initiateAddButton() {
        addMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddMenu();
                invisibleWindow();
            }
        });
    }

    // REQUIRES: DailyPlan is not empty
    // MODIFIES: DailyPlan
    // EFFECTS: delete the menu of selected index from the daily plan
    public void initiateDeleteButton() {
        deleteMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                DailyPlan.deleteMenu(list1.getModel().getElementAt(index).toString());
                listModel.removeElementAt(index);
            }
        });
    }

    // EFFECTS: go to DailyMealPlan window.
    public void initiateDoneButton() {
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DailyMealPlan();
                invisibleWindow();
            }
        });
    }

    // EFFECTS: go back to main App window.
    public void initiateBackButton() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new App();
                invisibleWindow();
            }
        });
    }

}
