package me.loic.avaj;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        Logger.log("Tower says: " + flyable + " registered to weather tower.");
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        Logger.log("Tower says: " + flyable + " unregistered from weather tower.");
        this.observers.remove(flyable);
    }

    protected void conditionChanged() {
        List<Flyable> list = new ArrayList<>(this.observers);
        for (Flyable flyable : list) {
            flyable.updateConditions();
        }
    }
}
