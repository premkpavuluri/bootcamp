package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exceptions.NegativeMagnitudeException;

public class Length {
  private final double value;
  private final LengthUnit unit;

  private Length(double value, LengthUnit lengthUnit) {
    this.value = value;
    this.unit = lengthUnit;
  }

  public static Length createLength(double value, LengthUnit lengthUnit) throws NegativeMagnitudeException {
    if (value < 0) {
      throw new NegativeMagnitudeException(value);
    }

    return new Length(value, lengthUnit);
  }

  public int compare(Length otherLength) {
    double difference = this.inCentimeters() - otherLength.inCentimeters();

    if (difference == 0) {
      return 0;
    }

    return difference < 0 ? -1 : 1;
  }

  private double inCentimeters() {
    return this.unit.toBaseUnit() * this.value;
  }

  public Length add(Length otherLength) throws NegativeMagnitudeException {
    LengthUnit standardResultUnit = LengthUnit.INCH;

    double sumInCms = this.inCentimeters() + otherLength.inCentimeters();
    double sumInInches = sumInCms / standardResultUnit.toBaseUnit();

    return createLength(sumInInches, standardResultUnit);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Length that = (Length) o;

    if (Double.compare(that.value, value) != 0) return false;
    return unit == that.unit;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(value);
    result = (int) (temp ^ (temp >>> 32));
    result = 31 * result + unit.hashCode();
    return result;
  }
}
