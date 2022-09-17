package com.tw.step8.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {

  @Test
  void shouldAddObserver() {
    Notifier notifier = new Notifier();

    Observer observer = new Observer() {
      @Override
      public void observe(int lotId, Event notification) {
      }

      @Override
      public Event getSubscribedEvent() {
        return null;
      }
    };

    assertTrue(notifier.addObserver(observer));
  }

  @Test
  void shouldNotifySubscriberWhenLotIsEightyPercentFull() {
    Notifier notifier = new Notifier();
    final int[] actualLotId = new int[1];
    final Event[] actualEvent = new Event[1];
    Observer lotManager = new Observer() {
      @Override
      public void observe(int lotId, Event event) {
        actualLotId[0] = lotId;
        actualEvent[0] = event;
      }

      @Override
      public Event getSubscribedEvent() {
        return Event.LOT_ABOVE_EIGHTY;
      }
    };
    notifier.addObserver(lotManager);
    int expectedLotId = 1;
    Event expectedEvent = Event.LOT_ABOVE_EIGHTY;

    notifier.notifyEightyPercent(1);

    assertEquals(expectedLotId, actualLotId[0]);
    assertEquals(expectedEvent, actualEvent[0]);
  }

  @Test
  void shouldNotifySubscriberWhenLotIsWithinTwentyPercentFull() {
    Notifier notifier = new Notifier();
    final int[] actualLotId = new int[1];
    final Event[] actualEvent = new Event[1];
    Observer attendant = new Observer() {
      @Override
      public void observe(int lotId, Event event) {
        actualLotId[0] = lotId;
        actualEvent[0] = event;
      }

      @Override
      public Event getSubscribedEvent() {
        return Event.LOT_WITHIN_TWENTY;
      }
    };
    notifier.addObserver(attendant);
    int expectedLotId = 1;
    Event expectedEvent = Event.LOT_WITHIN_TWENTY;

    notifier.notifyTwentyPercent(1);

    assertEquals(expectedLotId, actualLotId[0]);
    assertEquals(expectedEvent, actualEvent[0]);
  }

  @Test
  void shouldNotifySubscriberWhenLotIsFull() {
    Notifier notifier = new Notifier();
    final int[] actualLotId = new int[1];
    final Event[] actualEvent = new Event[1];
    Observer attendant = new Observer() {
      @Override
      public void observe(int lotId, Event event) {
        actualLotId[0] = lotId;
        actualEvent[0] = event;
      }

      @Override
      public Event getSubscribedEvent() {
        return Event.LOT_FULL;
      }
    };
    notifier.addObserver(attendant);
    int expectedLotId = 1;
    Event expectedEvent = Event.LOT_FULL;

    notifier.notifyFull(1);

    assertEquals(expectedLotId, actualLotId[0]);
    assertEquals(expectedEvent, actualEvent[0]);
  }
}