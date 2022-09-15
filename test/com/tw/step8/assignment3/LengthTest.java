package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exceptions.exceptions.NegativeLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

  @Test
  void shouldThrowNegativeLengthExceptionIfNegativeLengthIsProvided() {
    assertThrows(NegativeLengthException.class, () -> Length.createLength(-1, Unit.INCH));
  }

  @Test
  void shouldCompareEqualLengths() throws NegativeLengthException {
    Length lengthInFeet = Length.createLength(1, Unit.FOOT);
    Length lengthInInches = Length.createLength(12, Unit.INCH);

    assertEquals(0, lengthInFeet.compare(lengthInInches));
  }

  @Test
  void shouldCompareWhenFirstLengthIsGreaterThanSecondLength() throws NegativeLengthException {
    Length lengthInFeet = Length.createLength(2, Unit.FOOT);
    Length lengthInInches = Length.createLength(12, Unit.INCH);

    assertEquals(1, lengthInFeet.compare(lengthInInches));
  }

  @Test
  void shouldCompareWhenFirstLengthIsLesserThanSecondLength() throws NegativeLengthException {
    Length lengthInFeet = Length.createLength(1, Unit.FOOT);
    Length lengthInInches = Length.createLength(20, Unit.INCH);

    assertEquals(-1, lengthInFeet.compare(lengthInInches));
  }
}