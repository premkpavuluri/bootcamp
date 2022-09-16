package com.tw.step8.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {

  @Test
  void shouldAddObserver() {
    Notifier notifier = new Notifier();

    Observer observer = new Observer() {
      @Override
      public void observe(String notification) {
      }

      @Override
      public Event getSubscribedEvent() {
        return null;
      }
    };

    assertTrue(notifier.addObserver(observer));
  }
}