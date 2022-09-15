package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
  @Test
  void compareFeetAndInches() {
    Length lengthInFeet = new Length(1, Unit.FEET);
    Length lengthInInches = new Length(12, Unit.INCHES);

    assertEquals(0,lengthInFeet.compare(lengthInInches));
  }
}