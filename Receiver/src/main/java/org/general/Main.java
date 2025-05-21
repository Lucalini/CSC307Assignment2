package org.general;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private DrawPanel panel;

    public Main() {
        panel = new DrawPanel();
        Repository.getInstance().addObserver(panel);
        add(panel);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] args = {};
        Subscriber.main(args);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Main();
    }
}
