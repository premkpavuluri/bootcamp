package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

  @Test
  void shouldReturnTrueIfBallIsOfSameColor() {
    Ball ball = new Ball(1, Color.GREEN);

    assertTrue(ball.isOfSameColor(Color.GREEN));
  }
}