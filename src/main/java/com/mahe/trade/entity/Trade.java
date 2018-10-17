package com.mahe.trade.entity;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import com.mahe.unil.enums.TradeType;

public class Trade {

  private Integer tradeId;
  private String entity;
  private TradeType tradeType;
  private Double fx;
  private String currency;
  private LocalDate instructionDate;
  private LocalDate settleDate;
  private Integer units;
  private Double unitPrice;
  private Double usdPrice;
  private LocalDate adjustedSettleDate;

  public Trade(TradeBuilder tb) {
    this.tradeId = tb.tradeId;
    this.entity = tb.entity;
    this.tradeType = tb.tradeType;
    this.fx = tb.fx;
    this.currency = tb.currency;
    this.instructionDate = tb.instructionDate;
    this.settleDate = tb.settleDate;
    this.unitPrice = tb.unitPrice;
    this.units = tb.units;
  }

  public Integer getTradeId() {
    return tradeId;
  }

  public void setTradeId(Integer tradeId) {
    this.tradeId = tradeId;
  }

  public String getEntity() {
    return entity;
  }

  public void setEntity(String entity) {
    this.entity = entity;
  }

  public TradeType getTradeType() {
    return tradeType;
  }

  public void setTradeType(TradeType tradeType) {
    this.tradeType = tradeType;
  }

  public Double getFx() {
    return fx;
  }

  public void setFx(Double fx) {
    this.fx = fx;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public LocalDate getInstructionDate() {
    return instructionDate;
  }

  public void setInstructionDate(LocalDate instructionDate) {
    this.instructionDate = instructionDate;
  }

  public LocalDate getSettleDate() {
    return settleDate;
  }

  public void setSettleDate(LocalDate settleDate) {
    this.settleDate = settleDate;
  }

  public Integer getUnits() {
    return units;
  }

  public void setUnits(Integer units) {
    this.units = units;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Double getUsdPrice() {
    return usdPrice;
  }

  public void setUsdPrice(Double usdPrice) {
    this.usdPrice = usdPrice;
  }

  public LocalDate getAdjustedSettleDate() {
    return adjustedSettleDate;
  }

  public void setAdjustedSettleDate(LocalDate adjustedSettleDate) {
    this.adjustedSettleDate = adjustedSettleDate;
  }

  public String toString(int i) {
    StringBuilder sb = new StringBuilder();
    sb.append("tradeId=").append(tradeId).append(',').append("entity=").append(entity).append(',')
        .append("tradeType=").append(tradeType).append(',').append("fx=").append(fx).append(',')
        .append("currency=").append(currency).append(',').append("instructionDate=")
        .append(instructionDate).append(',').append("settleDate=").append(settleDate).append(',')
        .append("units=").append(units).append(',').append("unitPrice=").append(unitPrice)
        .append(',');
    return sb.toString();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(tradeId).append(',').append(entity).append(',').append(tradeType).append(',')
        .append(fx).append(',').append(currency).append(',').append(instructionDate).append(',')
        .append(settleDate).append(',').append(adjustedSettleDate).append(',').append(units)
        .append(',').append(unitPrice).append(',');
    return sb.toString();
  }


  public static class TradeBuilder {
    private static AtomicInteger tradeCounter = new AtomicInteger(1);
    private Integer tradeId;
    private String entity;
    private TradeType tradeType;
    private Double fx;
    private String currency;
    private LocalDate instructionDate;
    private LocalDate settleDate;
    private Integer units;
    private Double unitPrice;

    public TradeBuilder() {
      this.tradeId = tradeCounter.getAndIncrement();
    }

    public TradeBuilder setEntity(String entity) {
      this.entity = entity;
      return this;
    }

    public TradeBuilder setTradeType(TradeType tradeType) {
      this.tradeType = tradeType;
      return this;
    }

    public TradeBuilder setFx(Double fx) {
      this.fx = fx;
      return this;
    }

    public TradeBuilder setCurrency(String ccy) {
      this.currency = ccy;
      return this;
    }

    public TradeBuilder setInstructionDate(LocalDate insDate) {
      this.instructionDate = insDate;
      return this;
    }

    public TradeBuilder setSettleDate(LocalDate settleDate) {
      this.settleDate = settleDate;
      return this;
    }

    public TradeBuilder setUnits(Integer units) {
      this.units = units;
      return this;
    }

    public TradeBuilder setUnitPrice(Double unitPrice) {
      this.unitPrice = unitPrice;
      return this;
    }

    public Trade build() {
      Trade trade = new Trade(this);
      return trade;
    }

  }
}
