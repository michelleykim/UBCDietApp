package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewListener implements ActionListener {
    private JButton button;

    public ViewListener(JButton button) {
        this.button = button;
    }

    @Override
    //Create JPanel that views account information
    public void actionPerformed(ActionEvent e) {
        //Create and set up the window.
        JFrame frame = new JFrame("Project_k3x2b");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new AccountPage();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


}
