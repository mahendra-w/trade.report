package com.mahe.trade.report;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import com.mahe.trade.entity.Trade;
import com.mahe.trade.util.DateFunction;

public class DateFunctionTest {

  @Test
  public void dateFunction() {
    Trade t = TradeGenerator.getTrade();
    t.setCurrency("AED");
    LocalDate friday = LocalDate.of(2018, 10, 19); // 19th Oct is Friday.
    LocalDate sunday = LocalDate.of(2018, 10, 21);
    t.setSettleDate(friday);

    DateFunction.adjustedSettleDate(t);
    // Settle Date and Adjusted Date should not be same.
    Assert.assertFalse(friday.equals(t.getAdjustedSettleDate()));

    // Settle Date should move to Sunday.
    Assert.assertTrue(sunday.equals(t.getAdjustedSettleDate()));
    Assert.assertTrue(t.getAdjustedSettleDate().getDayOfWeek().equals(DayOfWeek.SUNDAY));
  }

  @Test
  public void dateFunction2() {
    Trade t = TradeGenerator.getTrade();
    t.setCurrency("SGP");
    LocalDate friday = LocalDate.of(2018, 10, 19); // 19th Oct is Friday.
    t.setSettleDate(friday);

    DateFunction.adjustedSettleDate(t);
    Assert.assertTrue(t.getAdjustedSettleDate().equals(friday));
  }
}
