package com.tw.step8.assignment5.exceptions;

public class MaxCapacityExceededException extends Throwable {
  private final int maxCapacity;

  public MaxCapacityExceededException(int maxCapacity) {
    super();
    this.maxCapacity = maxCapacity;
  }

  @Override
  public String getMessage() {
    return String.format("Max capacity exceeded %d", this.maxCapacity);
  }
}
