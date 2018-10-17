package com.mahe.trade.pricer;

import com.mahe.trade.entity.Trade;

public interface Pricer {

  void price(Trade trade);

}
