package com.tw.step8.assignment2;

import com.tw.step8.assignment2.exceptions.IllegalProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

  @Test
  void shouldThrowExceptionIfProbabilityIsGreaterThanOne() {
    assertThrows(IllegalProbabilityException.class, () -> Chance.createChance(1.1));
  }

  @Test
  void shouldThrowExceptionIfProbabilityIsLessThanZero() {
    assertThrows(IllegalProbabilityException.class, () -> Chance.createChance(-1));
  }

  @Test
  void shouldGiveProbabilityOfNotGettingAChance() throws IllegalProbabilityException {
    Chance chance = Chance.createChance(0.1);

    Chance actual = chance.not();
    Chance expected = Chance.createChance(0.9);

    assertEquals(actual, expected);
  }

  @Test
  void andOfTwoChances() throws IllegalProbabilityException {
    Chance firstCoinChance = Chance.createChance(0.1);
    Chance secondCoinChance = Chance.createChance(0.3);

    Chance actual = firstCoinChance.and(secondCoinChance);
    Chance expected = Chance.createChance(0.03);

    assertEquals(actual, expected);
  }

  @Test
  void orOfTwoChances() throws IllegalProbabilityException {
    Chance firstChance = Chance.createChance(0.3);
    Chance secondChance = Chance.createChance(0.1);

    Chance actual = firstChance.or(secondChance);
    Chance expected = Chance.createChance(0.37);

    assertEquals(expected, actual);
  }
}