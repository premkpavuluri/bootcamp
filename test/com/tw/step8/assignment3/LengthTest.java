package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
  @Test
  void shouldCompareEqualLengths() {
    Length lengthInFeet = new Length(1, Unit.FOOT);
    Length lengthInInches = new Length(12, Unit.INCH);

    assertEquals(0,lengthInFeet.compare(lengthInInches));
  }

  @Test
  void shouldCompareWhenFirstLengthIsGreaterThanSecondLength() {
    Length lengthInFeet = new Length(2, Unit.FOOT);
    Length lengthInInches = new Length(12, Unit.INCH);

    assertEquals(1,lengthInFeet.compare(lengthInInches));
  }

  @Test
  void shouldCompareWhenFirstLengthIsLesserThanSecondLength() {
    Length lengthInFeet = new Length(1, Unit.FOOT);
    Length lengthInInches = new Length(20, Unit.INCH);

    assertEquals(-1,lengthInFeet.compare(lengthInInches));
  }
}