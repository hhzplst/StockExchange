public abstract class StockCustomer implements StockObserver {
  protected String name;
  public abstract void priceChanged(PriceChangedEvent e);

  public StockCustomer(String name) {
    name = name;
  }

  public String getName() {
    return name;
  }

  protected void setName(String newName) {
    name = newName;
  }
}