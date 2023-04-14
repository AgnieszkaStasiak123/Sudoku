package org.sudoku;

import java.util.ArrayList;
import java.util.List;

public abstract class ToObserve {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void action(){
        for (Observer o : observers){
            o.doOnObserver();
        }
    }
}
