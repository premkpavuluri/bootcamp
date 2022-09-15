package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exceptions.exceptions.NegativeMagnitudeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

  @Test
  void shouldThrowNegativeLengthExceptionIfNegativeLengthIsProvided() {
    assertThrows(NegativeMagnitudeException.class, () -> Length.createLength(-1, LengthUnit.INCH));
  }

  @Test
  void shouldCompareEqualLengths() throws NegativeMagnitudeException {
    Length lengthInFeet = Length.createLength(1, LengthUnit.FOOT);
    Length lengthInInches = Length.createLength(12, LengthUnit.INCH);

    assertEquals(0, lengthInFeet.compare(lengthInInches));
  }

  @Test
  void shouldCompareWhenFirstLengthIsGreaterThanSecondLength() throws NegativeMagnitudeException {
    Length lengthInFeet = Length.createLength(2, LengthUnit.FOOT);
    Length lengthInInches = Length.createLength(12, LengthUnit.INCH);

    assertEquals(1, lengthInFeet.compare(lengthInInches));
  }

  @Test
  void shouldCompareWhenFirstLengthIsLesserThanSecondLength() throws NegativeMagnitudeException {
    Length lengthInFeet = Length.createLength(1, LengthUnit.FOOT);
    Length lengthInInches = Length.createLength(20, LengthUnit.INCH);

    assertEquals(-1, lengthInFeet.compare(lengthInInches));
  }

  @Test
  void shouldAddTwoLengthsOfDifferentUnitsInInches() throws NegativeMagnitudeException {
    Length lengthInFeet = Length.createLength(1, LengthUnit.FOOT);
    Length lengthInInches = Length.createLength(20, LengthUnit.INCH);

    Length expectedLength = Length.createLength(32, LengthUnit.INCH);

    assertEquals(expectedLength, lengthInFeet.add(lengthInInches));
  }
}