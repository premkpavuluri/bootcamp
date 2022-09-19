package com.tw.step8.assignment5;

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
    if(maxCapacity < 0) {
      throw new NegativeCapacityException(maxCapacity);
    }

    return new Bag(maxCapacity);
  }

  public boolean add(Ball ball) throws MaxCapacityExceededException {
    if(isFull()) {
     throw new MaxCapacityExceededException();
    }

    if(ball.isOfSameColor(Color.GREEN) && hasMaxBallsOf(Color.GREEN,3)) {
      throw new MaxCapacityExceededException();
    }

    return this.balls.add(ball);
  }

  private boolean hasMaxBallsOf(Color color, int capacity) {
    long ballCount = this.balls.stream()
        .filter(ball -> ball.isOfSameColor(color))
        .count();

    System.out.println(ballCount);
    return ballCount >= capacity;
  }

  private boolean isFull() {
    return this.balls.size() >= this.maxCapacity;
  }
}
