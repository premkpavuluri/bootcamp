package com.tw.step8.assignment3;

public enum Unit {
  FOOT(30.48), INCH(2.54), CM(1);

  private final double centimeters;

  Unit(double centimeters) {
    this.centimeters = centimeters;
  }

  public double equivalentCentimeter() {
    return centimeters;
  }
}
