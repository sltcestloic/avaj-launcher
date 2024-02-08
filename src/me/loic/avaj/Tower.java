package me.loic.avaj;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        System.out.println("Tower says: " + flyable + " registered to weather tower.");
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        System.out.println("Tower says: " + flyable + " unregistered from weather tower.");
        this.observers.remove(flyable);
    }

    protected void conditionChanged() {
        this.observers.forEach(flyable -> flyable.updateConditions());
    }
}
