package publisher;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        Main x = new Main();
        x.setSize(800, 600);
        x.setVisible(true);
        Repository repository;
        repository = Repository.getInstance();
        Publisher publisher = new Publisher();
        repository.addObserver(publisher);
        new Thread(publisher).start();
    }
    Main(){
        DrawArea d = new DrawArea();
        add(d);

    }
}
