package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {
    private JButton button;
    private JList list;
    private DefaultListModel listModel;

    public DeleteListener(JButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //delete menu from dailyPlan
        int index = list.getSelectedIndex();
        listModel.remove(index);

        int size = listModel.getSize();

        if (size == 0) {
            MakeOwnPage.deleteButton.setEnabled(false);
        } else {
            if (index == listModel.getSize()) {
                index = index - 1;
            }

            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }
    }
}
