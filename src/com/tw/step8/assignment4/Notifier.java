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

  private void notifyObservers(Event event) {
    for (Observer observer : this.observers) {
      if (observer.getSubscribedEvent() == event) {
        observer.observe(event.asString());
      }
    }
  }

  public void notifyEightyPercent() {
    this.notifyObservers(Event.ABOVE_EIGHTY);
  }

  public void notifyTwentyPercent() {
    this.notifyObservers(Event.WITHIN_TWENTY);
  }

  public void notifyFull() {
    this.notifyObservers(Event.FULL);
  }
}
