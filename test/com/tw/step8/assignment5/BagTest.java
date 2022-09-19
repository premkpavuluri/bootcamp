package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exceptions.CannotAddBallException;
import com.tw.step8.assignment5.exceptions.MaxCapacityExceededException;
import com.tw.step8.assignment5.exceptions.NegativeCapacityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
  @Test
  void shouldThrowNegativeCapacityException() {
    assertThrows(NegativeCapacityException.class, () -> Bag.createBag(-1));
  }

  @Test
  void shouldAddBallToBag() throws NegativeCapacityException, MaxCapacityExceededException, CannotAddBallException {
    Bag bag = Bag.createBag(12);

    assertTrue(bag.add(new Ball(1, Color.GREEN)));
  }

  @Test
  void shouldThrowMaxCapacityExceededExceptionWhenBagIsFull() throws NegativeCapacityException, MaxCapacityExceededException, CannotAddBallException {
    Bag bag = Bag.createBag(1);
    bag.add(new Ball(1, Color.GREEN));

    assertThrows(MaxCapacityExceededException.class, () -> bag.add(new Ball(2, Color.GREEN)));
  }

  @Test
  void shouldThrowMaxCapacityExceededExceptionIfMoreThanThreeGreenBallsAdded() throws NegativeCapacityException, MaxCapacityExceededException, CannotAddBallException {
    Bag bag = Bag.createBag(4);
    bag.add(new Ball(1, Color.GREEN));
    bag.add(new Ball(2, Color.GREEN));
    bag.add(new Ball(3, Color.GREEN));

    assertThrows(CannotAddBallException.class, () -> bag.add(new Ball(4, Color.GREEN)));
  }

  @Test
  void shouldThrowCannotAddBallExceptionIfRedBallsAreGreaterThanDoubleOfGreenBalls() throws NegativeCapacityException, CannotAddBallException, MaxCapacityExceededException {
    Bag bag = Bag.createBag(4);
    bag.add(new Ball(1, Color.GREEN));
    bag.add(new Ball(2, Color.RED));
    bag.add(new Ball(3, Color.RED));

    assertThrows(CannotAddBallException.class, () -> bag.add(new Ball(4, Color.RED)));
  }

  @Test
  void shouldThrowCannotAddBallExceptionWhenAddingYellowBallIfFortyPercentOfBallsAreYellow() throws NegativeCapacityException, CannotAddBallException, MaxCapacityExceededException {
    Bag bag = Bag.createBag(4);
    bag.add(new Ball(1, Color.GREEN));

    assertThrows(CannotAddBallException.class, () -> bag.add(new Ball(2, Color.YELLOW)));
  }

  @Test
  void shouldThrowCannotAddBallExceptionWhenTryToAddBlackBallIfBlueBallIsPresent() throws NegativeCapacityException, CannotAddBallException, MaxCapacityExceededException {
    Bag bag = Bag.createBag(5);
    bag.add(new Ball(1, Color.BLUE));

    assertThrows(CannotAddBallException.class, () -> bag.add(new Ball(2, Color.BLACK)));
  }

  @Test
  void shouldThrowCannotAddBallExceptionWhenTryToAddBlueBallIfBlackBallIsPresent() throws NegativeCapacityException, CannotAddBallException, MaxCapacityExceededException {
    Bag bag = Bag.createBag(5);
    bag.add(new Ball(1, Color.BLACK));

    assertThrows(CannotAddBallException.class, () -> bag.add(new Ball(2, Color.BLUE)));
  }
}