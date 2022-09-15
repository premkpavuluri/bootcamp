package com.tw.step8.assignment3.exceptions.exceptions;

public class NegativeLengthException extends Throwable {
  private final int length;

  public NegativeLengthException(int length) {
    super();
    this.length = length;
  }

  @Override
  public String getMessage() {
    return String.format("Provided negative length %d", length);
  }
}
