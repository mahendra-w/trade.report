package com.mahe.trade.report.templates;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.mahe.trade.entity.Trade;
import com.mahe.unil.enums.TradeType;

public class SettlementReport implements Report {

  private Map<LocalDate, Double> incomingTrade = new HashMap<>();
  private Map<LocalDate, Double> outgoingTrade = new HashMap<>();

  /**
   * Add this trade to report. It updates the settle amount based on settle date.
   */
  public void addTrade(final Trade trade) {
    if (TradeType.BUY.equals(trade.getTradeType())) {
      Double settleAmt = outgoingTrade.get(trade.getAdjustedSettleDate());
      if (Objects.isNull(settleAmt)) {
        settleAmt = trade.getUsdPrice();
      } else {
        settleAmt = settleAmt + trade.getUsdPrice();
      }
      outgoingTrade.put(trade.getAdjustedSettleDate(), settleAmt);
    } else {
      Double settleAmt = incomingTrade.get(trade.getAdjustedSettleDate());
      if (Objects.isNull(settleAmt)) {
        settleAmt = trade.getUsdPrice();
      } else {
        settleAmt = settleAmt + trade.getUsdPrice();
      }
      incomingTrade.put(trade.getAdjustedSettleDate(), settleAmt);
    }
  }

  /**
   * This method prints the report. I have added sleep call to make sure that output is in readable
   * format and not overlapping with each other.
   */
  public void printReport() {
    printHeader();
    sleep(1000);
    System.err.println("-----INCOMING TRADE SELLEMENT REPORT-----");

    incomingTrade.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
      System.out.println(entry.getKey() + "\t\t" + entry.getValue());
    });

    sleep(500);
    System.err.println("-----OUTGOING TRADE SELLEMENT REPORT-----");
    outgoingTrade.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
      System.out.println(entry.getKey() + "\t\t" + entry.getValue());
    });
  }

  @Override
  public void printHeader() {
    System.err.println("--------PRINTING SETTLEMENT REPORT------------");
  }
}
