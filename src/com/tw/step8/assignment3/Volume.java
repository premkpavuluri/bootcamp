package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exceptions.NegativeMagnitudeException;

public class Volume {
  private final double value;
  private final VolumeUnit volumeUnit;

  public Volume(double value, VolumeUnit volumeUnit) {
    this.value = value;
    this.volumeUnit = volumeUnit;
  }

  public static Volume createVolume(double value, VolumeUnit volumeUnit) throws NegativeMagnitudeException {
    if (value < 0) {
      throw new NegativeMagnitudeException(value);
    }

    return new Volume(value, volumeUnit);
  }

  public ComparisonResult compare(Volume otherVolume) {
    double difference = this.inLiters() - otherVolume.inLiters();

    if (difference == 0) {
      return ComparisonResult.EQUAL;
    }

    return difference < 0 ? ComparisonResult.LESSER : ComparisonResult.GREATER;
  }

  private double inLiters() {
    return this.volumeUnit.toBaseUnit() * this.value;
  }

  public Volume add(Volume otherVolume, VolumeUnit resultUnit) throws NegativeMagnitudeException {
    double sumInLiters = this.inLiters() + otherVolume.inLiters();
    double sumInResultUnit = sumInLiters / resultUnit.toBaseUnit();

    return createVolume(sumInResultUnit, resultUnit);
  }

  public boolean isWithinDelta(Volume otherVolume, double delta) {
    return Math.abs(this.value - otherVolume.value) < delta;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Volume volume = (Volume) o;

    if (Double.compare(volume.value, value) != 0) return false;
    return volumeUnit == volume.volumeUnit;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(value);
    result = (int) (temp ^ (temp >>> 32));
    result = 31 * result + volumeUnit.hashCode();
    return result;
  }
}
