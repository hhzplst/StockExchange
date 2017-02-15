public class StockExchangeTest {
  public static void main(String[] args) {
    boolean allRemoved;
    StockExchange stock = new StockExchange();

    try {
      StockMonitor sm1 = new StockMonitor("StockMonitor1", 5);
      StockMonitor sm2 = new StockMonitor("StockMonitor2", 10);
      StockMonitor sm3 = new StockMonitor("StockMonitor3", 15);
      StockMonitor sm4 = new StockMonitor("StockMonitor4", 20);
      StockMonitor sm5 = new StockMonitor("StockMonitor5", 25); 


      stock.addObserver(sm1);
      stock.addObserver(sm2);
      stock.addObserver(sm3);
      stock.addObserver(sm4);
      stock.addObserver(sm5);
      stock.addObserver(new StockPricePrinter("StockPrinter"));

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

     Thread t = new Thread(stock);
     t.start();
  }
}

/************************************OUTPUT*************************************

➜  AssignmentB git:(master) ✗ java StockExchangeTest

Welcome, StockMonitor1. You are now registered.

Welcome, StockMonitor2. You are now registered.

Welcome, StockMonitor3. You are now registered.

Welcome, StockMonitor4. You are now registered.

Welcome, StockMonitor5. You are now registered.

Welcome, StockPrinter. You are now registered.

Stock price has gone down by 5 in 5 steps. Removing monitor StockMonitor1 ...

Bye, StockMonitor1. You are now unregistered.

Stock price has gone down by 10 in 52 steps. Removing monitor StockMonitor2 ...

Bye, StockMonitor2. You are now unregistered.

Stock price has gone down by 15 in 87 steps. Removing monitor StockMonitor3 ...

Bye, StockMonitor3. You are now unregistered.

Stock price has gone down by 20 in 140 steps. Removing monitor StockMonitor4 ...

Bye, StockMonitor4. You are now unregistered.

Stock price has gone down by 25 in 149 steps. Removing monitor StockMonitor5 ...

Bye, StockMonitor5. You are now unregistered.

***********************************END OUTPUT***********************************/