package com.tw.step8.assignment4;

public enum Event {
  FULL,
  ABOVE_EIGHTY {
    @Override
    public String asString() {
      return "Parking lot is 80% full";
    }
  },
  WITHIN_TWENTY {
    @Override
    public String asString() {
      return "Parking lot is within 20%";
    }
  };

  public String asString() {
    return "Parking lot is full";
  }
}
