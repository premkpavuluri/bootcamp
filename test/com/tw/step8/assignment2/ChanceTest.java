package com.tw.step8.assignment2;

import com.tw.step8.assignment2.exceptions.IllegalProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

  @Test
  void shouldThrowExceptionIfProbabilityIsGreaterThanOne() {
    try {
      Chance.createChance(1.1);
      fail();
    } catch (IllegalProbabilityException e) {
      String expected = String.format("Provided illegal probability 1.1");
      assertEquals(expected, e.getMessage());
    }
  }

  @Test
  void shouldThrowExceptionIfProbabilityIsLessThanZero() {
    try {
      Chance.createChance(-1);
      fail();
    } catch (IllegalProbabilityException e) {
      String expected = String.format("Provided illegal probability -1.0");
      assertEquals(expected, e.getMessage());
    }
  }

  @Test
  void shouldGiveProbabilityOfNotGettingAChance() throws IllegalProbabilityException {
    Chance chance = Chance.createChance(0.1);

    Chance actual = chance.not();
    Chance expected = Chance.createChance(0.9);

    assertTrue(actual.equals(expected));
  }

  @Test
  void andOfTwoChances() throws IllegalProbabilityException {
    Chance firstCoinChance = Chance.createChance(0.1);
    Chance secondCoinChance  = Chance.createChance(0.3);

    Chance actual = firstCoinChance.and(secondCoinChance);
    Chance expected = Chance.createChance(0.03);

    assertTrue(actual.equals(expected));
  }
}