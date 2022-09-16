package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exceptions.NegativeMagnitudeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {

  @Test
  void shouldThrowNegativeVolumeExceptionIfNegativeVolumeIsProvided() {
    assertThrows(NegativeMagnitudeException.class, () -> Volume.createVolume(-1, VolumeUnit.LITER));
  }

  @Test
  void shouldCompareEqualVolumes() throws NegativeMagnitudeException {
    Volume volumeInLiters = Volume.createVolume(3.78, VolumeUnit.LITER);
    Volume volumeInGallons = Volume.createVolume(1, VolumeUnit.GALLON);

    ComparisonResult actualVolume = volumeInLiters.compare(volumeInGallons);

    assertEquals(ComparisonResult.EQUAL, actualVolume);
  }

  @Test
  void shouldCompareWhenFirstVolumeIsGreaterThanSecondVolume() throws NegativeMagnitudeException {
    Volume volumeInLiters = Volume.createVolume(4, VolumeUnit.LITER);
    Volume volumeInGallons = Volume.createVolume(1, VolumeUnit.GALLON);

    ComparisonResult actualVolume = volumeInLiters.compare(volumeInGallons);

    assertEquals(ComparisonResult.GREATER, actualVolume);
  }

  @Test
  void shouldCompareWhenFirstVolumeIsLesserThanSecondVolume() throws NegativeMagnitudeException {
    Volume volumeInLiters = Volume.createVolume(1, VolumeUnit.LITER);
    Volume volumeInGallons = Volume.createVolume(1, VolumeUnit.GALLON);

    ComparisonResult actualVolume = volumeInLiters.compare(volumeInGallons);

    assertEquals(ComparisonResult.LESSER, actualVolume);
  }

  @Test
  void shouldAddTwoVolumesOfDifferentUnitsInLiters() throws NegativeMagnitudeException {
    Volume volumeInLiters = Volume.createVolume(3.2, VolumeUnit.LITER);
    Volume volumeInGallons = Volume.createVolume(1, VolumeUnit.GALLON);

    Volume expectedVolume = Volume.createVolume(6.98, VolumeUnit.LITER);
    Volume actualVolume = volumeInLiters.add(volumeInGallons, VolumeUnit.LITER);

    assertTrue(expectedVolume.isWithinDelta(actualVolume, 0.01));
  }

  @Test
  void shouldAddTwoVolumesOfDifferentUnitsInGallons() throws NegativeMagnitudeException {
    Volume volumeInLiters = Volume.createVolume(0, VolumeUnit.LITER);
    Volume volumeInGallons = Volume.createVolume(1, VolumeUnit.GALLON);

    Volume expectedVolume = Volume.createVolume(1.0, VolumeUnit.GALLON);
    Volume actualVolume = volumeInLiters.add(volumeInGallons, VolumeUnit.GALLON);

    assertTrue(expectedVolume.isWithinDelta(actualVolume, 0.01));
  }
}
