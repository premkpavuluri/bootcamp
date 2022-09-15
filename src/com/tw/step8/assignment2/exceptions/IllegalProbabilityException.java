package com.tw.step8.assignment2.exceptions;

public class IllegalProbabilityException extends Throwable {
  public IllegalProbabilityException(double probability) {
    super("Provided illegal probability " + probability);
  }
}
