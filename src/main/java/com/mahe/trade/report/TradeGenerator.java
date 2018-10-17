package com.mahe.trade.report;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.mahe.trade.entity.Trade;
import com.mahe.trade.entity.Trade.TradeBuilder;
import com.mahe.unil.enums.Entities;
import com.mahe.unil.enums.TradeType;

public class TradeGenerator {

  public static final Random RANDOM = new Random();

  public static final List<String> CURRENCY_LIST =
      Arrays.asList("USD", "GBP", "EUR", "AED", "SAR", "SGP", "INR", "HKD", "JPY", "AUD");

  /**
   * This method generated random entities for trade report.
   * 
   * @return
   */
  public static String getNextEntity() {
    Entities[] entities = Entities.values();
    return entities[RANDOM.nextInt(entities.length)].toString();
  }

  /**
   * Returns random Buy/Sell.
   * 
   * @return
   */
  public static TradeType getBuySell() {
    if (RANDOM.nextBoolean()) {
      return TradeType.BUY;
    } else {
      return TradeType.SALE;
    }
  }

  /**
   * This returns random currency from list of currency.
   * 
   * @return
   */
  public static String getNextCurrency() {
    return CURRENCY_LIST.get(RANDOM.nextInt(CURRENCY_LIST.size() - 1));
  }

  /**
   * This returns random date from next 7 days.
   * 
   * @return
   */
  public static LocalDate getNextDate() {
    return LocalDate.now().plus(RANDOM.nextInt(7), ChronoUnit.DAYS);
  }

  /**
   * This method generates Trade object with Random but correct values.
   * 
   * @return
   */
  public static Trade getTrade() {
    LocalDate insDate = getNextDate();
    TradeBuilder tb = new TradeBuilder();
    tb.setEntity(getNextEntity()).setTradeType(getBuySell()).setFx(RANDOM.nextDouble())
        .setCurrency(getNextCurrency()).setInstructionDate(insDate)
        .setSettleDate(insDate.plus(RANDOM.nextInt(3), ChronoUnit.DAYS))
        .setUnits(RANDOM.nextInt(1000)).setUnitPrice(RANDOM.nextDouble() * 100);

    return tb.build();
  }
}
