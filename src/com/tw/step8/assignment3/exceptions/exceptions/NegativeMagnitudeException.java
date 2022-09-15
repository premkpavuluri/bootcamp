package com.tw.step8.assignment3.exceptions.exceptions;

public class NegativeMagnitudeException extends Throwable {
  private final double magnitude;

  public NegativeMagnitudeException(double magnitude) {
    super();
    this.magnitude = magnitude;
  }

  @Override
  public String getMessage() {
    return String.format("Provided negative magnitude %f", magnitude);
  }
}
