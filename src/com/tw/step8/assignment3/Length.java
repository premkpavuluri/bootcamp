package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exceptions.exceptions.NegativeLengthException;

public class Length {
  private final int value;
  private final Unit unit;

  private Length(int value, Unit unit) {
    this.value = value;
    this.unit = unit;
  }

  public static Length createLength(int value, Unit unit) throws NegativeLengthException {
    if (value < 0) {
      throw new NegativeLengthException(value);
    }

    return new Length(value, unit);
  }

  public int compare(Length otherLength) {
    double difference = this.inCentimeters() - otherLength.inCentimeters();

    if (difference == 0) {
      return 0;
    }

    return difference < 0 ? -1 : 1;
  }

  private double inCentimeters() {
    return unit.equivalentCentimeter() * value;
  }
}
