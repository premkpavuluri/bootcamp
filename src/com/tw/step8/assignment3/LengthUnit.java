package com.tw.step8.assignment3;

public enum LengthUnit {
  FOOT(30.48), INCH(2.54), CM(1), MM(0.1);

  private final double centimeters;

  LengthUnit(double centimeters) {
    this.centimeters = centimeters;
  }

  public double equivalentCentimeter() {
    return centimeters;
  }
}
