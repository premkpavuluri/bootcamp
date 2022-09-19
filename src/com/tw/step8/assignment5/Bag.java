package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exceptions.CannotAddBallException;
import com.tw.step8.assignment5.exceptions.MaxCapacityExceededException;
import com.tw.step8.assignment5.exceptions.NegativeCapacityException;

import java.util.HashSet;

public class Bag {

  private final int maxCapacity;
  private final HashSet<Ball> balls;

  private Bag(int maxCapacity) {
    this.maxCapacity = maxCapacity;
    this.balls = new HashSet<Ball>();
  }


  public static Bag createBag(int maxCapacity) throws NegativeCapacityException {
    if (maxCapacity < 0) {
      throw new NegativeCapacityException(maxCapacity);
    }

    return new Bag(maxCapacity);
  }

  public boolean add(Ball ball) throws MaxCapacityExceededException, CannotAddBallException {
    if (isFull()) {
      throw new MaxCapacityExceededException();
    }

    if (ball.isOfSameColor(Color.GREEN) && hasMaxBallsOf(Color.GREEN, 3)) {
      throw new MaxCapacityExceededException();
    }

    if (ball.isOfSameColor(Color.RED) && isRedBallNotAllowedToAdd()) {
      throw new CannotAddBallException();
    }

    if (ball.isOfSameColor(Color.YELLOW) && isYellowBallNotAllowed()) {
      throw new CannotAddBallException();
    }

    return this.balls.add(ball);
  }

  private boolean isYellowBallNotAllowed() {
    int yellowBallCount = this.ballsOfColor(Color.YELLOW) + 1;

    return (this.balls.size() * 0.4) < yellowBallCount;
  }

  private boolean isRedBallNotAllowedToAdd() {
    int greenBallCount = ballsOfColor(Color.GREEN);
    int redBallCount = ballsOfColor(Color.RED);

    return (greenBallCount * 2) <= redBallCount;
  }

  private int ballsOfColor(Color color) {
    return (int) this.balls.stream()
        .filter(ball -> ball.isOfSameColor(color))
        .count();
  }

  private boolean hasMaxBallsOf(Color color, int capacity) {
    int ballCount = ballsOfColor(color);

    return ballCount >= capacity;
  }

  private boolean isFull() {
    return this.balls.size() >= this.maxCapacity;
  }
}
