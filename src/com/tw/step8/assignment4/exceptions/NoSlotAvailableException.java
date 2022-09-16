package com.tw.step8.assignment4.exceptions;

public class NoSlotAvailableException extends Throwable{
  public NoSlotAvailableException() {
    super();
  }

  @Override
  public String getMessage() {
    return "Parking lot is full";
  }
}
