package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeUnitTest {

  @Test
  void shouldProvideGallonInLiters() {
    assertEquals(3.78, VolumeUnit.GALLON.toBaseUnit());
  }
}