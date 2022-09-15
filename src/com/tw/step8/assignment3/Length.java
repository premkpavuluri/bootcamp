package com.tw.step8.assignment3;

public class Length {
  private final int value;
  private final Unit unit;

  public Length(int value, Unit unit) {
    this.value = value;
    this.unit = unit;
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
