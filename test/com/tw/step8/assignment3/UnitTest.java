package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

  @Test
  void shouldProvideFootInCentimeters() {
    assertEquals(30.48, Unit.FOOT.equivalentCentimeter());
  }

  @Test
  void shouldProvideInchInCentimeters() {
    assertEquals(2.54, Unit.INCH.equivalentCentimeter());
  }

  @Test
  void shouldProvideMillimeterInCentimeters() {
    assertEquals(0.1, Unit.MM.equivalentCentimeter());
  }
}