public class StockMonitor extends StockCustomer {
  private int threshold;
  private int start = 0, count = 0;
  private boolean hasReachedThreshold = false;

  public StockMonitor(String name, int threshold) throws Exception {
    super(name);
    if (threshold <= 0)
      throw new Exception("Invalid threshold!");
    else
      threshold = threshold;
  }

  public void priceChanged(PriceChangedEvent e) {
    event = e;
    start += event.status;    
    checkthreshold();
  }

  private void checkthreshold() {
    count++;
    if (start == threshold) { 
      System.out.printf("\nStock price has gone up by %d in %d steps. Removing monitor %s ...\n", threshold, count, this.getName());
      update();
    }
    if (start == -threshold) {
      System.out.printf("\nStock price has gone down by %d in %d steps. Removing monitor %s ...\n", threshold, count, this.getName());
      update();
    }
  }

  private void update() {
    hasReachedThreshold = true;
    event.stock.removeObserver(this);
  }

  public boolean ifReachedThreshold() {
    return hasReachedThreshold;
  }
}