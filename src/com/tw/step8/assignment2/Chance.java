package com.tw.step8.assignment2;

import com.tw.step8.assignment2.exceptions.IllegalProbabilityException;

public class Chance {

  private final double probability;

  private Chance(double probability) {
    this.probability = probability;
  }

  public static Chance createChance(double probability) throws IllegalProbabilityException {
    if (probability < 0 || probability > 1) {
      throw new IllegalProbabilityException(probability);
    }

    return new Chance(probability);
  }

  public Chance notGettingAChance() {
    return new Chance(1 - probability);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Chance chance = (Chance) o;

    return Double.compare(chance.probability, probability) == 0;
  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(probability);
    return (int) (temp ^ (temp >>> 32));
  }
}
