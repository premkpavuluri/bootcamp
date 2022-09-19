package com.tw.step8.assignment5;

public class Ball {
  private final int id;
  private final Color color;

  public Ball(int id, Color color) {
    this.id = id;
    this.color = color;
  }

  public boolean isOfSameColor(Color color) {
    return this.color == color;
  }
}
