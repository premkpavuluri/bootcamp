package com.tw.step8.assignment5.exceptions;

import com.tw.step8.assignment5.Color;

public class CannotAddBallException extends Throwable {
  private final Color ballColor;

  public CannotAddBallException(Color ballColor) {
    super();
    this.ballColor = ballColor;
  }

  @Override
  public String getMessage() {
    return String.format("Cannot add ball of %s color", ballColor);
  }
}
