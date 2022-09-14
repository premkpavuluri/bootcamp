package com.tw.step8.assignment2;

public class Chance {

  private final double probability;

  public Chance(double probability) {
    this.probability = probability;
  }

  public double probability() {
    return probability;
  }

  public double improbability() {
    return 1 - probability;
  }
}
