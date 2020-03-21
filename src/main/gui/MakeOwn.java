package gui;

import model.DailyPlan;
import model.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeOwn {
    protected static JFrame frame;
    private JList list1;
    private DefaultListModel listModel;
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

        listModel = new DefaultListModel();
        for (Menu menu: DailyPlan.dailyPlan) {
            listModel.addElement(menu.getName());
        }
        list1.setModel(listModel);

        initiateAddButton();
        initiateDeleteButton();
        initiateDoneButton();
        initiateBackButton();
    }

    public void initiateAddButton() {
        addMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddMenu();
                frame.setVisible(false);
            }
        });
    }

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

    public void initiateDoneButton() {
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DailyMealPlan();
                frame.setVisible(false);
            }
        });
    }

    public void initiateBackButton() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new App();
                frame.setVisible(false);
            }
        });
    }

}
