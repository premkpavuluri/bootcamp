package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exceptions.NegativeSlotsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
  @Test
  void shouldThrowNegativeSlotsExceptionIfNegativeSlotsProvided() {
    assertThrows(NegativeSlotsException.class, () -> ParkingLot.createParkingLot(-1));
  }

}