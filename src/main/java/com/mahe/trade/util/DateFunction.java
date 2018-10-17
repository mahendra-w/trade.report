package com.mahe.trade.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import com.mahe.trade.entity.Trade;

public class DateFunction {

  private static final Map<String, DayOfWeek> SPECIAL_CCY = new HashMap<>();

  static {
    SPECIAL_CCY.put("AED", DayOfWeek.SUNDAY);
    SPECIAL_CCY.put("SAR", DayOfWeek.SUNDAY);
  }

  public static void setAdjustedSettleDate(final Trade trade) {
    LocalDate settleDate = trade.getSettleDate();
    DayOfWeek settleDay = settleDate.getDayOfWeek();
    int delta = 0;
    if (SPECIAL_CCY.containsKey(trade.getCurrency().toUpperCase())) {
      if (settleDay.equals(DayOfWeek.FRIDAY)) {
        delta = 2;
      } else if (settleDay.equals(DayOfWeek.SATURDAY)) {
        delta = 1;
      }
    } else {
      if (settleDay.equals(DayOfWeek.SATURDAY)) {
        delta = 2;
      } else if (settleDay.equals(DayOfWeek.SUNDAY)) {
        delta = 1;
      }
    }
    trade.setAdjustedSettleDate(settleDate.plus(delta, ChronoUnit.DAYS));

    System.out.println(trade);
  }
}
