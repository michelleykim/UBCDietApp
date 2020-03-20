package ui;

import model.Account;

import javax.swing.*;
import java.awt.*;

public class AccountPage extends JPanel {
    protected JList list;
    protected DefaultListModel listModel;
    protected static final String editString = "Edit Account Information";
    protected JButton viewButton;
    protected JButton backButton;

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

        backButton = new JButton("Back");
        BackMainListener backMainListener = new BackMainListener(backButton);
        backButton.setActionCommand("Back");
        backButton.addActionListener(backMainListener);

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(viewButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(backButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

}
