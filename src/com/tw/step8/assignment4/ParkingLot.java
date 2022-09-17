package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exceptions.NegativeSlotsException;
import com.tw.step8.assignment4.exceptions.NoSlotAvailableException;

public class ParkingLot {
  private final int id;
  private final int numberOfSlots;
  private int occupiedSlots;
  private Notifier notifier;

  private ParkingLot(int id, int numberOfSlots) {
    this.id = id;
    this.numberOfSlots = numberOfSlots;
    this.occupiedSlots = 0;
    this.notifier = null;
  }

  public static ParkingLot createParkingLot(int id, int numberOfSlots) throws NegativeSlotsException {
    if (numberOfSlots < 0) {
      throw new NegativeSlotsException(numberOfSlots);
    }

    return new ParkingLot(id, numberOfSlots);
  }

  public void acceptNotifier(Notifier notifier) {
    this.notifier = notifier;
  }

  public int park() throws NoSlotAvailableException {
    if (this.isFull()) {
      throw new NoSlotAvailableException();
    }

    this.occupiedSlots++;
    this.informNotifier();
    return this.occupiedSlots;
  }

  private void informNotifier() {
    if (this.isFull()) {
      this.notifier.notifyFull(this.id);
    }

    if (this.isEightyPercentFull()) {
      this.notifier.notifyEightyPercent(this.id);
    }

    if (this.isWithinTwentyPercent()) {
      this.notifier.notifyTwentyPercent(this.id);
    }
  }

  private boolean isWithinTwentyPercent() {
    double twentyPercent = 20;
    return this.occupiedSlotsInPercent() <= twentyPercent;
  }

  private boolean isEightyPercentFull() {
    double eightyPercent = 80;
    return this.occupiedSlotsInPercent() >= eightyPercent;
  }

  private int occupiedSlotsInPercent() {
    return (this.occupiedSlots / this.numberOfSlots) * 100;
  }

  private boolean isFull() {
    return this.numberOfSlots == this.occupiedSlots;
  }
}
