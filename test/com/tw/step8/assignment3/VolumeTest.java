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

    assertEquals(ComparisonResult.EQUAL, volumeInLiters.compare(volumeInGallons));
  }

  @Test
  void shouldCompareWhenFirstVolumeIsGreaterThanSecondVolume() throws NegativeMagnitudeException {
    Volume volumeInLiters = Volume.createVolume(4, VolumeUnit.LITER);
    Volume volumeInGallons = Volume.createVolume(1, VolumeUnit.GALLON);

    assertEquals(ComparisonResult.GREATER, volumeInLiters.compare(volumeInGallons));
  }

  @Test
  void shouldCompareWhenFirstVolumeIsLesserThanSecondVolume() throws NegativeMagnitudeException {
    Volume volumeInLiters = Volume.createVolume(1, VolumeUnit.LITER);
    Volume volumeInGallons = Volume.createVolume(1, VolumeUnit.GALLON);

    assertEquals(ComparisonResult.LESSER, volumeInLiters.compare(volumeInGallons));
  }

  @Test
  void shouldAddTwoVolumesOfDifferentUnitsInLiters() throws NegativeMagnitudeException {
    Volume volumeInLiters = Volume.createVolume(3.2, VolumeUnit.LITER);
    Volume volumeInGallons = Volume.createVolume(1, VolumeUnit.GALLON);

    Volume expectedVolume = Volume.createVolume(6.98, VolumeUnit.LITER);

    assertEquals(expectedVolume, volumeInLiters.add(volumeInGallons));
  }
}
