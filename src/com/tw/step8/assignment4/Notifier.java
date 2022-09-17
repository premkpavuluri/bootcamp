package com.tw.step8.assignment4;

import java.util.ArrayList;

public class Notifier {
  private final ArrayList<Observer> observers;

  public Notifier() {
    this.observers = new ArrayList<>();
  }

  public boolean addObserver(Observer observer) {
    return observers.add(observer);
  }

  private void notifyObservers(int lotId, Event event) {
    for (Observer observer : this.observers) {
      if (observer.getSubscribedEvent() == event) {
        observer.observe(lotId, event);
      }
    }
  }

  public void notifyEightyPercent(int id) {
    this.notifyObservers(id, Event.LOT_ABOVE_EIGHTY);
  }

  public void notifyTwentyPercent(int id) {
    this.notifyObservers(id, Event.LOT_WITHIN_TWENTY);
  }

  public void notifyFull(int id) {
    this.notifyObservers(id, Event.LOT_FULL);
  }
}
