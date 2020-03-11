package ui;

import com.sun.glass.ui.Menu;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class MakePage extends JPanel implements ListSelectionListener {
    protected static JList list;
    protected static DefaultListModel listModel;

    private static final String addString = "Add Menu";
    private static final String deleteString = "Delete Menu";
    protected static JButton addButton;
    protected static JButton deleteButton;
    protected static JTextField menuName;
    protected static JTextField calories;
    protected static JTextField price;
    protected static JTextField vegetarian;


    public MakePage() {
        super(new BorderLayout());

        listModel = new DefaultListModel();
        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);

        buttonManger();

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(deleteButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(calories);
        buttonPane.add(price);
        buttonPane.add(vegetarian);
        buttonPane.add(addButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

    public void buttonManger() {
        addButton = new JButton(addString);
        AddListener addListener = new AddListener(addButton);
        addButton.setActionCommand(addString);
        addButton.addActionListener(addListener);
        addButton.setEnabled(false);

        deleteButton = new JButton(deleteString);
        DeleteListener deleteListener = new DeleteListener(deleteButton);
        deleteButton.setActionCommand(deleteString);
        deleteButton.addActionListener(deleteListener);

        textFieldManager(addListener);
    }

    public void textFieldManager(ActionListener addListener) {
        menuName = new JTextField(10);
        menuName.addActionListener(addListener);
        menuName.getDocument().addDocumentListener((DocumentListener) addListener);
        String name = listModel.getElementAt(list.getSelectedIndex()).toString();

        calories = new JTextField(10);
        calories.addActionListener(addListener);
        calories.getDocument().addDocumentListener((DocumentListener) addListener);
        String cal = listModel.getElementAt(list.getSelectedIndex()).toString();

        price = new JTextField(10);
        price.addActionListener(addListener);
        price.getDocument().addDocumentListener((DocumentListener) addListener);
        String cost = listModel.getElementAt(list.getSelectedIndex()).toString();

        vegetarian = new JTextField(10);
        vegetarian.addActionListener(addListener);
        vegetarian.getDocument().addDocumentListener((DocumentListener) addListener);
        String veggie = listModel.getElementAt(list.getSelectedIndex()).toString();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (list.getSelectedIndex() == -1) {
                deleteButton.setEnabled(false);
            } else {
                deleteButton.setEnabled(true);
            }
        }
    }
}
