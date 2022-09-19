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
    if(this.balls.size() >= this.maxCapacity) {
     throw new MaxCapacityExceededException();
    }

    return this.balls.add(ball);
  }
}
