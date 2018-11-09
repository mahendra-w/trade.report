package com.mahe.trade.report;

import java.util.List;
import java.util.Queue;

import com.mahe.trade.entity.Trade;
import com.mahe.trade.pricer.Pricer;
import com.mahe.trade.pricer.PricerFactory;
import com.mahe.trade.report.templates.Report;
import com.mahe.trade.util.DateFunction;

public class ReportGenerator {

  private Queue<Trade> queue;
  private List<Report> reportsToGenerate;

  public ReportGenerator(final Queue<Trade> queue, final List<Report> reportsToGenerate) {
    this.queue = queue;
    this.reportsToGenerate = reportsToGenerate;
  }

  public void generateReport() {
    Trade t = null;
    while ((t = queue.poll()) != null) {
      Pricer pricer = PricerFactory.getPricer(t);
      pricer.price(t);
      DateFunction.adjustedSettleDate(t);
      final Trade trade = t;
      reportsToGenerate.stream().forEach(report -> {
        report.addTrade(trade);
      });
    }
  }
}
