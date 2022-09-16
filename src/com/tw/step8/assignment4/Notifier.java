package com.tw.step8.assignment4;

public class Notifier {
  private final Observer[] observers;

  public Notifier(Observer[] observers) {
    this.observers = observers;
  }

  private void notifyObservers(String notification) {
    for (Observer observer : this.observers) {
      observer.observe(notification);
    }
  }

  public void notifyEightyPercent() {
    String notification = "Parking lot is 80% full";
    this.notifyObservers(notification);
  }

  public void notifyTwentyPercent() {
    String notification = "Parking lot is 20% or lesser";
    this.notifyObservers(notification);
  }

  public void notifyFull() {
    String notification = "Parking lot is full";
    this.notifyObservers(notification);
  }
}
