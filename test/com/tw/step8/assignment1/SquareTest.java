package com.tw.step8.assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
  @Test
  void calculateAreaOfSquare() {
    Square square = new Square(2);

    double actual = square.area();
    double expected = 4;

    assertEquals(expected,actual);
  }

  @Test
  void calculatePerimeterOfSquare() {
    Square square = new Square(2);
    double actual = square.perimeter();
    double expected = 8;

    assertEquals(expected,actual);
  }
}
