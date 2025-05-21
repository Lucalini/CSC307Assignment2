package org.general;

import java.util.Observable;

public class Repository extends Observable {

    private static Repository instance; // Singleton instance
    private int x; // Example internal state
    private int y;

    // Private constructor prevents external instantiation
    private Repository() {}

    // Public method to access the singleton instance
    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public void updateValue(int x, int y) {
        this.x = x;
        this.y =y;
        setChanged(); // Mark as changed
        notifyObservers(); // Notify with new value
    }

    public int get_x(){
        return x;
    }

    public int get_y(){
        return y;
    }
}

