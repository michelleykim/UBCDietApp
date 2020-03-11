package ui;

import model.Account;

import javax.swing.*;
import java.awt.*;

public class AccountPage extends JPanel {
    private JList list;
    private DefaultListModel listModel;
    private static final String editString = "Edit Account Information";
    private JButton viewButton;

    public AccountPage() {
        super(new BorderLayout());

        listModel = new DefaultListModel();
        listModel.addElement("Desired Daily Calories Intake: " + Account.getDesiredCalories());
        listModel.addElement("Daily Budget: " + Account.getDesiredBudget());
        listModel.addElement("Dietary Restrictions (Vegetarian): " + Account.getVegetarian());

        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setVisibleRowCount(4);
        JScrollPane listScrollPane = new JScrollPane(list);


        viewButton = new JButton(editString);
        ViewListener viewListener = new ViewListener(viewButton);
        viewButton.setActionCommand(editString);
        viewButton.addActionListener(viewListener);

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.PAGE_AXIS));
        buttonPane.add(viewButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

}
