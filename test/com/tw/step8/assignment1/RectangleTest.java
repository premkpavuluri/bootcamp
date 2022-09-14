package com.tw.step8.assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
  @Test
  void calculateAreaOfRectangleOfEqualSides() {
    Rectangle rectangle = new Rectangle(1,1);

    double actual = rectangle.area();
    double expected = 1;

    assertEquals(expected,actual);
  }

  @Test
  void calculateAreaOfRectangleOfDifferentSides() {
    Rectangle rectangle = new Rectangle(2,3);

    double actual = rectangle.area();
    double expected = 6;

    assertEquals(expected,actual);
  }

  @Test
  void calculatePerimeterOfRectangleOfEqualSides() {
    Rectangle rectangle = new Rectangle(1, 1);
    double actual = rectangle.perimeter();
    double expected = 4;

    assertEquals(expected,actual);
  }

  @Test
  void calculatePerimeterOfRectangleOfDifferentSides() {
    Rectangle rectangle = new Rectangle(2,3);
    double actual = rectangle.perimeter();
    double expected = 10;

    assertEquals(expected,actual);
  }
}