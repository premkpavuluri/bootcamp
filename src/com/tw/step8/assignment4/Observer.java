package com.tw.step8.assignment4;

public interface Observer {
  void observe(int lotId, Event event);
  Event getSubscribedEvent();
}
