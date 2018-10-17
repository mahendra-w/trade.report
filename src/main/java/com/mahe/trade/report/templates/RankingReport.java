package com.mahe.trade.report.templates;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.mahe.trade.entity.Trade;
import com.mahe.unil.enums.TradeType;

public class RankingReport implements Report {

  private Map<String, Double> incoming = new HashMap<>();
  private Map<String, Double> outgoing = new HashMap<>();

  /**
   * This method ranks entity based on its USD price amount received.
   */
  @Override
  public void addTrade(final Trade trade) {
    if (TradeType.BUY.equals(trade.getTradeType())) {
      Double amt = outgoing.get(trade.getEntity());
      if (Objects.isNull(amt)) {
        amt = trade.getUsdPrice();
      } else {
        amt = amt + trade.getUsdPrice();
      }
      outgoing.put(trade.getEntity(), amt);
    } else {
      Double amt = incoming.get(trade.getEntity());
      if (Objects.isNull(amt)) {
        amt = trade.getUsdPrice();
      } else {
        amt = amt + trade.getUsdPrice();
      }
      incoming.put(trade.getEntity(), amt);
    }

  }

  /**
   * This method prints the report. I have added sleep call to make sure that output is in readable
   * format and not overlapping with each other.
   */
  @Override
  public void printReport() {
    printHeader();
    sleep(1000);
    System.out.println();
    System.err.println("--------Outgoing Ranking------------");

    outgoing.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .forEach(entry -> {
          System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        });

    sleep(500);
    System.out.println();
    System.err.println("--------Incoming Ranking------------");

    incoming.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .forEach(entry -> {
          System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        });

    System.out.println();
    System.out.println();
  }

  @Override
  public void printHeader() {
    System.err.println("--------PRINTING RANKING REPORT------------");
  }

}
