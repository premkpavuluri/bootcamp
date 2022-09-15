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

  public Chance not() throws IllegalProbabilityException {
    return Chance.createChance(1 - probability);
  }

  public Chance and(Chance anotherChance) throws IllegalProbabilityException {
    return Chance.createChance(this.probability * anotherChance.probability);
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

  public Chance or(Chance anotherChance) throws IllegalProbabilityException {
    Chance notOfFirst = this.not();
    Chance notOfSecond = anotherChance.not();
    Chance andOfBoth = notOfFirst.and(notOfSecond);

    return andOfBoth.not();
  }
}
