package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exceptions.NegativeSlotsException;
import com.tw.step8.assignment4.exceptions.NoSlotAvailableException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
  @Test
  void shouldThrowNegativeSlotsExceptionIfNegativeSlotsProvided() {
    assertThrows(NegativeSlotsException.class, () -> ParkingLot.createParkingLot(-1));
  }

  @Test
  void shouldParkAVehicle() throws NegativeSlotsException, NoSlotAvailableException {
    ParkingLot parkingLot = ParkingLot.createParkingLot(5);
    parkingLot.acceptNotifier(new Notifier());

    assertEquals(1, parkingLot.park());
  }

  @Test
  void shouldThrowNoSlotAvailableExceptionIfLotIsFull() throws NegativeSlotsException {
    ParkingLot parkingLot = ParkingLot.createParkingLot(0);
    parkingLot.acceptNotifier(new Notifier());

    assertThrows(NoSlotAvailableException.class, parkingLot::park);
  }
}

























