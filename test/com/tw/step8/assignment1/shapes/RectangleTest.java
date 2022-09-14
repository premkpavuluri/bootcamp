package com.tw.step8.assignment1.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  @Test
  void shouldCreateRectangle() {
    assertTrue(Rectangle.createRectangle(1,2) instanceof Rectangle);
  }

  @Test
  void shouldCreateSquare() {
    assertTrue(Rectangle.createSquare(1) instanceof Rectangle);
  }

  @Test
  void calculateAreaOfRectangleOfEqualSides() {
    Rectangle rectangle = Rectangle.createRectangle(1, 1);

    double actual = rectangle.area();
    double expected = 1;

    assertEquals(expected, actual);
  }

  @Test
  void calculateAreaOfRectangleOfDifferentSides() {
    Rectangle rectangle = Rectangle.createRectangle(2, 3);

    double actual = rectangle.area();
    double expected = 6;

    assertEquals(expected, actual);
  }

  @Test
  void calculatePerimeterOfRectangleOfEqualSides() {
    Rectangle rectangle = Rectangle.createRectangle(1, 1);

    double actual = rectangle.perimeter();
    double expected = 4;

    assertEquals(expected, actual);
  }

  @Test
  void calculatePerimeterOfRectangleOfDifferentSides() {
    Rectangle rectangle = Rectangle.createRectangle(2, 3);
    double actual = rectangle.perimeter();
    double expected = 10;

    assertEquals(expected, actual);
  }
}