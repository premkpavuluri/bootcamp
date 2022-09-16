package com.tw.step8.assignment4.exceptions;

public class NegativeSlotsException extends Throwable {
  private final int numberOfSlots;

  public NegativeSlotsException(int numberOfSlots) {
    super();
    this.numberOfSlots = numberOfSlots;
  }

  @Override
  public String getMessage() {
    return String.format("Provided negative number of slots %d", numberOfSlots);
  }
}
