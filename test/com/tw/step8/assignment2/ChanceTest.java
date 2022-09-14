package com.tw.step8.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
  @Test
  void shouldGiveProbabilityOfGettingAChance() {
    Chance chance = new Chance(0.1);

    double actual = chance.probability();
    double expected = 0.1;

    assertEquals(expected,actual);
  }

  @Test
  void shouldGiveProbabilityOfNotGettingAChance() {
    Chance chance = new Chance(0.1);

    double actual = chance.improbability();
    double expected = 0.9;

    assertEquals(expected,actual);
  }
}