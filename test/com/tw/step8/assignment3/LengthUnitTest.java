package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthUnitTest {

  @Test
  void shouldProvideFootInCentimeters() {
    assertEquals(30.48, LengthUnit.FOOT.toBaseUnit());
  }

  @Test
  void shouldProvideInchInCentimeters() {
    assertEquals(2.54, LengthUnit.INCH.toBaseUnit());
  }

  @Test
  void shouldProvideMillimeterInCentimeters() {
    assertEquals(0.1, LengthUnit.MM.toBaseUnit());
  }
}