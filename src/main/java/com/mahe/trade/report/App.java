package com.mahe.trade.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

import com.mahe.trade.entity.Trade;
import com.mahe.trade.report.templates.RankingReport;
import com.mahe.trade.report.templates.Report;
import com.mahe.trade.report.templates.SettlementReport;

/**
 * Java program to generate trade reports.
 *
 */
public class App {
  public static void main(String[] args) {
    int incomingTradeCount = 15;
    if(args.length > 0) {
      incomingTradeCount = Integer.valueOf(args[0]);
    }
    Queue<Trade> q = new ArrayBlockingQueue<Trade>(incomingTradeCount);

    SettlementReport sReport = new SettlementReport();
    RankingReport rReport = new RankingReport();

    /**
     * We can add as many report as we like here.
     */
    List<Report> reportsToGenerate = new ArrayList<>();
    reportsToGenerate.add(rReport);
    reportsToGenerate.add(sReport);

    ReportGenerator rg = new ReportGenerator(q, reportsToGenerate);

    IntStream.range(0, incomingTradeCount).forEach(i -> {
      Trade t = TradeGenerator.getTrade();
      System.out.println(t);
      q.add(t);
    });

    sReport.sleep(200);
    System.err.println("--------After Adjusting Settle Date----------");
    rg.generateReport();

    reportsToGenerate.stream().forEach(report -> {
      report.printReport();
    });
  }
}
