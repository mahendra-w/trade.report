package com.mahe.trade.pricer;

import java.util.HashMap;
import java.util.Map;

import com.mahe.trade.entity.Trade;

/**
 * Factory implementation for Pricer.
 * 
 * @author Mahendra
 *
 */
public final class PricerFactory {

  private static final Map<String, Pricer> PRICER_CACHE = new HashMap<>();

  static {
    PRICER_CACHE.put("USDPricer", new USDPricer());
  }

  /**
   * This method return parser. In case we have to add multiple parser in future, logic can be
   * implemented here to return parser based on trade attributes.
   * 
   * @param t
   * @return
   */
  public static Pricer getPricer(final Trade t) {
    return PRICER_CACHE.get("USDPricer");
  }
}
