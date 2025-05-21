package org.general;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 *
 *
 */

public class DrawPanel extends JPanel implements Observer {
    private int x = 50;
    private int y = 50;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 50, 50);
    }

    @Override
    public void update(Observable o, Object arg) {
            x = Repository.getInstance().get_x();
            y = Repository.getInstance().get_y();
            repaint();
        }
}

