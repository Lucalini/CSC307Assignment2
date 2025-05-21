package publisher;
import java.util.Observable;

public class Repository extends Observable{
    private int x;
    private int y;

    private static Repository instance = null;

    private Repository() {
        this.x = 0;
        this.y = 0;
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        setChanged();
        notifyObservers();

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        setChanged();
        notifyObservers();

    }
}
