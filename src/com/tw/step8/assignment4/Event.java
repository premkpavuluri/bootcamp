package com.tw.step8.assignment4;

public enum Event {
  LOT_FULL,
  LOT_ABOVE_EIGHTY {
    @Override
    public String asString() {
      return "Parking lot is 80% full";
    }
  },
  LOT_WITHIN_TWENTY {
    @Override
    public String asString() {
      return "Parking lot is within 20%";
    }
  };

  public String asString() {
    return "Parking lot is full";
  }
}
