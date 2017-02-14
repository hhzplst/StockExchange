public abstract class StockCustomer implements StockObserver {
  protected String name;
  public abstract void priceChanged(PriceChangedEvent e);

  public String getName() {
    return name;
  }
}