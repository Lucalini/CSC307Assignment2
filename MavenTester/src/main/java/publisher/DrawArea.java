package publisher;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class DrawArea extends JPanel implements MouseListener, Observer {
    private Repository repository;

    public DrawArea() {
        this.repository = Repository.getInstance();
        this.repository.addObserver(this);
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawOval(repository.getX(), repository.getY(), 20, 20);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        repository.setX(e.getX());
        repository.setY(e.getY());
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
