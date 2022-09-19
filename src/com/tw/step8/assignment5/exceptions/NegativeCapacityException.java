package com.tw.step8.assignment5.exceptions;

public class NegativeCapacityException extends Throwable {
  private final int maxCapacity;

  public NegativeCapacityException(int maxCapacity) {
    super();
    this.maxCapacity = maxCapacity;
  }

  @Override
  public String getMessage() {
    return String.format("Invalid bag capacity %d", this.maxCapacity);
  }
}
