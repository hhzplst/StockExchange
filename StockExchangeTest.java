public class StockExchangeTest {
  public static void main(String[] args) {
    StockExchange test = new StockExchange();

    StockMonitor a = new StockMonitor();
    test.addObserver(a);
    test.addObserver(a);


  }
}