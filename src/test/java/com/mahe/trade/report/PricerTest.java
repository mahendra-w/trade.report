package com.mahe.trade.report;

import org.junit.Assert;
import org.junit.Test;

import com.mahe.trade.entity.Trade;
import com.mahe.trade.pricer.USDPricer;

public class PricerTest {

  @Test
  public void usdPricer() {
    Trade t = TradeGenerator.getTrade();
    t.setFx(0.5);
    t.setUnitPrice(100.0);
    t.setUnits(100);

    USDPricer pricer = new USDPricer();
    pricer.price(t);
    Assert.assertEquals(new Double(0.5 * 100 * 100), t.getUsdPrice());
  }
}
