package com.mahe.trade.report.templates;

import com.mahe.trade.entity.Trade;

public interface Report {

  void addTrade(Trade trade);

  void printReport();

  void printHeader();

  /**
   * making thread sleep so that output is in readable format.
   * 
   * @param millis
   */
  default void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {

    }
  }
}
