package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener implements ActionListener, DocumentListener {
    private boolean alreadyEnabled = false;
    private JButton button;

    public AddListener(JButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //add menus to the dailyplan
        String name = MakePage.menuName.getText();
        int cal = Integer.parseInt(MakePage.calories.getText());
        int cost = Integer.parseInt(MakePage.price.getText());
        boolean veggie = Boolean.parseBoolean(MakePage.vegetarian.getText());

        int index = MakePage.list.getSelectedIndex();
        if (index == 1) {
            index = 0;
        } else {
            index = index + 1;
        }

        MakePage.listModel.insertElementAt(MakePage.menuName.getText(), index);
        MakePage.menuName.requestFocusInWindow();
        MakePage.menuName.setText("");

        MakePage.list.setSelectedIndex(index);
        MakePage.list.ensureIndexIsVisible(index);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        enableButton();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        handleEmptyTextField(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (!handleEmptyTextField(e)) {
            enableButton();
        }
    }

    private void enableButton() {
        if (!alreadyEnabled) {
            button.setEnabled(true);
        }
    }

    private boolean handleEmptyTextField(DocumentEvent e) {
        if (e.getDocument().getLength() <= 0) {
            button.setEnabled(false);
            alreadyEnabled = false;
            return true;
        }
        return false;
    }
}
