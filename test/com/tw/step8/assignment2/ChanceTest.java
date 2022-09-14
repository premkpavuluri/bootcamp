package com.tw.step8.assignment2;

import com.tw.step8.assignment2.exceptions.IllegalProbabilityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

  @Test
  void shouldThrowExceptionIfIllegalProbabilityProvided() {
    try {
      Chance.createChance(1.1);
      fail();
    } catch (IllegalProbabilityException e) {
      String expected = String.format("Provided illegal probability 1.1");
      assertEquals(expected, e.getMessage());
    }
  }

  @Test
  void shouldGiveProbabilityOfNotGettingAChance() throws IllegalProbabilityException {
    Chance chance = Chance.createChance(0.1);

    Chance actual = chance.notGettingAChance();
    Chance expected = Chance.createChance(0.9);

    assertTrue(actual.equals(expected));
  }
}