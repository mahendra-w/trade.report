package com.mahe.trade.pricer;

import java.math.BigDecimal;
import java.math.MathContext;

import com.mahe.trade.entity.Trade;

public class USDPricer implements Pricer {

  public void price(final Trade trade) {
    BigDecimal pricePerUnit = new BigDecimal(trade.getUnitPrice());
    BigDecimal fx = new BigDecimal(trade.getFx());

    BigDecimal usdPrice = pricePerUnit.multiply(fx, MathContext.DECIMAL128)
        .multiply(new BigDecimal(Double.valueOf(trade.getUnits())), MathContext.DECIMAL128);

    trade.setUsdPrice(usdPrice.doubleValue());
  }
}
