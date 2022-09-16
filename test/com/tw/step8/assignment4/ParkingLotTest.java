package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exceptions.NegativeSlotsException;
import com.tw.step8.assignment4.exceptions.NoSlotAvailableException;
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

    assertEquals(1, parkingLot.park());
  }

  @Test
  void shouldReturnTrueIfLotIsFull() throws NegativeSlotsException, NoSlotAvailableException {
    ParkingLot parkingLot = ParkingLot.createParkingLot(1);
    parkingLot.park();

    assertTrue(parkingLot.isFull());
  }

  @Test
  void shouldThrowNoSlotAvailableExceptionIfLotIsFull() throws NegativeSlotsException {
    ParkingLot parkingLot = ParkingLot.createParkingLot(0);
    assertThrows(NoSlotAvailableException.class, parkingLot::park);
  }
}