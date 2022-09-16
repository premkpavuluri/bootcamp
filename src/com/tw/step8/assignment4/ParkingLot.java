package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exceptions.NegativeSlotsException;
import com.tw.step8.assignment4.exceptions.NoSlotAvailableException;

public class ParkingLot {
  private final int numberOfSlots;
  private int occupiedSlots;

  private ParkingLot(int numberOfSlots) {
    this.numberOfSlots = numberOfSlots;
    this.occupiedSlots = 0;
  }

  public static ParkingLot createParkingLot(int numberOfSlots) throws NegativeSlotsException {
    if (numberOfSlots < 0) {
      throw new NegativeSlotsException(numberOfSlots);
    }

    return new ParkingLot(numberOfSlots);
  }

  public int park() throws NoSlotAvailableException {
    if (this.isFull()) {
      throw new NoSlotAvailableException();
    }

    this.occupiedSlots++;
    return this.occupiedSlots;
  }

  public boolean isFull() {
    return this.numberOfSlots == this.occupiedSlots;
  }
}
