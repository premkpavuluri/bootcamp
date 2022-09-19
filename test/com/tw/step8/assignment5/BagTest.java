package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exceptions.MaxCapacityExceededException;
import com.tw.step8.assignment5.exceptions.NegativeCapacityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
  @Test
  void shouldThrowNegativeCapacityException() {
    assertThrows(NegativeCapacityException.class, (Executable) () -> {
      Bag bag = Bag.createBag(-1);
    });
  }

  @Test
  void shouldAddBallToBag() throws NegativeCapacityException, MaxCapacityExceededException {
    Bag bag = Bag.createBag(12);

    assertTrue(bag.add(new Ball(1)));
  }

  @Test
  void shouldThrowMaxCapacityExceededExceptionWhenBagIsFull() throws NegativeCapacityException, MaxCapacityExceededException {
    Bag bag = Bag.createBag(1);
    bag.add(new Ball(1));

    assertThrows(MaxCapacityExceededException.class, () -> bag.add(new Ball(2)));
  }
}