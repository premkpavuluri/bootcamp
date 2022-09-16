package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exceptions.NegativeMagnitudeException;
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

    ComparisonResult actual = lengthInFeet.compare(lengthInInches);

    assertEquals(ComparisonResult.EQUAL, actual);
  }

  @Test
  void shouldCompareWhenFirstLengthIsGreaterThanSecondLength() throws NegativeMagnitudeException {
    Length lengthInFeet = Length.createLength(2, LengthUnit.FOOT);
    Length lengthInInches = Length.createLength(12, LengthUnit.INCH);

    ComparisonResult actual = lengthInFeet.compare(lengthInInches);

    assertEquals(ComparisonResult.GREATER, actual);
  }

  @Test
  void shouldCompareWhenFirstLengthIsLesserThanSecondLength() throws NegativeMagnitudeException {
    Length lengthInFeet = Length.createLength(1, LengthUnit.FOOT);
    Length lengthInInches = Length.createLength(20, LengthUnit.INCH);

    ComparisonResult actual = lengthInFeet.compare(lengthInInches);

    assertEquals(ComparisonResult.LESSER, actual);
  }

  @Test
  void shouldAddTwoLengthsOfDifferentUnitsInInches() throws NegativeMagnitudeException {
    Length lengthInFeet = Length.createLength(1, LengthUnit.FOOT);
    Length lengthInInches = Length.createLength(1, LengthUnit.INCH);

    Length expectedLength = Length.createLength(330.2, LengthUnit.MM);
    Length actual = lengthInFeet.add(lengthInInches, LengthUnit.MM);

    assertEquals(expectedLength, actual);
  }
}