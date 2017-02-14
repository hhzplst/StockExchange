public class StockMonitor extends StockCustomer {
  private int threshold;

  public StockMonitor(String name, int threshold) {
    super(name);
    threshold = threshold;
  }

  public void priceChanged(PriceChangedEvent e) {
    //Monitor's way of handling the event
  }
}