package com.tw.step8.assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
  @Test
  void area() {
    Rectangle rectangle = new Rectangle(1,1);

    double actual = rectangle.area();
    double expected = 1;

    assertEquals(expected,actual);
  }
}