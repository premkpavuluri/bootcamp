package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exceptions.NegativeSlotsException;

public class ParkingLot {
  private final int numberOfSlots;

  private ParkingLot(int numberOfSlots) {
    this.numberOfSlots = numberOfSlots;
  }

  public static ParkingLot createParkingLot(int numberOfSlots) throws NegativeSlotsException {
    if (numberOfSlots < 0) {
      throw new NegativeSlotsException(numberOfSlots);
    }

    return new ParkingLot(numberOfSlots);
  }

}
