public class StockMonitor extends StockCustomer {
  private int threshold;
  private int start = 0, count = 0;

  public StockMonitor(String name, int threshold) throws Exception {
    super(name);
    if (threshold <= 0)
      throw new Exception("Invalid threshold!");
    else
      this.threshold = threshold;
  }

  public void priceChanged(PriceChangedEvent e) {
    this.event = e;
    start += event.getStatus();    
    checkthreshold();
  }

  private void checkthreshold() {
    count++;
    if (start == threshold) { 
      System.out.printf("\nStock price has gone up by %d in %d steps. Removing monitor %s ...\n", threshold, count, this.getName());
      event.getStock().removeObserver(this);
    }
    if (start == -threshold) {
      System.out.printf("\nStock price has gone down by %d in %d steps. Removing monitor %s ...\n", threshold, count, this.getName());
      event.getStock().removeObserver(this);
    }
  }
}